package com.armdoctor.controller;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.model.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/create-user")
    public UserEntity createUser(@RequestBody UserDTO userDTO){
       return null;
    }

}
