import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { LoginComponent } from './login/login.component';
import { MyUserDashboardComponent } from './my-user-dashboard/my-user-dashboard.component';
import { ProfileComponent } from './profile/profile.component';
import { AuthGuard } from './services/auth.guard';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', component:LoginComponent },
  {
    path: 'admin',
    component: AdminComponent
  },
//   {

//     path: 'admin',

//     loadChildren: () => import('./admin/admin.component').then(m => m.AdminComponent),

//     canActivate: [AuthGuard]

// },

  {
    path: 'login',
    component: LoginComponent
  },
  { path: 'frontend/signup', component: SignupComponent },
  {
    path: 'add-product',
    component: AddProductComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: 'my-user-dashboard',
    component: MyUserDashboardComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path : 'invoice',
    component :InvoiceComponent
  },
  // {
  //   path: 'my-user-dashboard',
  //   loadChildren: () => import('./my-user-dashboard/my-user-dashboard.component').then(m => m.MyUserDashboardComponent),

  //   canActivate: [AuthGuard]
  // },
  { path: '**', canActivate: [AuthGuard], redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
