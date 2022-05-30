package com.java_springboot.java_springboot.Controller;

import com.java_springboot.java_springboot.Request.reqpojo;
import com.java_springboot.java_springboot.Response.sampleresponse;
import com.java_springboot.java_springboot.Service.regservice;
import com.java_springboot.java_springboot.Service.servicepractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//will send the text response or json response
//@Requestparams is the annotation to receive the parameters from the client request
// 3 ways to receive the data fromclient, @Requestparam(images, files), @Pathvaribale(simple strings, parameter is entered in the url),
// @RequestBody(get mapping,raw data, can receive not only string or any other data type, can receieve pojo class also)
//Mmetioning the request body with the pojo class, json is the data type to post
@RestController
public class Samplecontoller {
    @Autowired
    Environment env;
    @Autowired
    servicepractice practice;
    @Autowired
    regservice regs;
    @GetMapping("testget")//test is the url where we can access----http://localhost:8080/testget(test get is the endpoint url)
    public String sampleGetMethod(){

        return "sample response for get method";
    }
    @PostMapping("testpost")
    public String samplePostmethod(){

        return"sample response for post method";
    }
    @PostMapping("postparams")
    public String SampleparamsMethod(@RequestParam String name){

        return "request params"+ name;
    }


    @GetMapping("getparams")
    public String SamplepostParamsmethod(@RequestParam int id,@RequestParam String name){
        return "post request params"+id+name;
    }



    @PostMapping("testpath/{username}")
    public String Samplepathvaribale (@PathVariable  String username){
        return "this is pathvariable to get the data"+ username;
    }



    @PostMapping("req_body")//passed through body
    public String SamplerequestBodyModel(@RequestBody String name){

        return"this is request body eaxmple "+ name;
    }
    @PostMapping("reqbody_pojoclass")// reqpojo is the pojo class, datatype is replaced with pojo data type and object is created
    public String Sample_requestBody_pojoclass(@RequestBody reqpojo obj){
        return "Request body sample for pojoclass"+obj.getEmail()+""+obj.getName();

    }


    @GetMapping("properresponse")
    public ResponseEntity<?> SampleresponseMethod(){// as we are not sending the message through traditional data type,
        // sending it through pojo class, we need tu use responseentity
        sampleresponse res=new sampleresponse();
        res.setMessage("this is proper way of sending the response");
        return ResponseEntity.ok(res);

    }
    @PostMapping("properresponse1")
    public ResponseEntity<?> sampleresponsemethod1(){
        sampleresponse resp1=new sampleresponse();
        resp1.setMessage("this proper way of sending message");
        resp1.setOurresponse("this proper of sending message using pojo class");
        return ResponseEntity.ok(resp1);
    }
    @PostMapping("simpleservicemessage")
    public String returnsample(){
        return practice.servicereturn();
    }
    @GetMapping("env")
    public ResponseEntity<?> getenv() {
        String val = env.getProperty("Systemname");
        return ResponseEntity.ok(val);


    }

}
