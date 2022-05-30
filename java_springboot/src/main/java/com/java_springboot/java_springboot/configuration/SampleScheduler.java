package com.java_springboot.java_springboot.configuration;

import com.java_springboot.java_springboot.Controller.bankdatacontroller;
import com.java_springboot.java_springboot.Service.bankdataservice;
import com.java_springboot.java_springboot.Service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
public class SampleScheduler {
  // @Scheduled(fixedDelay = 1000)// after restarting the server for every 1000 millis it will print a message
  // public void printmessage(){
     //System.out.println("this is cron job"+System.currentTimeMillis());

  // }
    @Autowired
   regservice regs;
    @Autowired
    bankdataservice service;

    @Scheduled(cron="10 23 20 * * *")// this will be execeuted at one time at 6;54.10 second;
    // if you want execute from starting of the minute put * instead of 10
    public void cronjob(){
        System.out.println("good job");

    }

    @Scheduled(cron=" * 24 20 * * *")
    public void cronjobdatabase(){
         regs.Selectcustomers().forEach((o)->{
             System.out.println(o.getEmail()+o.getId());
                 });

    }
   @Scheduled(cron="* 34 20 * * *")
 public void bankdatadetails(){
      // String data=null;
       StringBuilder obj=new StringBuilder();
       regs.Selectcustomers().forEach((o)->{
           System.out.println(o.getEmail()+o.getId());
          //ata+= o.getEmail()+o.getId();
           obj.append(o.getId()+o.getEmail());
       });

       Email.sendEmail("admin@gmail.com","transcationslist", obj.toString());



   }

}
