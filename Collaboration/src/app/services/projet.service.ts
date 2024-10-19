import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private _http: HttpClient) {}

  addProjet(data: any): Observable<any> {
    return this._http.post('http://localhost:3000/Projet1',data);
  }
  getProjetList(): Observable<any> {
    return this._http.get('http://localhost:3000/Projet1');
  }
  updateProjet(id: number, data: any): Observable<any> {
    return this._http.put(`http://localhost:3000/Projet1/${id}`,data);
  }

  deleteProjet(id: number): Observable<any> {
    return this._http.delete(`http://localhost:3000/Projet1/${id}`);
  }}
