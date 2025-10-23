package com.devtiago.refurbtracker.refurb_rh.controller;

import com.devtiago.refurbtracker.refurb_core.entity.Employee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.InternalEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.entity.dto.TemporaryEmployeeDto;
import com.devtiago.refurbtracker.refurb_rh.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/interns")
    public List<InternalEmployeeDto> findAllInternEmployees(){
        return employeeService.findAllInternEmployees();
    }

    @GetMapping("/temporaries")
    public List<TemporaryEmployeeDto> findAllTemporaryEmployees(){
        return employeeService.findAllTemporaryEmployees();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add/intern")
    public ResponseEntity<InternalEmployeeDto> create(@RequestBody @Valid InternalEmployeeDto employee){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createNewEmployee(employee));
    }

    @PostMapping("/add/temporary")
    public ResponseEntity<TemporaryEmployeeDto> create(@RequestBody @Valid TemporaryEmployeeDto employee){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.createNewEmployee(employee));
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
