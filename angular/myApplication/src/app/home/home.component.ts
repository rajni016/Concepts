import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonserviceService } from '../commonservice.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 pagename="Sample Home page Component, binding";
 message="";
 age="";
 HideorShow=false;
 person={name:"object name", "age":30, "email":"objcetemail@gmail.com"};
 cssClassname="red";
 HideCitypop=true;
 userResponse:any=[];
 username="";
 jobname="";
 searchtext="";

// creating the object for http client using constructor
  constructor(private http:HttpClient, private common:CommonserviceService) { }

  ngOnInit(): void {
  }
  hideandshowmethod(){
    this.HideorShow=!this.HideorShow;


  }
 
  personDetails=[
    {"name":"Name1", "age":31},
    {"name":"Name2", "age":30},
    {"name":"Name3", "age":28},
    {"name":"Name4", "age":27},
    {"name":"Name5", "age":15},
    {"name":"Name6", "age":10},
    {"name":"Name7", "age":35},
    {"name":"Name7", "age":36},
    

  ];


  Cityname=[
    {name:"city1", pop:100},
    {name:"city2", pop:121},
    {name:"city3", pop:400},
    {name:"city4", pop:150},
    {name:"city5", pop:4900},
    {name:"city6", pop:200},
    {name:"city7", pop:300},
  ];
  changeCssclassnamemethod(className:any){
    this.cssClassname=className;
  }
 cityhideandshow(){
  this.HideCitypop=!this.HideCitypop;

 }
 getuser(){
   this.http.get("https://reqres.in/api/users?page=2").subscribe(
     (res:any)=>{
     this.userResponse= res['data'];
     console.log(res);
   }
   )
       
 }
 postUser(){
   if(this.username==""){
     alert("user name must not be empty")
     return;
   }
   else if(this.jobname==""){
    alert("job name must not be empty")
    return;
   }

   let req={
     "name":this.username,
     "job":this.jobname
   }
   this.http.post("https://reqres.in/api/users",req).subscribe(
     (res:any)=>
   {
console.log(res);
     this.username="";
     this.jobname="";
   })
 }
 callservicemethod(){
   this.common.printMessage(); // common is the object created for service named common service
 }
 }
  
  

