import { Injectable, Type } from '@angular/core';
import { Environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Content } from '@angular/compiler/src/render3/r3_ast';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  env: Environment = new Environment();
  constructor(private httpClient: HttpClient) { }

  loginUser(user: any, pass: any) {
    console.log(user + " service");
    console.log(pass + " service");

  }
 
  signUp(data: any) {
    return this.httpClient.post(this.env.getUrl() +
      "/signUp", data, {
      headers: new HttpHeaders().set('Content-Type', "application/json")
    })
  }
}
