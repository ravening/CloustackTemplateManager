import { Injectable } from '@angular/core';
import {Platforms} from "../models/Platforms";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {catchError, tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PlatformService {
  apiUrl: string = 'http://81.171.21.226:8080/api/v1/platforms';

  constructor(private http: HttpClient) { }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    }
  }

  getPlatforms(): Observable<Platforms[]> {
    const url = this.apiUrl + '/listall';
    return this.http.get<Platforms[]>(url)
      .pipe(
        tap(platforms => console.log('Fetched platforms')),
        catchError(this.handleError('getPlatforms', []))
      );
  }

  getPlatformById(id: number): Observable<Platforms> {
    const url = this.apiUrl + '/id/' + id;
    return this.http.get<Platforms>(url)
      .pipe(
        tap(_ => console.log('fetched template with id ' + id)),
        catchError(this.handleError<Platforms>('getPlatformById : id ' + id))
      );
  }
}
