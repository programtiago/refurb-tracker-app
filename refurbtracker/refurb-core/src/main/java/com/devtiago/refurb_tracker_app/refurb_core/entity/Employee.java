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
import java.time.temporal.ChronoUnit;

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
    private String department;
    private String function;
    private LocalDateTime createdAt;
    private LocalDate admissionDate;
    private String professionalEmail;
    private String personalEmail;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private EmployeeStatus employeeStatus = EmployeeStatus.AVAILABLE;
    private boolean status = true;

    public abstract int calculateVacationDays();

    //Calcular antiguidade de um certo empregado
    public long getMonthsOfSeniority(){
        return ChronoUnit.MONTHS.between(admissionDate, LocalDateTime.now());
    }

    //Verificar se é o dia de aniversário do colaborador
    public boolean isBirthdayMonth(){
        return LocalDateTime.now().getMonth() == birthdayDate.getMonth();
    }
}
