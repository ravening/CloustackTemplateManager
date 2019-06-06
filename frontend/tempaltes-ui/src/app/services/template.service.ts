import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";

import {Templates} from "../models/Templates";
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class TemplateService {
  apiUrl: string = 'http://81.171.21.226:8080/api/v1/templates';

  constructor(private http: HttpClient) { }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    }
  }

  getTemplates(): Observable<Templates[]> {
    const url = this.apiUrl + '/listall';
    return this.http.get<Templates[]>(url)
      .pipe(
        tap(templates => console.log('Fetched templates')),
        catchError(this.handleError('getTemplates', []))
      );
  }

  getTemplateById(id: number): Observable<Templates> {
    const url = this.apiUrl + '/id/' + id;
    return this.http.get<Templates>(url)
      .pipe(
        tap(_ => console.log('fetched template with id ' + id)),
        catchError(this.handleError<Templates>('getTemplateById : id ' + id))
      );
  }
}
