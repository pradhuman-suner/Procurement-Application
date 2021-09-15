import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http:HttpClient) { }

  public loginUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8080/login",user);
  }

  public registerUserFromRemote(user:User):Observable<any>{
    return this._http.post<any>("http://localhost:8080/register",user);
  }

  // Products

  public getProducts(): Observable<any> {

    var obj = this._http.get("http://localhost:8080/product/getProducts");
    return obj;
  }

  public getProductsById(id : any): Observable<any> {

    var obj = this._http.get("http://localhost:8080/product/getProductById/"+id);
    return obj;
  }

  public updateProductThreshold(id: any, product: any): Observable<any> {
    return this._http.put<any>("http://localhost:8080/product/updateProductThresholdValue/"+id, product);
  }

  // Cart

  public getCartList(): Observable<any> {

    var obj = this._http.get("http://localhost:8080/getCart");
    return obj;
  }

  public getCartListByUser(userId : any): Observable<any> {

    var obj = this._http.get("http://localhost:8080/getCartListByUserId/"+ userId);
    return obj;
  }

  public getCartListTotalByUser(userId : any): Observable<any> {

    var obj = this._http.get("http://localhost:8080/getCartListTotalByUserId/"+ userId);
    return obj;
  }

  public getCartDataById(id : any): Observable<any> {

    var obj = this._http.get("http://localhost:8080/getCartById/"+id);
    return obj;
  }

  public deleteCartDataById(id : any): Observable<any> {

    var obj = this._http.delete("http://localhost:8080/deleteCart/"+id);
    return obj;
  }

  public deleteCartDataByUserId(userId : any): Observable<any> {

    var obj = this._http.delete("http://localhost:8080/deleteCartByUserId/" + userId);
    return obj;
  }

  public addCartData(cart: any): Observable<any> {
    return this._http.post<any>("http://localhost:8080/registerCart", cart);
  }

  public updateCartData(id: any, cart: any): Observable<any> {
    return this._http.put<any>("http://localhost:8080/updateCart/"+id, cart);
  }

  // Send Email
  public sendEmail(sendEmail: any): Observable<any> {
    return this._http.post<any>("http://localhost:8080/sendEmail", sendEmail);
  }

}
