import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],

})
export class SignupComponent implements OnInit {

  userName: any;
  loading = false;
  firstName: any;
  lastName: any;
  emailId: any;
  password: any;
  role: any;
  address: any;
  contactNo: any;
  signupForm: any;
  submitted: any;
  data: any;

  responseMessage: any;
  alertServicvaluee: any;


  constructor(private usersService: UsersService,
    private formBuilder: FormBuilder,
    private _snackBar: MatSnackBar,
    private router: Router) { }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: 'User',
      address: ['', Validators.required],
      contactNo: ['', Validators.required],
      emailId: ['', Validators.required]

    })
  };

  get f() { return this.signupForm.controls; }

  onSubmit() {
    this.submitted = true;
    console.log("dadad--", this.signupForm.value)
    // stop here if form is invalid
    if (this.signupForm.invalid) {
      return;
    }
    this.loading = true;
    this.usersService.signUp(this.signupForm.value).subscribe(
      (response: any) => {
        console.log(this.data);
        console.log(response)
        //this.responseMessage = response?.message;
        

      }
      , (error) => {
        console.log(error);
        this.openSnackBar('Could Not Sign Up', "Close");
        // if(error.error?.message){
        //   this.responseMessage = error.error?.message;
        // }
        // else{

        // this.openSnackBar(this.responseMessage,"Close");
        // }
      },
      () => {
        this.openSnackBar('SignUp Success', "Close");
        this.router.navigate(['/login']);
      }
    );
    // if(this.responseMessage == 'Sign Up Successfull'){
    //   this.router.navigate(['/login']);
    //   this.openSnackBar(this.responseMessage,"Close");

    // }
    // else if(this.responseMessage == 'User Name  Already EXIST !!'){
    //   this.openSnackBar(this.responseMessage,"Close");
    // }

  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      horizontalPosition: 'center',
      verticalPosition: 'top',
      duration: 2000
    });
  }
}