import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cliente} from "./cliente";

@Injectable({
  providedIn: 'root'
})

export class ClienteService {

  private readonly  API = 'http://localhost:3000/clientes';

  constructor(private http: HttpClient) { }

  listar(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.API);
  }

  criar(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.API, cliente);
  }
}
