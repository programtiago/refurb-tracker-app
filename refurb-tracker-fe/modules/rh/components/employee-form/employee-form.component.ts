import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

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

  constructor(private fb: FormBuilder){}

  ngOnInit(): void {
    this.buildBaseForm();

    this.employeeForm.get('employeeType')?.valueChanges.subscribe(type => {
      this.updateFormForType(type);
    })
  }

  buildBaseForm(): void {
    this.employeeForm = this.fb.group({
      firstName: ['', [Validators.required, Validators.minLength(3)]],
      lastName: ['', Validators.required],
      birthdayDate: [''],
      department: ['', Validators.required],
      position: ['', Validators.required],
      admissionDate: ['', Validators.required],
      active: [true],
      employeeType: ['', Validators.required]
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

  onSubmit(): void {
    if (this.employeeForm.valid) {
      console.log('Employee Data:', this.employeeForm.value);
    }
  }

}
