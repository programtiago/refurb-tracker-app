package com.devtiago.refurbtracker.refurb_rh.controller;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.InternalEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.TemporaryEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/interns")
    public List<InternalEmployeeDto> findAllInternEmployees(){
        return employeeService.findAllInternEmployees();
    }

    @GetMapping("/temporaries")
    public List<TemporaryEmployeeDto> findAllTemporaryEmployees(){
        return employeeService.findAllTemporaryEmployees();
    }

    @PostMapping("/add/intern")
    public InternalEmployeeDto create(@RequestBody InternalEmployeeDto employee){
        return employeeService.createNewEmployee(employee);
    }

    @PostMapping("/add/temporary")
    public TemporaryEmployeeDto create(@RequestBody TemporaryEmployee employee){
        return employeeService.createNewEmployee(employee);
    }

    @GetMapping("/internal/{id}")
    public InternalEmployeeDto findInternalEmployeeById(@PathVariable Long id){
        return employeeService.findInternalEmployeeById(id);
    }

    @GetMapping("/temporary/{id}")
    public TemporaryEmployeeDto findTemporaryEmployeeById(@PathVariable Long id){
        return employeeService.findTemporaryEmployeeById(id);
    }

    @PutMapping("/internal/{id}")
    public ResponseEntity<Void> updateInternalEmployee(@PathVariable Long id, @RequestBody InternalEmployeeDto employee){
        employeeService.updateEmployee(id, employee);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/temporary/{id}")
    public ResponseEntity<Void> updateTemporaryEmployee(@PathVariable Long id, @RequestBody TemporaryEmployeeDto employee){
        employeeService.updateEmployee(id, employee);

        return ResponseEntity.noContent().build();
    }
}
