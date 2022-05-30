package com.java_springboot.java_springboot.Service;

import com.java_springboot.java_springboot.Model.bankdatamodel;
import com.java_springboot.java_springboot.Repo.bankdatarepo;
import com.java_springboot.java_springboot.Request.bankreq;
import com.java_springboot.java_springboot.Response.bankdetailsres;
import com.java_springboot.java_springboot.Response.bankres;
import com.java_springboot.java_springboot.configuration.CustomException;
import com.java_springboot.java_springboot.configuration.Email;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class bankdataservice {

    @Autowired
    bankdatarepo repo;
    @Autowired
    Environment env;
    public void userreg(bankreq request){
        bankdatamodel model=new bankdatamodel();
        model.setEmail(request.getEmail());
        model.setName(request.getName());
        model.setPassword(request.getPassword());
        model.setAddress(request.getAddress());
        repo.save(model);

    }
    public bankdetailsres userlogin(bankreq request) throws CustomException {
        Optional<bankdatamodel>opt=repo.loginvalidation(request.getEmail(),request.getPassword());
           System.out.println("okayopt");
        if(opt.isPresent()){
            bankdatamodel model= opt.get();
            String token= generatetoken(model.getEmail());
            bankdetailsres details=new bankdetailsres();
            details.setId(model.getId());
            details.setName(model.getName());
            details.setEmail(model.getEmail());
            details.setAddress(model.getAddress());
            updatetoken(model.getId(),token);
            details.setToken(token);
            System.out.println("okayopt1");
            return details;
        }
        else{
            throw new CustomException("user or password is wrong");
        }
    }

   public List <bankdatamodel> selectcustomers(){
        return repo.findAll();
    }
    public void updatetoken(int id,String token){
        repo.tokenupdate(token,id);

    }

   public String generatetoken(String object) throws CustomException {
        try{
            //SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS256;
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            long ttlMillis = 1000*1000*1000;//in what time it will expire
            long expMillis = nowMillis+ttlMillis;//5secs token
            Date exp=new Date(expMillis );

            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(env.getProperty("SECRET_KEY"));
            //read the value from the application property file.

            JwtBuilder builder = Jwts.builder()
                    .setIssuedAt(now)
                    .setSubject(object)
                    .signWith(SignatureAlgorithm.HS256, apiKeySecretBytes)
                    .setExpiration(exp);
            return builder.compact();//helps to create JWT token
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }
    public boolean passwordupdate(bankreq req) throws Exception{
        Optional<bankdatamodel>opt= repo.findById(req.getId());
        if(opt.isPresent()){
        repo.passwordupdate(req.getId(),req.getPassword());
        return true;
    }
        else{
            throw new Exception("user not found");
        }

        }

        public boolean TokenValidation(String token, String id) throws Exception{
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(env.getProperty("SECRET_KEY"))//read the value from the application prop file.
                        .parseClaimsJws(token)
                        .getBody();
                Integer id_int = Integer.parseInt(id);//convert str to int;
                repo.tokenvalidation(token,id_int).orElseThrow(() -> new Exception("token is not validated"));
                return true;
            } catch (java.text.ParseException e) {
                throw e;
            }
        }
    public void logout(Integer id){
       this.updatetoken(id,"");
    }


}

