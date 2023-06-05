package com.armdoctor.controller;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.UserEntity;
import com.armdoctor.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create-user")
    public UserEntity createUser(@RequestBody UserDTO userDTO) throws APIException {
        UserEntity user = userService.createUser(userDTO);
        return user;
    }

    @GetMapping("/get-by-username")
    public List<UserEntity> getByUsername(@RequestParam String email) throws APIException {
        return userService.getByUsername(email);
    }

    @PatchMapping("/verify")
    public UserEntity verifyUser(@RequestParam String email, @RequestParam String verifyCode) throws APIException {
        return userService.verifyUser(email, verifyCode);
    }

}
