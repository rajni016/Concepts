import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import{usertype} from '../Datatype';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})

export class ProductsComponent implements OnInit {

   productArray:any=[];
  userarray:usertype[]=[];
  errormessage="";
  constructor( private http:HttpClient, private service:CustomerService) {
    if(!this.service.checktoken()){
         this.errormessage="please login"
    }
    else{
      this.getUsers(); //to load the method whenever page is loaded(when ever the product is clicked it displays user data)
      // this.getCustomers();
      this.productArray=[
        {name:'product1.jpg', "product_name":"Vegetables","id":1},
        {name:'product2.jpg',"product_name":"Wheat","id":2},
        {name:'product3.jpg',"product_name":"Fruits" ,"id":3},
        {name:'product4.jpg',"product_name":"Flowers","id":4},
        {name:'product5.jpg',"product_name":"Sheep","id":5},
      ];
      }
   
    }
   
  ngOnInit(): void {
  }
  getUsers(){
    this.http.get("https://reqres.in/api/users?page=2").subscribe((res:any)=>{
          this.userarray=res['data'];
    })
  }
  getCustomers(){
    this.http.get("http://localhost:8080/CustomerRegistration/selectcustomersregpost").subscribe((res:any)=>{
         console.log(res['data']);
    })
  }
  
 
}
