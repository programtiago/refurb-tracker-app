import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RhService {

  constructor(private http: HttpClient) { }

  getMenuItemsList(){
    return this.http.get(`${environment.apiUrl}/menus?department=HR`)
  }
}
