package com.armdoctor.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private int errorCode;

    public ErrorResponse(String message){
        this.message=message;
    }
}
