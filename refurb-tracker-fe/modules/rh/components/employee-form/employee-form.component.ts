import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RhService } from '../../services/rh.service';
import { InternalEmployee } from '../../model/internalEmployee';
import { DatePipe } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ErrorDialogService } from '../../../core/shared/services/error-dialog.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.scss'
})
export class EmployeeFormComponent implements OnInit {

  employeeForm!: FormGroup;
  employeeTypes = [
    { value: 'INTERNAL', viewValue: 'Internal' },
    { value: 'TEMPORARY', viewValue: 'Temporary' }
  ];

  departments = [
    { value: 'IT', viewValue: 'Information Technology'},
    { value: 'HR', viewValue: 'Human Resources'},
    { value: 'ADMIN', viewValue: 'Administration'},
    { value: 'LOG', viewValue: 'Logistic'},
    { value: 'PROD', viewValue: 'Production'},
    { value: 'QA', viewValue: 'Quality Assurance'}
  ]

  constructor(
    private fb: FormBuilder, 
    private rhService: RhService, 
    private datePipe: DatePipe, 
    private snackbar: MatSnackBar,
    private router: Router,
    private errorDialog: ErrorDialogService
  ){}

  ngOnInit(): void {
    this.buildBaseForm();

    this.employeeForm.get('employeeType')?.valueChanges.subscribe(type => {
      this.updateFormForType(type);
    })
  }

  buildBaseForm(): void {
    this.employeeForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]],
      lastName: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]],
      birthdayDate: [''],
      phoneNumber: ['', Validators.required],
      department: ['', Validators.required],
      position: ['', Validators.required],
      admissionDate: ['', Validators.required],
      employeeType: ['']
    });
  }

  updateFormForType(type: string): void {
    ['workerNo', 'eloCode', 'contractStartDate', 'contractEndDate', 'hiringEmploymentCompany']
      .forEach(field => this.employeeForm.removeControl(field));

    if (type === 'INTERNAL') {
      this.employeeForm.addControl('workerNo', this.fb.control('', Validators.required));
    }

    if (type === 'TEMPORARY') {
      this.employeeForm.addControl('eloCode', this.fb.control('', Validators.required)); 
      this.employeeForm.addControl('contractStartDate', this.fb.control('', Validators.required));
      this.employeeForm.addControl('contractEndDate', this.fb.control('', Validators.required));
      this.employeeForm.addControl('hiringEmploymentCompany', this.fb.control('', Validators.required));
    }
  }

  onCreate(): void {
    const type = this.employeeForm.value['employeeType'];

    if (!this.employeeForm.valid){
      console.log('Form invalid', this.employeeForm.value);
      return;
    } 

    const employeeDataToSave : Partial<InternalEmployee> = {
      firstName: this.employeeForm.value['firstName'],
      lastName: this.employeeForm.value['lastName'],
      birthdayDate: this.datePipe.transform(this.employeeForm.value['birthdayDate'], 'yyyy-MM-dd') ?? undefined,
      admissionDate: this.datePipe.transform(this.employeeForm.value['admissionDate'], 'yyyy-MM-dd') ?? undefined,
      department: this.employeeForm.value['department'],
      workerNo: this.employeeForm.value['workerNo'],
      phoneNumber: this.employeeForm.value['phoneNumber'],
      position: this.employeeForm.value['position']
    }
    console.log(employeeDataToSave)

      if (type === 'INTERNAL'){
        console.log('Internal')
        this.rhService.createInternalEmployee(employeeDataToSave)
        .subscribe({
          next: (response) => {
            if (response.status === 201){
              if (employeeDataToSave.employeeType == 'INTERNAL'){
                console.log("Employee created", employeeDataToSave);
                this.snackbar.open(`Internal Employee created sucessfully: ${employeeDataToSave.firstName + "" + employeeDataToSave.lastName } with worker number ${employeeDataToSave.workerNo}`, 'X', {
                  duration: 5000
                })
                setTimeout(() => {
                  this.router.navigateByUrl('/employees')
                }, 4000);
              }else if (employeeDataToSave.employeeType == 'TEMPORARY'){
                console.log("Employee created", employeeDataToSave);
              }
            }
          },
          error: (err) => {
            this.errorDialog.openDialog(
              err.error?.errorCode,
              err.error?.message || 'Unexpected error ocurred.'
            )
            console.error('Error creating internal employee', err)
          }
        })
      }
  }

}
