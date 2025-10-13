package com.devtiago.refurbtracker.refurb_rh;

import com.devtiago.refurbtracker.refurb_rh.entity.InternalEmployee;
import com.devtiago.refurbtracker.refurb_rh.entity.TemporaryEmployee;
import com.devtiago.refurbtracker.refurb_rh.repository.InternalEmployeeRepository;
import com.devtiago.refurbtracker.refurb_rh.repository.TemporaryEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeesLoader implements CommandLineRunner {

    private final InternalEmployeeRepository internalEmployeeRepository;
    private final TemporaryEmployeeRepository temporaryEmployeeRepository;

    @Override
    public void run(String... args) throws Exception {
        //Load internal employees
        internalEmployeeRepository.saveAll(getInternalEmployeesData());

        //Load temporary employees
        temporaryEmployeeRepository.saveAll(getTemporaryEmployeesData());
    }

    private static List<InternalEmployee> getInternalEmployeesData(){
        return List.of(
                InternalEmployee.builder()
                        .firstName("Tiago")
                        .lastName("Silva")
                        .birthdayDate(LocalDate.of(1996, 5, 2))
                        .department("IT")
                        .position("IT Technician - Level 1")
                        .admissionDate(LocalDate.of(2022, 10, 15))
                        .createdAt(LocalDateTime.now())
                        .workerNo("83508")
                        .build(),

                InternalEmployee.builder()
                        .firstName("Maria")
                        .lastName("Oliveira")
                        .birthdayDate(LocalDate.of(1985, 7, 22))
                        .department("HR")
                        .position("HR Technician")
                        .admissionDate(LocalDate.of(2022, 10, 15))
                        .createdAt(LocalDateTime.now())
                        .workerNo("83485")
                        .build()
        );
    }

    private static List<TemporaryEmployee> getTemporaryEmployeesData(){
        return List.of(
                TemporaryEmployee.builder()
                        .firstName("Marcelo")
                        .lastName("Pereira")
                        .birthdayDate(LocalDate.of(1994, 5, 23))
                        .department("PROD")
                        .position("Production Operator")
                        .admissionDate(LocalDate.of(2023, 1, 10))
                        .createdAt(LocalDateTime.now())
                        .eloCode("SYN003567")
                        .hiringEmploymentCompany("Synergie")
                        .contractStartDate(LocalDate.of(2023, 1, 10))
                        .contractEndDate(LocalDate.of(2023, 7, 10))
                        .build(),

                TemporaryEmployee.builder()
                        .firstName("Sabrina")
                        .lastName("Rocha")
                        .birthdayDate(LocalDate.of(1997, 7, 14))
                        .department("LOG")
                        .position("Warehouse Operator - Level 3")
                        .admissionDate(LocalDate.of(2022, 3, 1))
                        .createdAt(LocalDateTime.now())
                        .eloCode("ADD002585")
                        .hiringEmploymentCompany("Adecco")
                        .contractStartDate(LocalDate.of(2022, 3, 1))
                        .contractEndDate(LocalDate.of(2022, 9, 1))
                        .build()
        );
    }
}
