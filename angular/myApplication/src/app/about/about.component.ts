import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
pagename="this is about home page";
password="";
username="";
  constructor() { }

  ngOnInit(): void {
  }
  validate(){
    if(this.username==""){
      alert("Please enter user name");
    }
    else if(this.password==""){
      alert("Password must not be empty");
    }
    else{
      alert("every thing is okay");
    }
  }
}
