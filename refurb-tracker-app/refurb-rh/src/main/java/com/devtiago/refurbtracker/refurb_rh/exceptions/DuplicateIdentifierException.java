package com.devtiago.refurbtracker.refurb_rh.exceptions;

import com.devtiago.refurbtracker.refurb_core.exceptions.EmployeeException;

public class DuplicateIdentifierException extends EmployeeException {
    public DuplicateIdentifierException(String property, String propertyValue) {
        super(
                String.format("Employee with the %s %s already exists.", property, propertyValue),
                "Duplicate " + property.toLowerCase()
        );
    }
}
