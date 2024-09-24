package com.armdoctor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "related")
@Getter
@Setter
@IdClass(Related.class)

public class Related implements Serializable {

    @Id
    private Integer user_id;

    @Id
    private Integer hospital_id;
}
