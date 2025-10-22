package com.devtiago.refurbtracker.refurb_rh.utils.mapper;

import com.devtiago.refurbtracker.refurb_core.enums.EmployeeType;
import com.devtiago.refurbtracker.refurb_core.enums.StatusEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.InternalEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.TemporaryEmployeeDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmployeeMapper {
    public InternalEmployeeDto toInternalEmployeeDto(InternalEmployee employee){
        if (employee == null) return null;

        return new InternalEmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthdayDate(),
                employee.getDepartment(),
                employee.getPosition(),
                employee.getAdmissionDate(),
                employee.getCreatedAt(),
                employee.getStatus(),
                employee.getWorkerNo(),
                employee.getEmployeeType(),
                employee.getDisplayName(),
                employee.getPhoneNumber()
        );
    }

    public TemporaryEmployeeDto toTemporaryEmployeeDto(TemporaryEmployee employee){
        if (employee == null) return null;

        return new TemporaryEmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthdayDate(),
                employee.getDepartment(),
                employee.getPosition(),
                employee.getAdmissionDate(),
                employee.getCreatedAt(),
                employee.getStatus(),
                employee.getEloCode(),
                employee.getContractStartDate(),
                employee.getContractEndDate(),
                employee.getHiringEmploymentCompany(),
                employee.getEmployeeType(),
                employee.getDisplayName(),
                employee.getPhoneNumber()
        );
    }

    public InternalEmployee toInternalEmployeeEntity(InternalEmployeeDto employee){
        InternalEmployee obj = new InternalEmployee();

        if (employee.id() != null){
            obj.setId(employee.id());
        }

        obj.setFirstName(employee.firstName());
        obj.setLastName(employee.lastName());
        obj.setBirthdayDate(employee.birthdayDate());
        obj.setDepartment(employee.department());
        obj.setPosition(employee.position());
        obj.setAdmissionDate(employee.admissionDate());
        obj.setCreatedAt(employee.registryDate());
        obj.setStatus(employee.status());
        obj.setWorkerNo(employee.workerNo());
        obj.setEmployeeType(employee.employeeType());

        return obj;
    }

    public TemporaryEmployee toTemporaryEmployeeEntity(TemporaryEmployeeDto employee){
        TemporaryEmployee obj = new TemporaryEmployee();

        if (employee.id() != null){
            obj.setId(employee.id());
        }

        obj.setFirstName(employee.firstName());
        obj.setLastName(employee.lastName());
        obj.setBirthdayDate(employee.birthdayDate());
        obj.setDepartment(employee.department());
        obj.setPosition(employee.position());
        obj.setAdmissionDate(employee.admissionDate());
        obj.setCreatedAt(employee.registryDate());
        obj.setStatus(employee.status());
        obj.setEloCode(employee.eloCode());
        obj.setContractStartDate(employee.contractStartDate());
        obj.setContractEndDate(employee.contractEndDate());
        obj.setHiringEmploymentCompany(employee.hiringEmploymentCompany());
        obj.setEmployeeType(employee.employeeType());

        return obj;
    }

    public InternalEmployee toEntityOnCreateInternalEmployee(InternalEmployeeDto employeeDto){
        InternalEmployee employee = new InternalEmployee();

        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setBirthdayDate(employeeDto.birthdayDate());
        employee.setDepartment(employeeDto.department());
        employee.setPosition(employeeDto.position());
        employee.setAdmissionDate(employeeDto.admissionDate());
        employee.setWorkerNo(employeeDto.workerNo());
        employee.setPhoneNumber(employeeDto.phoneNumber());

        employee.setCreatedAt(LocalDateTime.now());
        employee.setEmployeeType(EmployeeType.INTERNAL);
        employee.setStatus(StatusEmployee.AVAILABLE);
        employee.setActive(true);

        employee.setDisplayName("[" + employeeDto.workerNo() + "]-" + employeeDto.firstName() + " " + employeeDto.lastName());

        return employee;
    }

    public TemporaryEmployee toEntityOnCreateTemporaryEmployee(TemporaryEmployeeDto employeeDto){
        TemporaryEmployee employee = new TemporaryEmployee();

        employee.setFirstName(employeeDto.firstName());
        employee.setLastName(employeeDto.lastName());
        employee.setBirthdayDate(employeeDto.birthdayDate());
        employee.setDepartment(employeeDto.department());
        employee.setPosition(employeeDto.position());
        employee.setAdmissionDate(employeeDto.admissionDate());
        employee.setEloCode(employeeDto.eloCode());
        employee.setContractStartDate(employeeDto.contractStartDate());
        employee.setContractEndDate(employeeDto.contractEndDate());
        employee.setHiringEmploymentCompany(employeeDto.hiringEmploymentCompany());
        employee.setPhoneNumber(employeeDto.phoneNumber());

        employee.setCreatedAt(LocalDateTime.now());
        employee.setEmployeeType(EmployeeType.TEMPORARY);
        employee.setStatus(StatusEmployee.AVAILABLE);
        employee.setActive(true);

        employee.setDisplayName("[" + employeeDto.eloCode() + "]-" + employeeDto.firstName() + " " + employeeDto.lastName());

        return employee;
    }

    public List<InternalEmployee> toInternalEmployeeList(List<InternalEmployeeDto> employees){
        return employees.stream()
                .map(this::toInternalEmployeeEntity)
                .toList();
    }

    public List<TemporaryEmployee> toTemporaryEmployeeList(List<TemporaryEmployeeDto> employees){
        return employees.stream()
                .map(this::toTemporaryEmployeeEntity)
                .toList();
    }

    public List<InternalEmployeeDto> toInternalEmployeeDtoList(List<InternalEmployee> employees){
        return employees.stream()
                .map(this::toInternalEmployeeDto)
                .toList();
    }

    public List<TemporaryEmployeeDto> toTemporaryEmployeeDtoList(List<TemporaryEmployee> employees){
        return employees.stream()
                .map(this::toTemporaryEmployeeDto)
                .toList();
    }
}
