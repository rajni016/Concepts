import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
email="";
password="";
userresponse=""


  constructor(private http:HttpClient) { }

  ngOnInit(): void {
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
