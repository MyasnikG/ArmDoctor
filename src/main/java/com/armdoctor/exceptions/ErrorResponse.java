package com.armdoctor.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int errorCode;
    private List<String> details;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ErrorResponse(String message, int errorCode, List<String> details) {
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }
}
