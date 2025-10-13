package com.devtiago.refurbtracker.refurb_core.exceptions;

import lombok.Getter;

@Getter
public abstract class EmployeeException extends RuntimeException {

    private final String errorCode;
    public EmployeeException(String message){
        super(message);
        this.errorCode = "EMPLOYEE_ERROR";
    }

    public EmployeeException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
