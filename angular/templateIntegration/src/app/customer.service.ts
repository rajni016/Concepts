import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }
// this method is called from the login.ts
  storecustomerdata(data:any){
    localStorage.setItem('user-data',JSON.stringify(data));
    localStorage.setItem('user-token', data['token'] );
    localStorage.setItem('user-id',data['id']);
  }
  checktoken(){
   let token=localStorage.getItem("user-token");
   console.log(token);
    if(token==""|| token==undefined){
      return false;
    }else{
      return true;
    }
   
  }
  // Logging out by removing the token from the local storage
  //doesnot require value, key is enough
  logout(){
    localStorage.removeItem('user-data');
    localStorage.removeItem('user-token' );
    localStorage.removeItem('user-id');
  }
}
