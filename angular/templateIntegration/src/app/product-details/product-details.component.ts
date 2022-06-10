import { HttpClient} from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { usertype } from '../Datatype';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
   userdetails:usertype={
    id:0,
    email:'',
    first_name:'',
    last_name:'',
    avatar:'',
   };

  constructor (private router:ActivatedRoute, private http:HttpClient) {
    this.router.paramMap.subscribe((res:any)=>{
      console.log(res['params']);
      this.getUserdetailsbyid(res['params']['products_id']);
    });

  }

  ngOnInit(): void {
  }
  getUserdetailsbyid(userId:any){
    this.http.get("https://reqres.in/api/users/"+userId).subscribe((res:any)=>{
      this.userdetails= res['data'];
      console.log(res);
      
    });
  }

}
