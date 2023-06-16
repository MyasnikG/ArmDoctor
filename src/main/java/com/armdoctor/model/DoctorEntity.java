package com.armdoctor.model;

import com.armdoctor.enums.Role;
import com.armdoctor.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class DoctorEntity {

    @Id
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;
    private Integer year;
    private String email;
    private String password;

    @Column(name = "verification_code")
    private String verifyCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "reset_token")
    private String resetToken;

    private String profession;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "book_time")
    private String bookTime;

    @ManyToMany
    @JoinColumns(value = {@JoinColumn(name = "hospital_id",referencedColumnName = "")})
    private List<HospitalEntity> hospitalEntities;
}
