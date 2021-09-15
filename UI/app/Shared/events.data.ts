export interface DonorData {
    name: any;
    contactNumber: string;
    address: string;
    dob: string;
    bloodGroup: string;
}

export interface DonorForUpdateData {
    Id: any;
    name: any;
    contactNumber: string;
    address: string;
    dob: string;
    bloodGroup: string;
}

export interface VendorData {
    vendorName: string;
    type: string;
    agency: string;
    contact: string;
    uniqueId: string;
    vendoraddress: string;
    username: string;
    password: string;
}

export interface VendorForUpdateData {
    Id: any;
    vendorName: string;
    type: string;
    agency: string;
    contact: string;
    uniqueId: string;
    vendoraddress: string;
    username: string;
    password: string;
}

export interface newspaperData {
    id:any;
    newspaperName: string;
    newspaperRate: string;
}