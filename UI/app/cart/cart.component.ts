import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, NgIterable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import jspdf from 'jspdf';
import html2canvas from 'html2canvas';  
import { GlobalConstants } from '../common/global-constants'

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  // Table
  displayedColumns: string[] = ['productName','thresholdValue', 'productPrice','quantity','total','remove'];
  dataSource : any;
  

  // increse decrease button
  increaseItemCount(id : any ,data: any){
    if(data.quantity < data.thresholdValue)
    { 
      data.quantity = data.quantity + 1;
      data.total = data.quantity * data.productPrice;
    }
     this._service.updateCartData(id,data).subscribe();
     this.getCartList();
  }

  decreaseItemCount(id : any ,data: any){
    if(data.quantity > 1)
    { 
      data.quantity = data.quantity - 1;
      data.total = data.quantity * data.productPrice;
    }
    this._service.updateCartData(id,data).subscribe();
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
          this.dataSource  = response as NgIterable<any>;
          this.changeDetectorRefs.detectChanges();
        });
        console.log("This is Data Source:"+this.dataSource);
        console.log("THis is User Obj" +this.user);
  }

  // Code For Side Bar
  mobileQuery: MediaQueryList;



  private _mobileQueryListener: () => void;

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private _service: RegistrationService, private _route: Router,private changeDetectorRefs: ChangeDetectorRef,private globalconstants : GlobalConstants) {
    this.getCartList();
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);

  }

  // delete Cart Item
  deleteCartItem(id :  any){
    this._service.deleteCartDataById(id).subscribe( (response) => {} );
    this.getCartList();
  }


  // // PDF
  captureScreen()  
  {  
    var currentdate = new Date()
    var mydate ='bill_'+ currentdate.getDay() + currentdate.getMonth() + currentdate.getFullYear() + currentdate.getHours() + currentdate.getMinutes() + currentdate.getSeconds();
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
      pdfdata = pdf.save(mydate + '.pdf'); // Generated PDF   
      console.log("THis is PDF"+pdfdata);
    });  

    var myuser = this.globalconstants.getUser();
    var billdata = {
       'to' : myuser.emailId,
       'subject' : 'Bill Date = ' + currentdate ,
       'message' : 'Your Order Has Been Placed\nPlease Find Bill Attached Below\nThank You',
       'attachment' : "bill_282021155947"
    }
    if(true){
      this._service.sendEmail(billdata).subscribe((response) => {});
    }

    for (let obj of this.dataSource) {
      this.deleteCartItem(obj.id);
      var product = {
        thresholdValue : obj.thresholdValue - obj.quantity,
      }
      this._service.updateProductThreshold(obj.productId,product).subscribe( (response) => {} );
    }
    this.getCartList();
    alert("Your Order Has Been Placed ");
  }  

  // captureScreen(): void 
  //   {
  //      /* table id is passed over here */   
  //      let element = document.getElementById('content'); 
  //      const ws: XLSX.WorkSheet =XLSX.utils.table_to_sheet(element);

  //      /* generate workbook and add the worksheet */
  //      const wb: XLSX.WorkBook = XLSX.utils.book_new();
  //      XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

  //      /* save to file */
  //      XLSX.writeFile(wb, "ExcelSheet.xlsx");
			
  //   }
}


