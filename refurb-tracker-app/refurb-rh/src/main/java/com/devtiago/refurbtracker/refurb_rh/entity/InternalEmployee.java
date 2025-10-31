package com.devtiago.refurbtracker.refurb_rh.entity;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "TB_INTERNAL_EMPLOYEE")
public class InternalEmployee extends Employee {

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    @Builder.Default
    private EmployeeType employeeType = EmployeeType.INTERNAL;

    @PrePersist
    protected void onCreate(){
        this.employeeType = EmployeeType.INTERNAL;
    }
}
