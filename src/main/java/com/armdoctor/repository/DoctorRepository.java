package com.armdoctor.repository;

import com.armdoctor.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {

    List<DoctorEntity> getByEmail(String email);

    DoctorEntity getByEmailAndVerifyCode(String email, String verifyCode);

    DoctorEntity getByEmailAndIdNot(String email, Integer id);

    DoctorEntity findByEmail(String email);


    @Override
    Optional<DoctorEntity> findById(Integer id);
}
