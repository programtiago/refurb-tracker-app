package com.devtiago.refurbtracker.refurb_core.repository;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
