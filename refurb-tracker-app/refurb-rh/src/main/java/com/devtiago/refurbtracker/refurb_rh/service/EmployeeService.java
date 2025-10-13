package com.devtiago.refurbtracker.refurb_rh.service;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;
import com.devtiago.refurbtracker.refurb_core.repository.EmployeeRepository;
import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.InternalEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.TemporaryEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.exceptions.DuplicateIdentifierException;
import com.devtiago.refurbtracker.refurb_rh.exceptions.EmployeeNotFoundException;
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

    public InternalEmployeeDto findInternalEmployeeById(Long id){
        InternalEmployee employee = internalEmployeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return employeeMapper.toInternalEmployeeDto(employee);
    }

    public TemporaryEmployeeDto findTemporaryEmployeeById(Long id){
        TemporaryEmployee employee = temporaryEmployeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return employeeMapper.toTemporaryEmployeeDto(employee);
    }

    public void updateEmployee(Long id, InternalEmployeeDto employee){
        InternalEmployee employeeToUpdate = employeeMapper.toInternalEmployeeEntity(findInternalEmployeeById(id));

        employeeToUpdate.setFirstName(employee.firstName());
        employeeToUpdate.setLastName(employee.lastName());
        employeeToUpdate.setBirthdayDate(employee.birthdayDate());
        employeeToUpdate.setDepartment(employee.department());
        employeeToUpdate.setPosition(employee.position());
        employeeToUpdate.setStatus(employee.status());

        if (employeeToUpdate.getStatus() != StatusEmployee.AVAILABLE){
            employeeToUpdate.setActive(false);
        }
        employeeToUpdate.setWorkerNo(employee.workerNo());

        internalEmployeeRepository.save(employeeToUpdate);
    }

    public void updateEmployee(Long id, TemporaryEmployeeDto employee) {
        TemporaryEmployee existingEmployee = employeeMapper.toTemporaryEmployeeEntity(findTemporaryEmployeeById(id));
        TemporaryEmployee updated = employeeMapper.toTemporaryEmployeeEntity(employee);

        updateCommonFields(existingEmployee, updated);

        if (updated.getStatus() != StatusEmployee.AVAILABLE){
            updated.setActive(false);
        }

        updated.setEloCode(employee.eloCode());
        updated.setContractStartDate(employee.contractStartDate());
        updated.setContractEndDate(employee.contractEndDate());
        updated.setHiringEmploymentCompany(employee.hiringEmploymentCompany());

        temporaryEmployeeRepository.save(updated);
    }

    //Método útil para campos em comum
    private void updateCommonFields(Employee existing, Employee updated) {
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setBirthdayDate(updated.getBirthdayDate());
        existing.setDepartment(updated.getDepartment());
        existing.setPosition(updated.getPosition());
        existing.setStatus(updated.getStatus());
        existing.setActive(updated.getStatus() == StatusEmployee.AVAILABLE);
    }
}
