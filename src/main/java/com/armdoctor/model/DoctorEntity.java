package com.armdoctor.model;

import com.armdoctor.enums.Role;
import com.armdoctor.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;
    private Integer year;
    @Email(message = "Invalid email format!")
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
    private String bookTime = "0";

    @ManyToMany
    @JoinTable(name = "related",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "hospital_id"))

    private Set<HospitalEntity> hospitals;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
