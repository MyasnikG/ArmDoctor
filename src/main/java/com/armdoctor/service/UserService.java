package com.armdoctor.service;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.UserEntity;

public interface UserService {

    UserEntity createUser(UserDTO dto) throws APIException;
}
