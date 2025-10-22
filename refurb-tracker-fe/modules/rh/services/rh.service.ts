import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../src/environments/environment';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/menuItem';
import { InternalEmployee } from '../model/internalEmployee';

@Injectable({
  providedIn: 'root'
})
export class RhService {

  constructor(private http: HttpClient) { }

  getMenuItemsList(): Observable<MenuItem[]>{
    return this.http.get<MenuItem[]>(`${environment.apiUrl}/menus?department=HR`)
  }

  createInternalEmployee(employeeData: InternalEmployee) {
    this.http.post<InternalEmployee>(`${environment.apiUrl}/employees/add/intern`, employeeData);
  }
}
