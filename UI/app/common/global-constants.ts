import { Injectable } from "@angular/core";

@Injectable({
	providedIn:'root'
})
export class GlobalConstants {
  

	userObj: any;
    // userObj: any = {
    //     userId:9,
	//    firstName:'user',
	//    lastName:'user',
	//    userName: 'user',
	//    emailId: 'pradhumanrakuten@gmail.com',
	//    address : 'NULL',
	//    contactNo : 1234567890
    // }

   

    constructor() { }
    setUser(user: any) {
        this.userObj = user;
    }
    getUser() {
        return this.userObj;
    }
}
