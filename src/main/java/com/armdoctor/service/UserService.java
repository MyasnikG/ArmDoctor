package com.armdoctor.service;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserDTO dto) throws APIException;

    List<UserEntity> getByUsername(String email) throws APIException;
}
