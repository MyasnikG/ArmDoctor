package com.armdoctor.dto.requestdto;

import com.armdoctor.enums.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
public class DoctorDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer year;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    private String profession;
    private String workTime;
    private List<String> hospitals;
}
