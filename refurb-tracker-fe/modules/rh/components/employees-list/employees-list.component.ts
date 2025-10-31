import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { InternalEmployee } from '../../model/internalEmployee';
import { TemporaryEmployee } from '../../model/temporaryEmployee';
import { RhService } from '../../services/rh.service';

@Component({
  selector: 'app-employees-list',
  templateUrl: './employees-list.component.html',
  styleUrl: './employees-list.component.scss'
})
export class EmployeesListComponent implements OnInit{

  employees: Employee[] = [];

  displayedColumns: string[] = [
    'firstName', 
    'lastName', 
    'birthdayDate', 
    'department', 
    'position', 
    'admissionDate', 
    'createdAt', 
    'status', 
    'phoneNumber',
    'type',
    //conditional fields
    'workerNo',
    'hiringEmploymentCompany',
    'contractStartDate',
    'contractEndDate'
  ]

  constructor(private rhService: RhService){}

  ngOnInit(): void {
    this.loadEmployees();
  }

  isInternalEmployee(employee: Employee): employee is InternalEmployee {
    return employee.employeeType === 'INTERNAL';
  }

  isTemporaryEmployee(employee: Employee): employee is TemporaryEmployee {
    return employee.employeeType === 'TEMPORARY';
  }

  loadEmployees(){
    this.rhService.getAllEmployee().subscribe((res) => {
      this.employees = res;
      console.log("EMPLOYEES", this.employees)
    })
  }

  openEditMode(id: string){
    
  }

}
