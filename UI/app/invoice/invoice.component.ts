
import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, NgIterable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import jspdf from 'jspdf';
import html2canvas from 'html2canvas';
import { GlobalConstants } from '../common/global-constants'
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent implements OnInit {

  // Table
  displayedColumns: string[] = ['productName', 'productPrice', 'quantity', 'total'];
  dataSource: any;


  myuser: any;
  currentdate: any;

  // increse decrease button
  increaseItemCount(id: any, data: any) {
    if (data.quantity < data.thresholdValue) {
      data.quantity = data.quantity + 1;
      data.total = data.quantity * data.productPrice;
    }
    this._service.updateCartData(id, data).subscribe();
    this.getCartList();
  }

  decreaseItemCount(id: any, data: any) {
    if (data.quantity > 1) {
      data.quantity = data.quantity - 1;
      data.total = data.quantity * data.productPrice;
    }
    this._service.updateCartData(id, data).subscribe();
    this.getCartList();
  }

  ngOnInit(): void {

  }

  msg = '';
  //products : NgIterable<any> | undefined;
  user = this.globalconstants.getUser();


  getCartList() {
    this._service.getCartListByUser(parseInt(this.user.id))
      .subscribe(
        (response) => {
          console.log('response received')
          this.dataSource = response as NgIterable<any>;
          this.changeDetectorRefs.detectChanges();
        }
      );
    console.log("This is Data Source:" + this.dataSource);
    console.log("THis is User Obj" + this.user);
  }

  totalprice: any;
  getTotalPrice() {

    this._service.getCartListTotalByUser(parseInt(this.user.id))
      .subscribe(
        (response) => {
          console.log('response received')
          this.totalprice = response;
        }
      );
  }



  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private _service: RegistrationService, private _route: Router, private changeDetectorRefs: ChangeDetectorRef, private globalconstants: GlobalConstants, public dialog: MatDialog) {
    this.getCartList();
    this.getTotalPrice();
    this.currentdate = new Date()
    this.mydate = 'ORDER' + this.currentdate.getDay() + this.currentdate.getMonth() + this.currentdate.getFullYear() + this.currentdate.getHours() + this.currentdate.getMinutes() + this.currentdate.getSeconds();


    this.myuser = this.globalconstants.getUser();





  }

  // delete Cart Item
  deleteCartItem(id: any) {
    this._service.deleteCartDataById(id).subscribe((response) => { });
    this.getCartList();
  }


  mydate: any;
  // // PDF
  captureScreen() {

    //console.log(mydate);

    var pdfdata;
    var data = document.getElementById('content')!;
    html2canvas(data).then(canvas => {
      // Few necessary setting options  
      var imgWidth = 208;
      var imgHeight = canvas.height * imgWidth / canvas.width;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jspdf('p', 'mm', 'a4');
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdfdata = pdf.save(this.mydate + '.pdf'); // Generated PDF   
      console.log("THis is PDF" + pdfdata);
    });

  }


  confirmOrder() {
    this.captureScreen();

    var billdata = {
      'to': this.myuser.emailId,
      'subject': 'Bill Date = ' + this.currentdate,
      'message': 'Your Order Has Been Placed\nPlease Find Bill Attached Below\nThank You',
      'attachment': this.mydate
    }

    setTimeout(() => {
      this._service.sendEmail(billdata).subscribe((response) => { });
    }, 10000);


    for (let obj of this.dataSource) {
      this.deleteCartItem(obj.id);
      var product = {
        thresholdValue: obj.thresholdValue - obj.quantity,
      }
      this._service.updateProductThreshold(obj.productId, product).subscribe((response) => { });
    }
    this.getCartList();
    alert("Your Order Has Been Placed ");
    this._route.navigate(['/my-user-dashboard']);
  }

  // Dilog Code
  // openDialog(){
  //   //this.captureScreen();
  //   var value = confirm("Please Confirm !");
  //   if(value){
  //     this.confirmOrder();
  //   }
  // }
}


