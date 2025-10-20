import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../src/environments/environment';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/MenuItem';

@Injectable({
  providedIn: 'root'
})
export class RhService {

  constructor(private http: HttpClient) { }

  getMenuItemsList(): Observable<MenuItem[]>{
    return this.http.get<MenuItem[]>(`${environment.apiUrl}/menus?department=HR`)
  }
}
