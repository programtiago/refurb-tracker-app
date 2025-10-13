package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_core.repository.EmployeeRepository;
import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.InternalEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.TemporaryEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.exceptions.DuplicateIdentifierException;
import com.devtiago.refurbtracker.refurb_rh.repository.InternalEmployeeRepository;
import com.devtiago.refurbtracker.refurb_rh.repository.TemporaryEmployeeRepository;
import com.devtiago.refurbtracker.refurb_rh.utils.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TemporaryEmployeeRepository temporaryEmployeeRepository;
    private final InternalEmployeeRepository internalEmployeeRepository;

    private final EmployeeMapper employeeMapper;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public List<InternalEmployeeDto> findAllInternEmployees(){
        return employeeMapper.toInternalEmployeeDtoList(internalEmployeeRepository.findAll());
    }

    public List<TemporaryEmployeeDto> findAllTemporaryEmployees(){
        return employeeMapper.toTemporaryEmployeeDtoList(temporaryEmployeeRepository.findAll());
    }

    public InternalEmployeeDto createNewEmployee(InternalEmployeeDto employee){
        InternalEmployee internalEmployeeToSave = employeeMapper.onCreate(employee);

        if (internalEmployeeRepository.existsByWorkerNo(internalEmployeeToSave.getWorkerNo())){
            throw new DuplicateIdentifierException("worker number", internalEmployeeToSave.getWorkerNo());
        }

        InternalEmployee savedInternalEmployee = internalEmployeeRepository.save(internalEmployeeToSave);

        return employeeMapper.toInternalEmployeeDto(savedInternalEmployee);
    }

    public TemporaryEmployeeDto createNewEmployee(TemporaryEmployee employee){
        TemporaryEmployeeDto temporaryEmployeeToSave = employeeMapper.toTemporaryEmployeeDto(employee);

        if (temporaryEmployeeRepository.existsByEloCode(temporaryEmployeeToSave.eloCode())){
            throw new DuplicateIdentifierException("elo Code", temporaryEmployeeToSave.eloCode());
        }

        TemporaryEmployee savedTemporaryEmployee = temporaryEmployeeRepository.save(employeeMapper.toTemporaryEmployeeEntity(temporaryEmployeeToSave));

        return employeeMapper.onCreate(savedTemporaryEmployee);
    }
}
