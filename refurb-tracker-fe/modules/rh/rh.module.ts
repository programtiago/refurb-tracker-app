import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { EmployeesListComponent } from './components/employees-list/employees-list.component';
import { AppMaterialModule } from '../core/shared/app-material/app-material.module';
import { RhRoutingModule } from './rh-routing.module';

import { MatDatepickerModule } from '@angular/material/datepicker';

@NgModule({
  declarations: [
    EmployeeFormComponent,
    EmployeesListComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule,
    RhRoutingModule,
    MatDatepickerModule
  ]
})
export class RhModule { }
