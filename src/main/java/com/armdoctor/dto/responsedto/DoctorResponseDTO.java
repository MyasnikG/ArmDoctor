package com.armdoctor.dto.responsedto;

import com.armdoctor.enums.Role;
import com.armdoctor.enums.Status;
import com.armdoctor.model.HospitalEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties
public class DoctorResponseDTO {

    @JsonIgnore
    private Integer id;

    @JsonProperty("first_name")
    private String name;

    @JsonProperty("last_name")
    private String surname;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("email")
    private String email;

   @JsonIgnore
    private String password;

    @JsonIgnore
    private String verifyCode;

    @JsonIgnore
    private Status status;

    @JsonIgnore
    private Role role;

    @JsonIgnore
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

    @JsonIgnore
    private Set<HospitalEntity> hospitals;
}
