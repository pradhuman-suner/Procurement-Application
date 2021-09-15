import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { GlobalConstants } from '../common/global-constants';
import { LoginService } from '../services/login.service';
import { UsersService } from '../services/users.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userName: any;
  password: any;

  data: any;
  responseMessage: any;

  constructor(private usersService: UsersService,
    private _snackBar: MatSnackBar,
    private router: Router,private globalconstants : GlobalConstants) { }

  ngOnInit(): void {
  }

  userLogin(value: any) {
    this.data = {
      userName: this.userName,
      password: this.password,
     
    }

    this.usersService.login(this.data).subscribe((response: any) => {
      console.log(response)
      console.log(this.data)
      if (response.id && response.userName && response.role) {
        localStorage.setItem('id', response.id);
        localStorage.setItem('userName', response.userName);
       

        this.globalconstants.setUser(response);


        if (response.role === 'Admin')
          this.router.navigate(['/admin']);
        // else if (response.role === 'Vendor')
        //   this.router.navigate(['/vendor/module']);
        else if(response.role === 'User')
        this.router.navigate(['/my-user-dashboard']);
      }
      else if(response?.message){
        this.openSnackBar(response?.message, "Close");
      }
      else
      this.openSnackBar("Something went wrong.","Close");
    }, (error) => {
      console.log(error);
      if (error.error?.message) {
        this.responseMessage = error.error?.message;
      }
      else
        this.responseMessage = "Something went Wrong."
      this.openSnackBar(this.responseMessage, "Close");
    });

  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      duration: 2000
    });
  }

}
