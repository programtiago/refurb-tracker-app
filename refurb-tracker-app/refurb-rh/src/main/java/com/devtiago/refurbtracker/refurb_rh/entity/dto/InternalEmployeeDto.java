package com.devtiago.refurbtracker.refurb_rh.entity.dto;

import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InternalEmployeeDto(
    Long id,
    @NotBlank(message = "The field 'firstName' is mandatory.")
    @Size(min = 3, max = 10, message = "The field 'firstName' must be between 3 and 10 characters.")
    String firstName,
    @NotBlank(message = "The field 'lastName' is mandatory.")
    @Size(min = 3, max = 15, message = "The field 'lastName' must be between 3 and 15 characters.")
    String lastName,
    @NotNull(message = "The field 'birthdayDate' is mandatory.")
    LocalDate birthdayDate,
    @NotBlank(message = "The field 'department' is mandatory.")
    String department,
    @NotBlank(message = "The field 'position' is mandatory.")
    String position,
    @NotNull(message = "The field 'admissionDate' is mandatory.")
    LocalDate admissionDate,
    @NotNull(message = "The field 'registryDate' is mandatory.")
    LocalDateTime registryDate,
    @NotNull(message = "The field 'status' is mandatory.")
    StatusEmployee status,
    @NotBlank(message = "The field 'workerNo' is mandatory.")
    String workerNo,
    @NotNull(message = "The field 'employeeType' is mandatory.")
    EmployeeType employeeType,
    String displayName
) { }
