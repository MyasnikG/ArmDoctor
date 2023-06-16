package com.armdoctor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DoctorValidationException extends RuntimeException{

    public DoctorValidationException(String message){
        super(message);
    }
}
