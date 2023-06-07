package com.armdoctor.repository;

import com.armdoctor.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> getByEmail(String email);

    UserEntity getByEmailAndVerifyCode(String email, String verifyCode);

    UserEntity getByEmailAndIdNot(String email, Integer id);

    UserEntity findByEmail(String email);

}
