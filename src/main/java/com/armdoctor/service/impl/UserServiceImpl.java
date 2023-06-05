package com.armdoctor.service.impl;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.enums.Status;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.exceptions.ResourceAlreadyExistsException;
import com.armdoctor.exceptions.UserValidationException;
import com.armdoctor.model.UserEntity;
import com.armdoctor.repository.UserRepository;
import com.armdoctor.service.UserService;
import com.armdoctor.util.ArmDoctorMailSender;
import com.armdoctor.util.TokenGenerate;
import com.armdoctor.util.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArmDoctorMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserDTO dto) throws APIException {
        UserValidation.validateFields(dto);
        UserValidation.validatePassword(dto.getPassword());

        String verifyCode = TokenGenerate.generateVerifyCode();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(0);
        userEntity.setName(dto.getName());
        userEntity.setSurname(dto.getSurname());
        userEntity.setYear(dto.getYear());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setVerifyCode(verifyCode);
        userEntity.setStatus(Status.INACTIVE);
        userEntity.setRole(dto.getRole());

        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new APIException("Problem during saving the user");
        }

        mailSender.sendEmail(dto.getEmail(), "Your verification code", "Your verification code is: " + verifyCode);
        return userEntity;
    }

    @Override
    public List<UserEntity> getByUsername(String email) throws APIException {
        List<UserEntity> entityList = null;
        try {
            entityList = userRepository.getByEmail(email);
        } catch (Exception e) {
            throw new APIException("Problem during getting the user");
        }
        return entityList;
    }

    @Override
    public UserEntity verifyUser(String email, String verifyCode) throws APIException {
        UserEntity userEntity = null;
        try {
            userEntity = userRepository.getByEmailAndVerifyCode(email, verifyCode);
            if (userEntity == null) {
                throw new UserValidationException("Wrong verification code " + verifyCode);
            }
            userEntity.setStatus(Status.ACTIVE);
            userEntity.setVerifyCode(null);

            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new APIException("Problem during verifying the user");
        }
        return userEntity;
    }

    private void validateDuplicate(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            List<UserEntity> userEntityList = userRepository.getByEmail(userDTO.getEmail());
            if (userEntityList.isEmpty()) {
                throw new ResourceAlreadyExistsException("User already exists");
            }
        } else {
            UserEntity userEntity = userRepository.getByEmailAndIdNot(userDTO.getEmail(), userDTO.getId());
            if (userEntity != null) {
                throw new ResourceAlreadyExistsException("User's email already exists");
            }
        }
    }
}