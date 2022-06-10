import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email:any="";
  password="";
  customerdata:any=[];
    response:any="";
    emailReg:any="";
    passwordReg="";
   
  constructor(private http:HttpClient, private service:CustomerService,
    private Activatedrouter:ActivatedRoute , private  router:Router ) { 
    
  }

  ngOnInit(): void {
  }
  login(){
    let req={
      email:this.email,
      password:this.password
    }
    this.http.post("http://localhost:8080/CustomerRegistration/logintE", req).subscribe((res:any)=>{
      console.log(res);
      // localStorage.setItem('user-data', JSON.stringify(res))  // added in service
      // localStorage.setItem('user-token', res['token'])   
      // localStorage.setItem('user-id', res['id'])
      this.service.storecustomerdata(res)  ;
      alert("Entered Credentials are correct");
      this.router.navigateByUrl('home')
 
  },
  err=>{
    alert("Invalid Credentials");
  });
  }

  selectcustomers(){
    this.http.get("http://localhost:8080/CustomerRegistration/selectcustomersregpost").subscribe((res:any)=>{
     
        this.customerdata=res;
        console.log(res);
  });
  }

  
  Registration(){
    let req={
      email:this.email,
      password:this.password
    }
    this.http.post("http://localhost:8080/CustomerRegistration/customerregerror",req).subscribe((res:any)=>{
      console.log(res);
      alert("Registration Successful") 
    },
    err=>{
      alert("Unsuccessful");
    }
    
    );
  }


}
