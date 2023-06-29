package com.armdoctor.dto.responsedto;

import com.armdoctor.enums.Role;
import com.armdoctor.enums.Status;
import com.armdoctor.model.HospitalEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({})
public class DoctorResponseDTO {

    @JsonProperty("user_id")
    private Integer id;

    @JsonProperty("first_name")
    private String name;

    @JsonProperty("last_name")
    private String surname;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("verification_code")
    private String verifyCode;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonProperty("reset_token")
    private String resetToken;

    @JsonProperty("profession")
    private String profession;

    @JsonProperty("work_time")
    private String workTime;

    @JsonProperty("book_time")
    private String bookTime;

    @ManyToMany
    @JoinTable(name = "related",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "hospital_id"))

    private Set<HospitalEntity> hospitals;
}
