package com.devtiago.refurbtracker.refurb_rh.entity.dto;

import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TemporaryEmployeeDto(
    Long id,
    @NotBlank(message = "The field 'firstName' is mandatory.")
    @Size(min = 3, max = 10, message = "The field 'firstName' must be between 3 and 10 characters.")
    String firstName,
    @NotBlank(message = "The field 'lastName' is mandatory.")
    @Size(min = 3, max = 15, message = "The field 'lastName' must be between 3 and 15 characters.")
    String lastName,
    @NotNull(message = "The field 'birthdayDate' is mandatory.")
    LocalDate birthdayDate,
    @NotBlank(message = "The field 'workerNo' is mandatory.")
    String workerNo,
    @NotBlank(message = "The field 'department' is mandatory.")
    String department,
    @NotBlank(message = "The field 'position' is mandatory.")
    String position,
    @NotNull(message = "The field 'admissionDate' is mandatory.")
    LocalDate admissionDate,
    @NotNull(message = "The field 'contractStartDate' is mandatory.")
    LocalDate contractStartDate,
    @NotNull(message = "The field 'contractEndDate' is mandatory.")
    LocalDate contractEndDate,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    LocalDateTime registryDate,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    StatusEmployee status,
    @NotBlank(message = "The field 'hiringEmploymentCompany' is mandatory.")
    String hiringEmploymentCompany,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    EmployeeType employeeType,
    String displayName,
    @NotBlank(message = "The field 'phone_number' is mandatory.")
    String phoneNumber
) { }
