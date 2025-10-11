package com.devtiago.refurb_tracker_app.refurb_core.repository;

import com.devtiago.refurb_tracker_app.refurb_core.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
