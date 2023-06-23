package com.armdoctor.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="related")
@Data
public class Related implements Serializable {


    @Id
    private int ID;
    @ManyToOne
    @JoinColumn(name="user_id")
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private HospitalEntity hospitalEntity;


}
