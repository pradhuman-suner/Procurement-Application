import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  
  private baseURL = "http://localhost:8080";
  constructor( private http:HttpClient) { }
  
  getUsers(): Observable<User[]>{
     return this.http.get<User[]>(`${this.baseURL}`+`/getUsers`);
  }

  deleteUser(id: User):Observable<User>{
    return this.http.delete<User>(`${this.baseURL}`+`/removeUser/` +id);
  }
  
}
