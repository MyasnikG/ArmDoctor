package com.armdoctor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class APIException extends Exception{

    public APIException(String message){
        super(message);
    }
}
