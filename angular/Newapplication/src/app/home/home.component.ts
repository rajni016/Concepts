import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bindingv="binding by ngModel";
  detailsofcandidates=false;
  cssclasschange="blue";
  Getdata:any=[];
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }
CandidatesDetails=[
  {name:"s", rank:136},
  {name:"n", rank:100},
  {name:"e", rank:1},
  {name:"h", rank:12},
  {name:"a", rank:160},
  {name:"I", rank:178},
  {name:"A", rank:201},
  {name:"S", rank:98},
];
Candidatedetailsmethod(){
  this.detailsofcandidates=!this.detailsofcandidates;
}
Changecolorbycss(classname:any){
  this.cssclasschange=classname;
}
reqapidata(){
  this.http.get("https://reqres.in/api/users?page=2").subscribe(
    (res:any)=>{
      this.Getdata=res['data'];
      console.log(res);
    }
  )
  
}
}
