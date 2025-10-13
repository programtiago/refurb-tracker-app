package com.devtiago.refurbtracker.refurb_rh.repository;

import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalEmployeeRepository extends JpaRepository<InternalEmployee, Long> {

    boolean existsByWorkerNo(String workerNo);
}
