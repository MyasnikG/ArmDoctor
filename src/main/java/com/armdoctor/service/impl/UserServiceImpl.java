package com.armdoctor.service.impl;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.enums.Status;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.exceptions.UserValidationException;
import com.armdoctor.model.UserEntity;
import com.armdoctor.repository.UserRepository;
import com.armdoctor.service.UserService;
import com.armdoctor.util.ArmDoctorMailSender;
import com.armdoctor.util.TokenGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArmDoctorMailSender mailSender;

    @Override
    public UserEntity createUser(UserDTO dto) throws APIException {
        validateFields(dto);
        validatePassword(dto);

        String verifyCode = TokenGenerate.generateVerifyCode();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(0);
        userEntity.setName(dto.getName());
        userEntity.setSurname(dto.getSurname());
        userEntity.setYear(dto.getYear());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
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

    private void validateFields(UserDTO userDTO) {
        if (userDTO.getName() == null || userDTO.getName().isBlank()) {
            throw new UserValidationException("User's name cannot be null or empty");
        }

        if (userDTO.getSurname() == null || userDTO.getSurname().isBlank()) {
            throw new UserValidationException("User's surname cannot be null or empty");
        }

        if (userDTO.getYear() == null || userDTO.getYear() < 1910 || userDTO.getYear() > 2020) {
            throw new UserValidationException("User's age must be between 1910 - 2020");
        }
    }


    private void validatePassword(UserDTO userDTO) {
        String password = userDTO.getPassword();
        if (password == null || password.isBlank()) {
            throw new UserValidationException("Password cannot be null or empty");
        }
        if (password.length() < 6) {
            throw new UserValidationException("Password is short");
        }


        int countOfUppercase = 0;
        int countOfDigit = 0;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                countOfDigit++;
            } else if (Character.isUpperCase(c)) {
                countOfUppercase++;
            }
        }

        if (countOfUppercase < 1) {
            throw new UserValidationException("Password must contain at least 1 uppercase letter");
        }

        if (countOfDigit < 2) {
            throw new UserValidationException("Password must contain at least 2 digits");
        }
    }
}
