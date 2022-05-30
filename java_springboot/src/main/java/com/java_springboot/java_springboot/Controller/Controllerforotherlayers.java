package com.java_springboot.java_springboot.Controller;

import com.java_springboot.java_springboot.Model.customersmodel;
import com.java_springboot.java_springboot.Request.reqpojo;
import com.java_springboot.java_springboot.Response.sampleresponse;
import com.java_springboot.java_springboot.Service.sampleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controllerforotherlayers {
    @Autowired //is to inject the service class in the controller, it is also known as dependency injection
    sampleservice samples;// object created for service

    @GetMapping("all")
    public ResponseEntity<?> sampleservicetestall(@RequestBody reqpojo obj ){
           sampleresponse res1=new sampleresponse();
           res1.setMessage("this is proper response");
           res1.setOurresponse("this is proper our response");
           return ResponseEntity.ok(res1);
        // return ResponseEntity.ok(samples.getsampleservice()+""+res1.getMessage()+""+obj.getName()+""+obj.getEmail());
    }
    @PostMapping("servicetest")
    public String sampleservicetest(@RequestBody reqpojo obj){
        return samples.getsampleservice()+""+ obj.getEmail()+""+obj.getName();// sending the response from the sampleservice
    }
    @GetMapping("servicepojo")//pojo (customised) response from the service
    public ResponseEntity<?> servicepojo(@RequestBody reqpojo obj){
        sampleresponse res= samples.serviceresponsepojo();
          return ResponseEntity.ok(res);

    }
    @GetMapping ("selectcustomers")
    public ResponseEntity<?> getcustomers(){
        List<customersmodel> res= samples.Selectcustomers();
        return ResponseEntity.ok(res);

    }
}


