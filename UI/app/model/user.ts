export class User{
    firstName!: String;
    lastName!: String;
    userName!: String;
    password!: String;
    role!:String;
    address!: String;
    contactNo!:Number;
    emailId!: String;

    constructor(firstName: String, lastName: String,address:String, emailId: String, userName: String, password: String,role: String,contactNo: number) {
            this.firstName = firstName,
            this.lastName = lastName,
            this.userName=userName,
            this.emailId = emailId,
            this.password = password,
            this.address = address,
            this.contactNo=contactNo,
            this.role=role
    }
}