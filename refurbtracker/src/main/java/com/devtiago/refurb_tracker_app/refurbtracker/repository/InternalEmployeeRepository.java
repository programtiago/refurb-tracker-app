package com.devtiago.refurb_tracker_app.refurbtracker.repository;

import com.devtiago.refurb_tracker_app.refurbtracker.entity.InternalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalEmployeeRepository extends JpaRepository<InternalEmployee, Long> {
}
