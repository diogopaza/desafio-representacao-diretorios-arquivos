import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Diretorio} from "../models/diretorio";

@Injectable({
  providedIn: 'root'
})
export class DiretorioService {

  private apiUrl = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }
  getDiretorios(): Observable<Diretorio[]>{
    const url = this.apiUrl + 'diretorios';
    return this.http.get<Diretorio[]>(url);
  }
}
