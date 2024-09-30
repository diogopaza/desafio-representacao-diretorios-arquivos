import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Arquivo} from "../models/arquivo";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ArquivoService {
  private apiUrl = 'http://localhost:8080/';
  constructor(private http: HttpClient) {
  }
  getArquivosNaRaiz(): Observable<Arquivo[]> {
    const url = this.apiUrl + 'arquivos/todosarquivosnaraiz';
    return this.http.get<Arquivo[]>(url);
  }
}

