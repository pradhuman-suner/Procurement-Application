import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { productList } from './productList';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private baseURL = "http://localhost:8080/product";
  constructor( private http:HttpClient) { }
  
  getProduct(): Observable<productList[]>{
     return this.http.get<productList[]>(`${this.baseURL}`+`/getProducts`);
  }
  

  addProduct(product: productList): Observable<productList>{
    return this.http.post<productList>(`${this.baseURL}`+`/registerProduct`,product);
  }

  updateProduct(product: productList,id :any): Observable<productList>{
    return this.http.put<productList>(`${this.baseURL}`+`/updateProduct/`+id,product);
  }

  deleteProduct(productId: productList): Observable<productList>{
    return this.http.delete<productList>(`${this.baseURL}`+`/deleteProduct/` +productId);
  }

  
}
