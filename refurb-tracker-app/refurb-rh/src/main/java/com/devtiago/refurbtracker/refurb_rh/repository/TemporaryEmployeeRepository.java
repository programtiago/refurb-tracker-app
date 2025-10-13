package com.devtiago.refurbtracker.refurb_rh.repository;

import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporaryEmployeeRepository extends JpaRepository<TemporaryEmployee, Long> {

    boolean existsByEloCode(String eloCode);
}
