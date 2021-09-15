import { ChangeDetectorRef, Component, NgIterable, OnInit } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { AgGridModule } from 'ag-grid-angular';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { productList } from '../productList';
import { ProductServiceService } from '../product-service.service';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';
import * as XLSX from 'xlsx';
import { MatDialogConfig } from '@angular/material/dialog';
import { AddProductComponent } from '../add-product/add-product.component';
import { IconButtonComponent } from './icon-button/icon-button.component';
import { MediaMatcher } from '@angular/cdk/layout';
import { RegistrationService } from '../registration.service';
import { GlobalConstants } from '../common/global-constants';
import { UpdateProductComponent } from '../update-product/update-product.component';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  ngOnInit(): void {

  }



  // //   exportExcel() {
  // //     const workSheet = XLSX.utils.json_to_sheet(this.dataSource.data, {header:['dataprop1', 'dataprop2']});
  // //     const workBook: XLSX.WorkBook = XLSX.utils.book_new();
  // //     XLSX.utils.book_append_sheet(workBook, workSheet, 'SheetName');
  // //     XLSX.writeFile(workBook, 'filename.xlsx');
  // // }

  // // exportExcel(){

  // //   alert("export");
  // //   this.gridApi.exportDataAsExcel();
  // // }
  // exportExcel(): void {
  //   /* table id is passed over here */
  //   let element = document.getElementById('content');
  //   const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(element);

  //   /* generate workbook and add the worksheet */
  //   const wb: XLSX.WorkBook = XLSX.utils.book_new();
  //   XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

  //   /* save to file */
  //   XLSX.writeFile(wb, "ExcelSheet.xlsx");

  // }
  openAddProductDialog() {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(AddProductComponent, dialogConfig);
    this.dialog._getAfterAllClosed().subscribe(result => {
      this.getProduct();
    })
  }

  openUpdateProductDialog(data: any) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    this.dialog.open(UpdateProductComponent,{data});
    this.dialog._getAfterAllClosed().subscribe(result => {
      this.getProduct();
    })
  }


  // Code For Side Bar
  mobileQuery: MediaQueryList;

  msg = '';
  //products : NgIterable<any> | undefined;
  user = this.globalconstants.getUser();



  private _mobileQueryListener: () => void;
  // table
  // Table
  displayedColumnsVendor: string[] = ['userName', 'firstName', 'lastName', 'address', 'contact', 'emailId', 'actions'];
  dataSourceVender: any;

  displayedColumnsProducts: string[] = ['productName', 'productCategory', 'productDescription', 'productPrice', 'thresholdValue', 'actions'];
  dataSourceProducts: any;


  getUsers() {
    this.userService.getUsers()
      .subscribe(
        (response) => {
          console.log('response received')
          this.dataSourceVender = response as NgIterable<any>;
          this.changeDetectorRefs.detectChanges()

        });

  }

  getProduct() {
    this.productService.getProduct()
      .subscribe(
        (response) => {
          console.log('response received')

          this.dataSourceProducts = response as NgIterable<any>;
          this.changeDetectorRefs.detectChanges()

        });

  }

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private userService: UserServiceService, private productService: ProductServiceService, private _route: Router, private changeDetectorRefs: ChangeDetectorRef, private globalconstants: GlobalConstants, private dialog: MatDialog) {
    this.getProduct();
    this.getUsers();
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);

  }

  deleteUser(id: any) {
    console.log(id);
    this.userService.deleteUser(id).subscribe((data: any) => {
      console.log(data);
    });
    this.getUsers();
  }

  deleteProduct(id: any) {
    console.log(id);
    this.productService.deleteProduct(id).subscribe((data: any) => {
      console.log(data);
    });
    this.getProduct();
  }

}
