package com.java_springboot.java_springboot.Controller;

import com.java_springboot.java_springboot.Request.bankreq;
import com.java_springboot.java_springboot.Response.bankres;
import com.java_springboot.java_springboot.Service.bankdataservice;
import com.java_springboot.java_springboot.configuration.CustomException;
import com.java_springboot.java_springboot.configuration.Email;
import com.java_springboot.java_springboot.configuration.SampleScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("bankdata")
public class bankdatacontroller {
    @Autowired
    bankdataservice service;

    @GetMapping("cutsomerreg")
    public ResponseEntity<?> registration(@RequestBody bankreq req) throws Exception {
        bankres res = new bankres();
        if (req.getEmail() == null || req.getEmail().equals("")) {
            throw new Exception("email should not be empty");
        }
        if (req.getPassword() == null || req.getPassword().equals("")) {
            throw new Exception("password should not be empty");
        }
        if (req.getName() == null || req.getName().equals("")) {
            throw new Exception("name should not be empty");

        } else {
            req.getName();
            req.getEmail();
            req.getPassword();
            req.getAddress();
            service.userreg(req);
            res.setMessage("registration successful");
            return ResponseEntity.ok(res);

        }
    }

    @PostMapping("/logintE")
    public ResponseEntity<?> login(@RequestBody bankreq request) throws CustomException {
        bankres res = new bankres();
        if (request.getEmail() == null || request.getEmail().equals("")) {
            throw new CustomException("email should not be empty");
        }
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new CustomException("password should not be empty");
        } else {
            request.getEmail();
            request.getPassword();
            return ResponseEntity.ok(service.userlogin(request));
        }


    }

    @PostMapping("passwordupdate")
    public ResponseEntity<?> passwordupdate(@RequestBody bankreq req) throws Exception {
        bankres res = new bankres();
        if (req.getId() == null || req.getId().equals("")) {
            throw new Exception("email should not be empty");
        }
        if (req.getPassword() == null || req.getPassword().equals("")) {
            throw new Exception("password should not be empty");
        } else {
            req.getId();
            req.getPassword();
            service.passwordupdate(req);
            res.setMessage("password change successful");
            return ResponseEntity.ok(res);

        }
    }
    @PostMapping("logout")
public ResponseEntity<?>logout(@RequestHeader String user_id){
        bankres res=new bankres();
        Integer user_id_int=Integer.parseInt(user_id);
        res.setMessage("logout successful");
        service.logout(user_id_int);
        return ResponseEntity.ok(res);

        }
/*@GetMapping("emailsent")
    public ResponseEntity<?>emailtoadmin(){
    Email.sendEmail("admin@gmail.com","transcationslist", SampleScheduler.bankdatadetails());
}*/
@PostMapping("SelectCustomers")
    public ResponseEntity<?>selectcustomers(){
      return ResponseEntity.ok( service.selectcustomers()) ;
}
    }
