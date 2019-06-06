import { Injectable } from '@angular/core';
import {Osid} from "../models/Osid";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OsidService {
  apiUrl: string = 'http://81.171.21.226:8080/api/v1/osid';

  constructor(private http: HttpClient) { }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    }
  }

  getOsids(): Observable<Osid[]> {
    const url = this.apiUrl + '/listall';
    return this.http.get<Osid[]>(url)
      .pipe(
        tap(templates => console.log('Fetched osids')),
        catchError(this.handleError('getOsids', []))
      );
  }

  getOsidById(id: number): Observable<Osid> {
    const url = this.apiUrl + '/id/' + id;
    return this.http.get<Osid>(url)
      .pipe(
        tap(_ => console.log('fetched osid with id ' + id)),
        catchError(this.handleError<Osid>('getOsidById : id ' + id))
      );
  }
}
