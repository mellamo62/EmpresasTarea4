import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {  Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {Empresa} from "../Empresa";

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  private apiURL = "http://localhost:8080/empresas/";

  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  };
  constructor(private httpClient:HttpClient) { }

  getAll(): Observable<Empresa[]>{
    return this.httpClient.get<Empresa[]>(this.apiURL)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  create(empresa:Empresa): Observable<Empresa>{
    return this.httpClient.post<Empresa>(this.apiURL, JSON.stringify(empresa), this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  find(id:number):Observable<Empresa>{
    return this.httpClient.get<Empresa>(this.apiURL+id)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  errorHandler(error:any){
    let errorMessage ='';

    if (error.error instanceof ErrorEvent){
      errorMessage = error.error.message;
    }else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }

    return throwError(()=>errorMessage);
  }
}
