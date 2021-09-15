import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { ProductServiceService } from '../product-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { productList } from '../productList';
import { HttpClient } from '@angular/common/http';
import { AdminComponent } from '../admin/admin.component';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';



const validRequired = Validators.required;
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  
  productRowdata!: productList[];
  
  selectedFile: any;
  constructor(
    
    private productservice : ProductServiceService,
    private router: Router,
    private route: ActivatedRoute,
    private http:HttpClient,
    private dialogRef: MatDialogRef<AddProductComponent>,
              
    ) { }

  ngOnInit(): void {
    
    //let adminComponent = new AdminComponent();
  }

  // FieldProductName: FormControl = new FormControl('', [validRequired]);
  // FieldProductCategory: FormControl = new FormControl('', [validRequired]);
  // FieldProductDescription: FormControl = new FormControl('', [validRequired]);
  // FieldProductImage: FormControl = new FormControl('', [validRequired]);
  // FieldProductPrice: FormControl = new FormControl('', [validRequired]);
  // FieldThresholdValue: FormControl = new FormControl('', [validRequired]);


  AddProductForm: FormGroup = new FormGroup({

    // FieldProductName: this.FieldProductName,
    // FieldProductCategory: this.FieldProductCategory,
    // FieldProductDescription: this.FieldProductDescription,
    // FieldProductImage: this.FieldProductImage,
    // FieldProductPrice: this.FieldProductPrice,
    // FieldThresholdValue: this.FieldThresholdValue,

    FieldProductName: new FormControl('', [validRequired]),
    FieldProductCategory: new FormControl('', [validRequired]),
    FieldProductDescription: new FormControl('', [validRequired]),
    FieldProductImage: new FormControl('', [validRequired]),
    FieldProductPrice: new FormControl('', [validRequired]),
    FieldThresholdValue: new FormControl('', [validRequired])

  });

  //buttonLoding = false;
  public isCreated: any;
  imgURL: any;
  
  @Input() selectedData: any = {

    productName: '',
    productCategory: '',
    productDescription: '',
    productImage: '',
    productPrice: '',
    thresholdValue: ''
  };

  onSubmit() {
    const uploadData = new FormData();
    uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
    this.selectedFile.imageName = this.selectedFile.name;
    this.http.post('http://localhost:8080/product/upload', uploadData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          
          //this.AddProductForm.reset(this.AddProductForm.value);
          this.dialogRef.close();
          //alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.AddProductForm.value));
          console.log('Image uploaded successfully');

        } else {
          console.log('Image not uploaded successfully');
        }
      }
      ); 
    //this.buttonLoding = true;
    this.selectedData.productName = this.AddProductForm.get('FieldProductName')!.value;
    this.selectedData.productCategory = this.AddProductForm.get('FieldProductCategory')!.value;
    this.selectedData.productDescription = this.AddProductForm.get('FieldProductDescription')!.value;
    this.selectedData.productImage = this.AddProductForm.get('FieldProductImage')!.value;
    this.selectedData.productPrice = this.AddProductForm.get('FieldProductPrice')!.value;
    this.selectedData.thresholdValue = this.AddProductForm.get('FieldThresholdValue')!.value; 
    this.productservice.addProduct(this.selectedData).subscribe((response:any) => { 
       console.log(response);
       if (this.AddProductForm.invalid) {
        return;
        }
       
      }
    );
  }

  onClose() {
    this.dialogRef.close();
    //window.location.reload();
    //this.refreshData();
    //this.router.navigate(['/admin']);
  }
 // this.dialogRef.close()

  onFileChanged(event:any){
    console.log(event);
    this.selectedFile = event.target.files[0];

    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };
  }
  // refreshData(){
  //   this.productservice.getProduct().subscribe(data => {
  //     this.productRowdata =data;
  //     console.log(data);
  //   });
  // }
}
