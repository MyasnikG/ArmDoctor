package com.armdoctor.dto.requestdto;

import com.armdoctor.enums.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer year;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
