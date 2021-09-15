import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AdminComponent } from './admin/admin.component'
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {Observable} from 'rxjs';
import { AddProductComponent } from './add-product/add-product.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { IconButtonComponent } from './admin/icon-button/icon-button.component';
import { SignupComponent } from './signup/signup.component';
import { MaterialModule } from './Shared/material-module';
import { NetworkInterceptor } from './services/network.interceptor';
import { MatBadgeModule } from '@angular/material/badge';
import { CartComponent } from './cart/cart.component';
import { MyUserDashboardComponent } from './my-user-dashboard/my-user-dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { InvoiceComponent } from './invoice/invoice.component';




@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AddProductComponent,
    DeleteProductComponent,
    UpdateProductComponent,
    LoginComponent,
    IconButtonComponent, 
    AppComponent,
    SignupComponent,
    MyUserDashboardComponent,
    CartComponent,
    ProfileComponent,
    InvoiceComponent,
     
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    AgGridModule.withComponents([]),
    FontAwesomeModule,
    HttpClientModule,
    
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,

    BrowserModule,
    AppRoutingModule,
    FormsModule,
    
    FormsModule,
    ReactiveFormsModule,
    AgGridModule.withComponents([]),
   
    
    MatBadgeModule,
    MaterialModule,
    AgGridModule,

    MatTableModule,
  ],
  providers: [HttpClientModule,{provide:HTTP_INTERCEPTORS,useClass:NetworkInterceptor,multi:true}],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  exports:[MaterialModule]
})
export class AppModule { }
