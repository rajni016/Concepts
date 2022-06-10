import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input() currentpage="";
  isLoggedIn=false;

  constructor(private service:CustomerService , private router:Router) {
    console.log("working");
    this.isLoggedIn=(this.service.checktoken())?true:false;
     
   }

  ngOnInit(): void {
  }
logout(){
  this.service.logout();
  // after logout navigate the user to home or login page
  // Navigation in ts file, we use router library
  this.router.navigateByUrl('login');
}
}
