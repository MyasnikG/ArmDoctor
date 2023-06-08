package com.armdoctor.controller;

import com.armdoctor.dto.requestdto.UserDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.UserEntity;
import com.armdoctor.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @PatchMapping("/change-password")
    public UserEntity changePassword(@RequestParam String oldPassword,
                                     @RequestParam String newPassword,
                                     @RequestParam String confirmPassword, Principal principal) throws APIException {

        String email = principal.getName();
        return userService.changePassword(oldPassword, newPassword, confirmPassword, email);
    }

    @PatchMapping("/send-reset-token")
    public UserEntity sendResetToken(@RequestParam String email) throws APIException {
        return userService.sendToken(email);
    }

    @GetMapping("/verify-reset-token")
    public Boolean verifyResetToken(@RequestParam String email, @RequestParam String token) throws APIException {
        return userService.verifyToken(email, token);
    }

    @PatchMapping("/forgot-password")
    public UserEntity forgotPassword(@RequestParam String email,
                                     @RequestParam String password, @RequestParam String confirmPassword) throws APIException {

        return userService.forgotPassword(email, password, confirmPassword);
    }

}
