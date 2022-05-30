package com.java_springboot.java_springboot.Controller;

import com.java_springboot.java_springboot.Model.regpostmodel;
import com.java_springboot.java_springboot.Request.reqpojo;
import com.java_springboot.java_springboot.Response.sampleresponse;
import com.java_springboot.java_springboot.Service.servicepractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllerpractice {
    @Autowired
    servicepractice practice;

    @GetMapping("gtestp")
    public String practicetest(@RequestParam String name, @RequestParam int number) {
        return "This is for your understanding" + name + number;
    }

    @PostMapping("ptestp/{number}")
    public String practicetestpost(@PathVariable Integer number) {
        return "This is using path varaibale" + number;
    }

    @PostMapping("Rtestp")
    public String practicetestrequest(@RequestBody String name) {
        return "this is for request body" + name;
    }

    @PostMapping("Rtestpojo")
    public String practicetestpojo(@RequestBody reqpojo obj) {
        return "Requestbody with the pojo class " + obj.getName() + obj.getEmail();
    }

    @PostMapping("Response")
    public ResponseEntity<?> responseproper(@RequestBody reqpojo obj) {
        sampleresponse res = new sampleresponse();
        res.setMessage("Your email is received");
        res.setOurresponse("Your email is verified");
        return ResponseEntity.ok(res);
    }

    @PostMapping("spojo")
    public String serviceresponsepojo() {
        return practice.servicereturnpojo();
    }

    @PostMapping("regpost")
    public ResponseEntity<?> selectregpost() {
        List<regpostmodel> list = practice.selectregpostmodel();
        return ResponseEntity.ok(list);
    }

    @PostMapping("error")
    public ResponseEntity<?> customisederrorstatuscode() {
        sampleresponse res=new sampleresponse();
        res.setOurresponse("This is custmoised status code");
        res.setMessage("Status code is bad is request");
        return ResponseEntity.badRequest().body(res);// It will automatically send 400 bad request by changing the status code

    }




    }


