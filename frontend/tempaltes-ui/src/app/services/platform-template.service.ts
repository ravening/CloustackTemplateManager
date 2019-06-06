import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";
import {PlatformTemplates} from "../models/PlatformTemplates";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PlatformTemplateService {
  apiUrl: string = 'http://81.171.21.226:8080/api/v1/platformtemplate';

  constructor(private http: HttpClient) { }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    }
  }

  getPlatformTemplates(): Observable<PlatformTemplates[]> {
    const url = this.apiUrl + '/listall';
    return this.http.get<PlatformTemplates[]>(url)
      .pipe(
        tap(templates => console.log('Fetched templates')),
        catchError(this.handleError('getPlatformTemplates', []))
      );
  }

  getPlatformTemplateById(id: number): Observable<PlatformTemplates> {
    const url = this.apiUrl + '/id/' + id;
    return this.http.get<PlatformTemplates>(url)
      .pipe(
        tap(_ => console.log('fetched template with id ' + id)),
        catchError(this.handleError<PlatformTemplates>('getPlatformTemplateById : id ' + id))
      );
  }
}
