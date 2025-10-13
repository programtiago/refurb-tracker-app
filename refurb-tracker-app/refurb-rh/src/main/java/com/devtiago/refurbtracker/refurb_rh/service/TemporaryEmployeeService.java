package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.repository.TemporaryEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemporaryEmployeeService {

    private final TemporaryEmployeeRepository temporaryEmployeeRepository;

    public List<TemporaryEmployee> findAll(){
        return temporaryEmployeeRepository.findAll();
    }
}
