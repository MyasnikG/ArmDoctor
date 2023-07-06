package com.armdoctor.repository;

import com.armdoctor.model.Related;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatedRepository  extends JpaRepository<Related,Integer> {

    @Query(nativeQuery = true, value="select user_id from related where hospital_id=?1")
    List<Integer> getByHospital_id(Integer hospitalID);
}
