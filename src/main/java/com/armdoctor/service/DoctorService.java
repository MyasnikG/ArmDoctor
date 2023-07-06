package com.armdoctor.service;

import com.armdoctor.dto.requestdto.DoctorDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.DoctorEntity;

import java.util.List;

public interface DoctorService {

    DoctorEntity createUser(DoctorDTO dto) throws APIException;

    List<DoctorEntity> getByUsername(String email) throws APIException;

    List<DoctorEntity> getAll() throws APIException;

    DoctorEntity verifyUser(String email, String verifyCode) throws APIException;

    DoctorEntity changePassword(String oldPassword, String newPassword, String confirmPassword, String email) throws APIException;

    DoctorEntity sendToken(String email) throws APIException;

    Boolean verifyToken(String email, String token) throws APIException;

    DoctorEntity forgotPassword(String email, String password, String confirmPassword) throws APIException;


    DoctorEntity update(DoctorDTO doctorDTO) throws APIException;

    DoctorEntity bookTime(Integer id, String time) throws APIException;
    void delete(Integer id) throws APIException;
}
