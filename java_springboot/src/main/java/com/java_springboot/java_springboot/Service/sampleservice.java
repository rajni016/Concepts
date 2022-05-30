package com.java_springboot.java_springboot.Service;


import com.java_springboot.java_springboot.Model.customersmodel;
import com.java_springboot.java_springboot.Repo.customersrepo;
import com.java_springboot.java_springboot.Request.reqpojo;
import com.java_springboot.java_springboot.Response.sampleresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sampleservice {
@Autowired
customersrepo customers; // injecting the repository in the service class

public String getsampleservice(){

    return "sample service response";
    }
    //we cannot use entityresponse in the service class
    public sampleresponse serviceresponsepojo (){
        sampleresponse obj=new sampleresponse();
        obj.setMessage("response through service class");
        obj.setOurresponse("our response through service class");
        return obj;
    }

    public List<customersmodel> Selectcustomers(){
        return customers.findAll();// findall can be used to select the data

    }
}
