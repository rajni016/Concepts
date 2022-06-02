import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  username="";
  email="";
  HideOrShowmarks=false;
  cssClassname= "subjectlist";
  currentDate=new Date;
  num=2;
  num1=6;

  constructor() { }

  ngOnInit(): void {
  }
  Textareacheck(){
    if(this.username==""){
      alert("user name must not be empty")
    }
    else if(this.email==""){
      alert("email must not be empty")

    }

  }
  Subjectslist=[
    {name:"Maths",marks:30},
    {
      name:"Science",
      marks:50
    },
    {
      name:"Maths-2",
      marks:90
    },
    {
      name:"Physics",
      marks:35
    },
    {
      name:"Social",
      marks:80
    }
  ];

  
  HideorShowmarksmethod(){
    this.HideOrShowmarks=!this.HideOrShowmarks;

  }
   
  

}
