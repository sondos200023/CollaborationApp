import { Injectable } from '@angular/core';
import{HttpClient}from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  constructor(private _http: HttpClient) {}

  addEmployee(data: any): Observable<any> {
    return this._http.post('http://localhost:3000/employe', data);
  }
  getEmployeeList(): Observable<any> {
    return this._http.get('http://localhost:3000/employe');
  }
  updateEmployee(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:3000/employe/${id}`, data);
  }

  deleteEmployee(id: number): Observable<any> {
    return this._http.delete(`http://localhost:3000/employe/${id}`);
  }}
