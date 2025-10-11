package com.devtiago.refurb_tracker_app.refurbtracker.entity;

import com.devtiago.refurb_tracker_app.refurb_core.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_TEMPORARY_EMPLOYEE")
public class TemporaryEmployee extends Employee {

    private String eloCode;

    @Override
    public int calculateVacationDays() {
        return 21;
    }
}
