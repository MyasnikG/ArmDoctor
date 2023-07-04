package com.armdoctor.service.impl;

import antlr.Token;
import com.armdoctor.dto.requestdto.HospitalDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.HospitalEntity;
import com.armdoctor.repository.HospitalRepository;
import com.armdoctor.service.HospitalService;
import com.armdoctor.util.ArmDoctorMailSender;
import com.armdoctor.util.TokenGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ArmDoctorMailSender doctorMailSender;

    @Override
    public HospitalEntity addHospital(HospitalDTO dto) throws APIException {

        String password = TokenGenerate.generatePassword();
        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId(0);
        hospitalEntity.setName(dto.getName());
        hospitalEntity.setEmail(dto.getEmail());
        hospitalEntity.setPassword(passwordEncoder.encode(password));
        hospitalEntity.setAddress(dto.getAddress());

        try {
            hospitalRepository.save(hospitalEntity);
        } catch (Exception e) {
            throw new APIException("Problem during saving the hospital");
        }
        doctorMailSender.sendEmail(dto.getEmail(), "Your account password", password);
        return hospitalEntity;
    }

    @Override
    public List<HospitalEntity> getAll(String name) throws APIException {
        List<HospitalEntity> hospitalEntities = new ArrayList<>();
        try {
            if (name == null) {
                hospitalEntities = hospitalRepository.findAll();
            } else {
                hospitalEntities = hospitalRepository.findByName(name);
            }
        } catch (Exception e) {
            throw new APIException("Problem during getting hospitals");
        }
        return hospitalEntities;
    }
}
