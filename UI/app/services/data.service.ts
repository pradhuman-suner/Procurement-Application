import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError} from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class DataService {
   
  baseURL: string = "http://localhost:8080/";

  private userUrl = this.baseURL + '/getUsers';
  private productsUrl = this.baseURL + '/getProducts';
  constructor(private http: HttpClient) { }

  // getUsers(): Observable<users[]> {
  //   return this.http.get(this.countriesUrl)
  //                   .map((response: Response) => response.json())
  //                   .catch(this.defaultErrorHandler());
}
