import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommonserviceService {

  constructor(private http:HttpClient) { }
  printMessage(){
    console.log("Inject the common service in component.ts, same like httpclient")
  }
  Showalertmethod(message:any){
    alert(message);
  }
}
