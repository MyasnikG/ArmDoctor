package com.armdoctor.controller;

import com.armdoctor.dto.requestdto.HospitalDTO;
import com.armdoctor.exceptions.APIException;
import com.armdoctor.model.HospitalEntity;
import com.armdoctor.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @PostMapping("/add-hospital")
    @ResponseStatus(HttpStatus.CREATED)
    public HospitalEntity addHospital(@RequestBody HospitalDTO dto) throws APIException {

        return hospitalService.addHospital(dto);
    }

    @GetMapping("/get-all")
    public List<HospitalEntity> getAll(@RequestParam(required = false) String name) throws APIException {
        return hospitalService.getAll(name);
    }
}