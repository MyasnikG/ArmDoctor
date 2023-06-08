package com.armdoctor.service;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserDTO dto) throws APIException;

    List<UserEntity> getByUsername(String email) throws APIException;

    UserEntity verifyUser(String email, String verifyCode) throws APIException;

    UserEntity changePassword(String oldPassword, String newPassword, String confirmPassword, String email) throws APIException;

    UserEntity sendToken(String email) throws APIException;

    Boolean verifyToken(String email, String token) throws APIException;

    UserEntity forgotPassword(String email, String password, String confirmPassword) throws APIException;
}
