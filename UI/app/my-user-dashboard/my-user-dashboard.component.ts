
import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, NgIterable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { GlobalConstants } from '../common/global-constants'



@Component({
  selector: 'app-my-user-dashboard',
  templateUrl: './my-user-dashboard.component.html',
  styleUrls: ['./my-user-dashboard.component.scss']
})
export class MyUserDashboardComponent implements OnInit {


  
  msg = '';
  products : NgIterable<any> | undefined;

  getProducts() {
    this._service.getProducts()
      .subscribe(
        (response) => {
          this.products  = response as NgIterable<any>;
        })
  }


  ngOnInit(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }


  // Code For Side Bar
  mobileQuery: MediaQueryList;


  

  private _mobileQueryListener: () => void;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private _service: RegistrationService, private _route: Router,private globalconstants : GlobalConstants) {
    //var user = this.globalconstants.getUser();
    this.getProducts();
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);

  }

 
  // add to cart
  
  user = this.globalconstants.getUser();
  addToCart(product: any){
    var data = {
      productName:product.productName,
      productCategory:product.productCategory,
      productDescription:product.productDescription,
      productPrice:product.productPrice,
      thresholdValue:product.thresholdValue,
      productId:product.productId,
      quantity:1,
      total:product.productPrice,
      userId:parseInt(this.user.id)
    }
    console.log(data);
    this._service.addCartData(data).subscribe( (response) =>  { console.log(response) });

  }

  onClickBuyNow(product: any){
    this.addToCart(product);
    this._route.navigate(['/cart']);
  }


}
