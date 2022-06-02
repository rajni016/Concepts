import { Component, OnInit } from '@angular/core';
import { CommonserviceService } from '../commonservice.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
pagename="this is about home page";
password="";
username="";
currencypipe=100;
num=2;
num1=6;
currentDate= new Date;
userresponse:any=[];
Loadershown=false;

  constructor(private service:CommonserviceService, private http:HttpClient) { }

  ngOnInit(): void {
  }
  validate(){
    if(this.username==""){
      //alert("Please enter user name");
      this.service.Showalertmethod("Please enter user name");//calling the logic from service
    }
    else if(this.password==""){
      //alert("Password must not be empty");
      this.service.Showalertmethod("Password must not be empty");
    }
    else{
      alert("every thing is okay");// alert from component itself
    }
  }
  Servicemethod(){
    this.service.printMessage();
  }
  servicealertmethod(){
    this.service.Showalertmethod("Common alert");
  }
  getapi(){
    this.http.get("https://reqres.in/api/users?page=2").subscribe(
      (res:any)=>{
        this.userresponse=res['data'];
        console.log(res);

    })
   

    }
    loaderapi(){
      this.Loadershown=true;
      this.http.get("https://reqres.in/api/users?delay=3").subscribe(
        (res:any)=>{
          console.log(res);
          this.Loadershown=false;
        }

      )
    }
  }

