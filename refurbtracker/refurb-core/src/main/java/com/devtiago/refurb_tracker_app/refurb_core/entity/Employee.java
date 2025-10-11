package com.devtiago.refurb_tracker_app.refurb_core.entity;

import com.devtiago.refurb_tracker_app.refurb_core.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "TB_EMPLOYEE")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdayDate;
    private LocalDateTime createdAt;
    private LocalDate admissionDate;
    private String professionalEmail;
    private String personalEmail;
    private EmployeeStatus employeeStatus = EmployeeStatus.AVAILABLE;
    private boolean status = true;
}
