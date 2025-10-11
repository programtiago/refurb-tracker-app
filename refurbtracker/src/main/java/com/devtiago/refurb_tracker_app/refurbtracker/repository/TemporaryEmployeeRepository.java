package com.devtiago.refurb_tracker_app.refurbtracker.repository;

import com.devtiago.refurb_tracker_app.refurbtracker.entity.TemporaryEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporaryEmployeeRepository extends JpaRepository<TemporaryEmployee, Long>{
}
