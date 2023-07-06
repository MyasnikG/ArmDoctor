package com.armdoctor.controller;

import com.armdoctor.dto.requestdto.DoctorDTO;
import com.armdoctor.dto.responsedto.DoctorResponseDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.DoctorEntity;
import com.armdoctor.service.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl userService;

    @PostMapping("/create-user")
    public DoctorEntity createUser(@RequestBody DoctorDTO doctorDTO) throws APIException {
        DoctorEntity user = userService.createUser(doctorDTO);
        return user;
    }

    @GetMapping("/get-by-username")
    public List<DoctorEntity> getByUsername(@RequestParam String email) throws APIException {
        return userService.getByUsername(email);
    }

    @PatchMapping("/verify")
    public DoctorEntity verifyUser(@RequestParam String email, @RequestParam String verifyCode) throws APIException {
        return userService.verifyUser(email, verifyCode);
    }

    @PatchMapping("/change-password")
    public DoctorEntity changePassword(@RequestParam String oldPassword,
                                       @RequestParam String newPassword,
                                       @RequestParam String confirmPassword, Principal principal) throws APIException {

        String email = principal.getName();
        return userService.changePassword(oldPassword, newPassword, confirmPassword, email);
    }

    @PatchMapping("/send-reset-token")
    public DoctorEntity sendResetToken(@RequestParam String email) throws APIException {
        return userService.sendToken(email);
    }

    @GetMapping("/verify-reset-token")
    public Boolean verifyResetToken(@RequestParam String email, @RequestParam String token) throws APIException {
        return userService.verifyToken(email, token);
    }

    @PatchMapping("/forgot-password")
    public DoctorEntity forgotPassword(@RequestParam String email,
                                       @RequestParam String password, @RequestParam String confirmPassword) throws APIException {

        return userService.forgotPassword(email, password, confirmPassword);
    }

    @PutMapping("/update")
    public DoctorEntity update(@RequestBody DoctorDTO doctorDTO) throws APIException {
        return userService.update(doctorDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) throws APIException {
        userService.delete(id);
    }

    @GetMapping("/get-all")
    public List<DoctorEntity> getAll() throws APIException {
        return userService.getAll();
    }

    @PatchMapping("/book-time/{id}")
    public DoctorEntity bookTime(@PathVariable Integer id, @RequestParam String bookTime, @RequestParam boolean isCancelled) throws APIException {
        return userService.bookTime(id, bookTime, isCancelled);
    }

    @GetMapping("/get-by-profession")
    public List<DoctorResponseDTO> getByProfession(@RequestParam String profession) throws APIException {
        return userService.getByProfession(profession);
    }

}
