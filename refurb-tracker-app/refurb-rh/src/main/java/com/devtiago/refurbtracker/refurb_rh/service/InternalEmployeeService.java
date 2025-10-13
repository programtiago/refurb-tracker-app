package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import com.devtiago.refurbtracker.refurb_rh.repository.InternalEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmployeeService {

    private final InternalEmployeeRepository internalEmployeeRepository;

    public List<InternalEmployee> findAll(){
        return internalEmployeeRepository.findAll();
    }
}
