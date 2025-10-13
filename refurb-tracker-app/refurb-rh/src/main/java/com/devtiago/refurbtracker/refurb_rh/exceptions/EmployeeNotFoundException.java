package com.devtiago.refurbtracker.refurb_rh.exceptions;

import com.devtiago.refurbtracker.refurb_core.exceptions.EmployeeException;

public class EmployeeNotFoundException extends EmployeeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee resource not found with the id " + id, "EMPLOYEE_NOT_FOUND");
    }
}
