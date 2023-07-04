package com.armdoctor.repository;

import com.armdoctor.model.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {

    HospitalEntity getByName(String name);

    List<HospitalEntity> findByName(String name);
}
