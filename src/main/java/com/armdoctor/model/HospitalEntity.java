package com.armdoctor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hospital")
public class HospitalEntity {

    @Id
    @Column(name = "hospital_id")
    private Integer hospitalId;
    private String name;
    private String address;

    @ManyToMany(mappedBy = "hospitalEntities")

    Set<DoctorEntity> doctorEntity;

}
