import { Component, OnInit } from '@angular/core';
import { AdminComponent } from '../admin.component';
import { Router, ActivatedRoute } from '@angular/router'; 
import { ProductServiceService } from 'src/app/product-service.service';
import { productList } from 'src/app/productList';

@Component({
  selector: 'app-icon-button',
  templateUrl: './icon-button.component.html',
  styleUrls: ['./icon-button.component.scss']
})
export class IconButtonComponent implements OnInit {
  
  productList = new productList();
  params: any;
  data: any;
  //productservice: any;
  constructor( 
    private router : Router,
    private productservice : ProductServiceService
  ) { }

  agInit(data: any): void {
    
  }


  ngOnInit(): void {
  }



  update(){

  }
}
