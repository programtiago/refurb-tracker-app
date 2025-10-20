import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { AppMaterialModule } from '../core/shared/app-material/app-material.module';

@NgModule({
  declarations: [
    EmployeeFormComponent,
    EmployeesListComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ]
})
export class RhModule { }
