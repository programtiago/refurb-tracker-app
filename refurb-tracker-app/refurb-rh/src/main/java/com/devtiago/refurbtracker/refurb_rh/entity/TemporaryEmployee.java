package com.devtiago.refurbtracker.refurb_rh.entity;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "TB_TEMPORARY_EMPLOYEE")
public class TemporaryEmployee extends Employee {

    private String eloCode;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String hiringEmploymentCompany;
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    @Builder.Default
    private EmployeeType employeeType = EmployeeType.TEMPORARY;

    @PrePersist
    protected void onCreate(){
        this.employeeType = EmployeeType.TEMPORARY;
    }

    /*
    @Override
    public void setDisplayName() {
        this.setDisplayName("[" + this.eloCode + "]-" + this.getFirstName() + " " + this.getLastName());
    }
     */
}
