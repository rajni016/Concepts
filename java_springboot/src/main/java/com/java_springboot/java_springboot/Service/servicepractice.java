package com.java_springboot.java_springboot.Service;

import com.java_springboot.java_springboot.Model.regpostmodel;
import com.java_springboot.java_springboot.Repo.regpostrepo;
import com.java_springboot.java_springboot.Request.reqpojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class servicepractice {
    @Autowired
    regpostrepo repo;
    public String servicereturn(){
        return"this is service practice";
    }
    public String servicereturnpojo(){
        reqpojo req=new reqpojo();
        return "This is getting parameters from pojo from service class"+"\t"+req.getEmail()+"\t"+req.getName();

    }
    public List<regpostmodel> selectregpostmodel(){
        return repo.findAll();

    }

}
