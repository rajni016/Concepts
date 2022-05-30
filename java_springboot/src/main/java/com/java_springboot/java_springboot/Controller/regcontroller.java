package com.java_springboot.java_springboot.Controller;

import com.java_springboot.java_springboot.Model.customersmodel;
import com.java_springboot.java_springboot.Model.regpostmodel;
import com.java_springboot.java_springboot.Request.requser;
import com.java_springboot.java_springboot.Response.regresponse;
import com.java_springboot.java_springboot.Service.regservice;
import com.java_springboot.java_springboot.configuration.Email;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.servlet.annotation.MultipartConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("CustomerRegistration")// all the end point url comes under this Customerregistration,
// http://localhost:8080/CustomerRegistration/customerreg

public class regcontroller {
    @Autowired
    regservice regs;
    private static final Logger logger = LogManager.getLogger(regcontroller.class);

    @PostMapping("cutsomerreg")
    public ResponseEntity customerreg(@RequestBody requser re) {
        regs.storereg(re);
        regresponse response = new regresponse();
        response.setResponse("'email is valid");
        response.setStatus("200");
        return ResponseEntity.ok(response);
    }

    @PostMapping("customerregerror")
    public ResponseEntity customerregerror(@RequestBody requser request) {
        regresponse response = new regresponse();
        try {
            if (request.getPassword() == null || request.getPassword().equals("")) {
                throw new Exception("Password shouldnot be empty");
            }
            regs.storereg(request);
            response.setResponse("User Registration successful");
            response.setStatus("200");
        } catch (Exception e) {
            response.setResponse("Error" + e.getMessage());
            response.setStatus("Status code:400" + e.getMessage());
            return ResponseEntity.badRequest().body(response);

        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("login")
    public ResponseEntity<?> userlogin(@RequestBody requser request) {
        regresponse response = new regresponse();
        logger.info("this is login");// similar to sys out
        try {
            if (request.getEmail() == null || request.getEmail().equals("")) {
                throw new Exception("Email should not be empty");
            }
            if (request.getPassword() == null || request.getPassword().equals("")) {
                throw new Exception("Password should not be empty");
            }
            regs.logincheck(request);
            response.setResponse("User Exists");
            response.setStatus("200 okay");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.setResponse("" + e.getMessage());
            response.setStatus("" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

    }


    @PostMapping("emailcheck")
    public ResponseEntity<?> emailcheck(@RequestBody requser request) {
        regresponse reg = new regresponse();
        try {
            if (request.getEmail() == null || request.getEmail().equals("")) {
                throw new Exception("Entered email shouldnot be empty");
            }
            regs.emailcheck(request);
            reg.setResponse("Email is valid");
            reg.setStatus("200 okay");
            return ResponseEntity.ok(reg);
        } catch (Exception e) {
            reg.setResponse("" + e.getMessage());
            reg.setStatus("Bad request");
            return ResponseEntity.badRequest().body(reg);
        }


    }

    @PostMapping("mailcheck")
    public ResponseEntity<?> mailcheck(@RequestBody requser request) {
        regresponse reg = new regresponse();
        try {
            if (request.getEmail() == null || request.getEmail().equals("")) {
                throw new Exception("Entered email shouldnot be empty");
            }
            regs.mailcheck(request);
            reg.setResponse("Email is valid");
            reg.setStatus("200 okay");
            return ResponseEntity.ok(reg);
        } catch (Exception e) {
            reg.setResponse("" + e.getMessage());
            reg.setStatus("Bad request");
            return ResponseEntity.badRequest().body(reg);
        }


    }

    @PostMapping("passwordupdate")
    public ResponseEntity<?> password_update_controller(@RequestBody requser req) {
        regresponse response = new regresponse();
        try {
            if (req.getPassword() == null || req.getPassword().equals("")) {
                throw new Exception("password should not be empty");
            }
            regs.passwordupdate(req);
            response.setResponse("password is updated suceessfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponse("Error" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }


    }

 @PostMapping("passwordupdatequery")
    public ResponseEntity<?> password_update(@RequestBody requser req) {
        regresponse regresponse = new regresponse();
        try {
            if (req.getPassword() == null || req.getPassword().equals("")) {
                throw new Exception("password should not be empty");
            }
            regs.passwordupdatebyquery(req);
            regresponse.setResponse("Updated successfully");
            return ResponseEntity.ok(regresponse);

        } catch (Exception e) {
            e.printStackTrace();
            regresponse.setResponse("Password updation failed");
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping("deletecustomer")
    public ResponseEntity<?> deletecustomer(@RequestBody requser req) {
        regresponse res = new regresponse();
        try {
            regs.deleteuser(req.getId());
            res.setResponse("user valid");
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            res.setResponse("" + e.getMessage());
            return ResponseEntity.badRequest().body(res);

        }
    }

    @PostMapping("deletecustomerbyquery")
    public ResponseEntity<?> deletecustomerbyquery(@RequestBody requser req) {
        regresponse res = new regresponse();
        try {
            regs.deleteuserbyquery(req);
            res.setResponse("user valid");
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            res.setResponse("" + e.getMessage());
            return ResponseEntity.badRequest().body(res);

        }
    }

   @GetMapping("selectcustomersregpost")
    public ResponseEntity<?> getcustomers() {
        return ResponseEntity.ok(regs.Selectcustomers());

    }



    //to customise the file size you can change it in application properties
    @PostMapping("fileupload")// file upload must be through post//and through request param
    public ResponseEntity file_upload(@RequestParam MultipartFile file) {
        regresponse res = new regresponse();

        try {
            byte[] bytes = file.getBytes();
            String foldertostore = "C:\\Users\\sreeram\\Downloads\\uploadfolderserver";//
           // System.out.println(file.getOriginalFilename() + "" + file.getContentType());//content of the file cannot be updated
            Path path = Paths.get(foldertostore + file.getOriginalFilename());
            Files.write(path, bytes);// for saving the files
            if (file.getContentType().equals("image/jpeg")) {
                res.setResponse("file upload success");
                return ResponseEntity.ok(res);
            }
            else{
                res.setResponse("fail");
                return ResponseEntity.badRequest().body(res);
            }

        }
        catch(IOException e){
            e.printStackTrace();
            res.setResponse("file upload fail");
            return ResponseEntity.badRequest().body(res);
        }
    }// file parameter should be  mentioned in post map as raw>> form data





    @GetMapping(value = "filedownload/{filename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
        //octet stream value help us to enter any format of image,Image_PNG_VALUE(only png value)
        public @ResponseBody byte[] file_download (@PathVariable String filename){
            try {
                String foldername = "C:\\Downloads" + filename;
                InputStream in = new FileInputStream(foldername);

                return IOUtils.toByteArray(in);

            } catch (Exception e) {
                return null;
            }

        }

    @PostMapping("logint")
    public ResponseEntity<?> userlogint (@RequestBody requser request){
      regresponse response = new regresponse();
      logger.info("this is login");
        try {
            if (request.getEmail() == null || request.getEmail().equals("")) {
                throw new Exception("Email should not be empty");
            }
           if (request.getPassword() == null || request.getPassword().equals("")) {
               throw new Exception("Password should not be empty");
            }

            return ResponseEntity.ok(regs.logintoken(request));

        } catch (Exception e) {
            logger.error("this is login error");
            e.printStackTrace();

            return ResponseEntity.badRequest().body(response);
        }

    }
    @PostMapping("logintE")
    public ResponseEntity<?> userlogintE (@RequestBody requser request) throws Exception{
        regresponse response = new regresponse();
        logger.info("this is login");

            if (request.getEmail() == null || request.getEmail().equals("")) {
                throw new Exception("Email should not be empty");
            }
            if (request.getPassword() == null || request.getPassword().equals("")) {
                throw new Exception("Password should not be empty");
            }

            return ResponseEntity.ok(regs.logintoken(request));

        }
    @PostMapping("passwordupdatequeryE")
    public ResponseEntity<?> password_updateE(@RequestBody requser req) throws Exception {
        regresponse regresponse = new regresponse();

            if (req.getPassword() == null || req.getPassword().equals("")) {
                throw new Exception("password should not be empty");
            }
            regs.passwordupdatebyquery(req);
            regresponse.setResponse("Updated successfully");
            return ResponseEntity.ok(regresponse);

    }
    @PostMapping("logoutE")
    public ResponseEntity<?> LogoutE(@RequestHeader String user_id) throws Exception {
        regresponse regresponse = new regresponse();
        int user_id_int=Integer.parseInt(user_id);
        regs.logout(user_id_int);
        regresponse.setResponse("logged out successfully");
        return ResponseEntity.ok(regresponse);

    }
 /*   @PostMapping("logintJ")
    public ResponseEntity<?> userlogintEjwt (@RequestBody requser request) throws Exception{
        regresponse response = new regresponse();

        if (request.getEmail() == null || request.getEmail().equals("")) {
            throw new Exception("Email should not be empty");
        }
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new Exception("Password should not be empty");
        }

        return ResponseEntity.ok(regs.logintokenJwt(request));

    }*/
 @GetMapping("storecache")
 public ResponseEntity<?> storecache() {
     regs.storeincache();
     return ResponseEntity.ok("store cache");

 }
    @GetMapping("getcache")
    public ResponseEntity<?> getcache() {
        String val= regs.getIncache();
        System.out.println(val);
        return ResponseEntity.ok(val);

    }
    @GetMapping("sampleemail")
    public ResponseEntity<?> sampleemail() {
        Email.sendEmail("fakesmtp@gmail.com","subject","body");
        return ResponseEntity.ok("sent email");

    }

}









