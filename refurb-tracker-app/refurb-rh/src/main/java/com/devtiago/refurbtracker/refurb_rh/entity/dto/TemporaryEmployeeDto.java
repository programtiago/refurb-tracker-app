package com.devtiago.refurbtracker.refurb_rh.entity.dto;

import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TemporaryEmployeeDto(
    Long id,
    String firstName,
    String lastName,
    LocalDate birthdayDate,
    String department,
    String position,
    LocalDate admissionDate,
    LocalDateTime registryDate,
    StatusEmployee status,
    String eloCode,
    LocalDate contractStartDate,
    LocalDate contractEndDate,
    String hiringEmploymentCompany,
    EmployeeType employeeType,
    String displayName
) { }
