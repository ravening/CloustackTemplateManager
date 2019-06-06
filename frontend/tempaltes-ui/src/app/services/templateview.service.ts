import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";
import {TemplateView} from "../models/TemplateView";

@Injectable({
  providedIn: 'root'
})
export class TemplateviewService {
  apiUrl: string = 'http://81.171.21.226:8080/api/v1/templateview';

  constructor(private http: HttpClient) { }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    }
  }

  getTemplateViews(): Observable<TemplateView[]> {
    const url = this.apiUrl + '/listall';
    return this.http.get<TemplateView[]>(url)
      .pipe(
        tap(templates => console.log('Fetched templateview')),
        catchError(this.handleError('getTemplateView', []))
      );
  }

  getTemplateViewById(id: number): Observable<TemplateView> {
    const url = this.apiUrl + '/id/' + id;
    return this.http.get<TemplateView>(url)
      .pipe(
        tap(_ => console.log('fetched template view with id ' + id)),
        catchError(this.handleError<TemplateView>('getTemplateViewById : id ' + id))
      );
  }

  getTemplateViewByName(name: string): Observable<TemplateView> {
    const url = this.apiUrl + '/name/' + name;
    return this.http.get<TemplateView>(url)
      .pipe(
        tap(_ => console.log('fetched template view with name ' + name)),
        catchError(this.handleError<TemplateView>('getTemplateViewByName : name ' + name))
      );
  }
}
