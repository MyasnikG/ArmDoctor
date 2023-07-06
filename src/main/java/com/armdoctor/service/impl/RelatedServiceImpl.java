package com.armdoctor.service.impl;

import com.armdoctor.dto.responsedto.DoctorResponseDTO;
import com.armdoctor.model.DoctorEntity;
import com.armdoctor.repository.DoctorRepository;
import com.armdoctor.repository.RelatedRepository;
import com.armdoctor.service.RelatedService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatedServiceImpl implements RelatedService {

    @Autowired
    private RelatedRepository relatedRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<DoctorResponseDTO> getByHospitalId(Integer hospitalID) {

        List<Integer> doctorIds = relatedRepository.getByHospital_id(hospitalID);
        List<DoctorEntity> doctorEntityList = doctorRepository.findAll();

        List<DoctorEntity> doctorEntities = new ArrayList<>();
        for (Integer x : doctorIds) {

            List<DoctorEntity> collect = doctorEntityList
                    .stream()
                    .filter(obj -> obj.getId().equals(x))
                    .collect(Collectors.toList());

            doctorEntities.addAll(collect);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<DoctorResponseDTO> o = objectMapper.convertValue(doctorEntities, new TypeReference<List<DoctorResponseDTO>>() {
        });
        return o;
    }
}
