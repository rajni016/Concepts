package com.java_springboot.java_springboot.Service;

import com.java_springboot.java_springboot.Controller.regcontroller;
import com.java_springboot.java_springboot.Model.regpostmodel;
import com.java_springboot.java_springboot.Repo.regpostexistrepo;
import com.java_springboot.java_springboot.Repo.regselectrepo;
import com.java_springboot.java_springboot.Repo.regpostrepo;
import com.java_springboot.java_springboot.Request.requser;
import com.java_springboot.java_springboot.Response.tregpostres;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class regservice {
//    String SECRET_KEY="SECRET_KEY";// is common variable for entire controller// moved to application properties


    @Autowired
    regselectrepo repo;
    @Autowired
    regpostrepo repo1;
    @Autowired
    regpostexistrepo repo2;
    @Autowired
    Environment env; // this is used to read the data from application properties
    private static final Logger logger = LogManager.getLogger(regservice.class);
    @Autowired
    EmbeddedCacheManager cacheManager;// In embedded configuration, cache storage is on same server
    //Remote cache is used for large scale storage of data and is stored on the different server
    public void storeincache()  {
        cacheManager.getCache("local-cache").put("user_token","this is cache storage");
        //key and value method.key must be unique
        // value can be anything int, String, object
    }
   public String getIncache(){
        return cacheManager.getCache("local-cache").get("user_token").toString();
    }
    public void storereg(requser req){
        regpostmodel model=new regpostmodel();
        model.setName(req.getName());
        model.setEmail(req.getEmail());
        model.setPassword(req.getPassword());
        repo.save(model);// will help to save the entered data from front end to the database

    }
    public boolean logincheck(requser request) throws Exception {

          Optional<regpostmodel> res=  repo1.check(request.getEmail(),request.getPassword());
          if(res.isPresent()){
              return true;
          }
           else{
               throw new Exception("user not exist checked with optional");
          }

        }


    public boolean emailcheck (requser req) throws Exception{

        Optional<regpostmodel> opt= repo2.checkemail(req.getEmail());
        if(opt.isPresent()){
            throw new Exception("Email or user already exist"  );
        }
        else{
           return true;
        }

    }
    public boolean mailcheck(requser req) throws Exception{
        regpostmodel model=new regpostmodel();
        Optional<regpostmodel>opt1=repo2.checkemail(req.getEmail());
        if(opt1.isPresent()){
            throw new Exception("Email or user already exist");
        }
        else{
            model.setEmail(req.getEmail());
            model.setName(req.getName());
            model.setPassword(req.getPassword());

            repo2.save(model);
            return true;

        }

    }
    // this is JPA method of updating the password using the primary key(findbyp.key)
    public boolean passwordupdate(requser request)throws Exception{
        Optional<regpostmodel>opt=repo.findById(request.getId());/// Findbyid is only applicable to the primary key.
        if(opt.isPresent()){
           regpostmodel regpost=opt.get();// we will get the customer data
           regpost.setPassword(request.getPassword());
           repo.save(regpost);
           return true;
        }else{
            throw new Exception("user not exist");
        }

    }
   public boolean passwordupdatebyquery(requser req) throws Exception{
        Optional<regpostmodel> opt=repo2.findById(req.getId());
        if(opt.isPresent()){
            repo2.passwordupdate(req.getPassword(),req.getId());
            return true;
        }else{
            throw new Exception("user doesnot exist");
        }
    }



    public boolean deleteuser(Integer id) throws Exception {
        try {
            regpostmodel model = repo2.getById(id);
            repo2.delete(model);
            return true;
        } catch (Exception e) {
            throw new Exception("user doesnot exist");
        }
    }
  public boolean deleteuserbyquery(requser req ) throws Exception{
        Optional<regpostmodel > opt= repo2.findById(req.getId());
        if(opt.isPresent()){
            repo2.deleteid(req.getId());
            return true;
        }
        else{
            throw new Exception("usr cannot be deleted" );
        }
    }





    public List<regpostmodel> Selectcustomers(){
        return repo2.findAll();// findall can be used to select the data

    }



    public tregpostres logintoken(requser request) throws Exception {

        Optional<regpostmodel>opt= repo2.check(request.getEmail(),request.getPassword());
        if(opt.isPresent()){
            logger.info("user is exist");
            regpostmodel model= opt.get();
          //String token= getToken(model.getEmail());
            String token= doGenerateToken(model.getEmail());
           tregpostres res=new tregpostres();
          res.setEmail(model.getEmail());
          res.setId(model.getId());
          res.setName(model.getName());
        UpdateToken(model.getId(),token);
          res.setToken(token);
          logger.info("token is updated and displayed to the user");
          return  res;
        }
        else{
            logger.error("USER IS NOT EXIST");
            throw new Exception("user not exist checked with optional");
        }

    }
    public void logout(int id){

        this.UpdateToken(id,"");
    }

 private void UpdateToken(int id,String token){
        cacheManager.getCache("local-cache").put("token_"+id,token);// storing the token in the cache, as key must be unique id is unique
        repo2.tokenupdate(token,id);
    }

    private String getToken(String email){
        long time=System.currentTimeMillis();
        String key=email+time;
        return Base64.getEncoder().encode(key.getBytes()).toString();

    }
//headers are used to send the request
   /* public boolean tokenValidation(String id,String token) throws Exception{
       try {
           Claims claims = Jwts.parser()
                   .setSigningKey(env.getProperty("SECRET_KEY"))//read the value from the application prop file.
                   .parseClaimsJws(token)
                   .getBody();
           Integer id_int=Integer.parseInt(id);

           // getting token from the cache based on the id
           if(cacheManager.getCache("local-cache").get("token_"+id) !=null){
               String tokencache = cacheManager.getCache("local-cache").get("token_"+id).toString();
               System.out.println(tokencache);
               if (tokencache != null) {
                   if (token.equals(tokencache)) {
                       System.out.println("token is matched from cache");
                       return true;
                   }
                   System.out.println("token is Not matched from cache");
               }

               //repo2.tokenvalidation(id_int, token).orElseThrow(()->new Exception("token is not validated"));
               }
           else {
               String tokenDb = repo2.getTokenByUserId(id_int);
               System.out.println("token is matched from database");
               if (tokenDb.equals(token)) {
                   System.out.println("token is updated in cache ");
                   cacheManager.getCache("local-cache").put("token_"+id, tokenDb);// if not found token is updated in the cache

                   return true;
               }
               System.out.println("token is Not matched ");
           }
           throw new Exception("token is not matched");
       }
       catch (Exception e){
           //e.printStackTrace();
           throw new Exception("Error while parsing token or expired");
       }

    }
*/
    private String doGenerateToken(String subject)throws Exception {
        try{
            //SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS256;
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            long ttlMillis = 60*60*1000;//in what time it will expire
             long expMillis = nowMillis+ttlMillis;//5secs token
            Date exp=new Date(expMillis );

            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(env.getProperty("SECRET_KEY"));
            //read the value from the application property file.

            JwtBuilder builder = Jwts.builder()
                    .setIssuedAt(now)
                    .setSubject(subject)
                    .signWith(SignatureAlgorithm.HS256, apiKeySecretBytes)
                    .setExpiration(exp);

            return builder.compact();//helps to create JWT token
        }catch (Exception e){
           e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
 /* public boolean tokenValidation(String id,String token)throws  Exception{
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(env.getProperty("SECRET_KEY"))//read the value from the application prop file.
                    .parseClaimsJws(token)
                    .getBody();
            Integer id_int  = Integer.parseInt(id);//convert str to int;
            if(cacheManager.getCache("local-cache").get("token_"+id) != null){
                String tokenCache = cacheManager.getCache("local-cache").get("token_"+id).toString();
                //get the token from cache
                if(tokenCache != null){
                    if(token.equals(tokenCache)){
                        System.out.println("token is validated and matched from the cache..");
                        return true;
                    }
                   // System.out.println("token is not matched.");
                }
            }else{
                String tokenDb = repo2.getTokenByUserId(id_int);
                System.out.println("token is validated from database");
                if(tokenDb.equals(token)){
                    System.out.println("token is updated in the cache");
                    cacheManager.getCache("local-cache").put("token_"+id,tokenDb);//store the token in cache.
                    return true;
                }
                System.out.println("token is not matched.");
                //if token is not exist in the cache..need to test from db
                //customerRepo.tokenValidation(cust_no_int,token).orElseThrow(()->new Exception("Token is not validated"));
            }
            throw new Exception("token is not matched");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error while parsing token or token expired");
            // throw new Exception("Error :: token");
        }
    }

*/
public boolean tokenValidation(String id,String token)throws  Exception {
      try {
          Claims claims = Jwts.parser()
                  .setSigningKey(env.getProperty("SECRET_KEY"))//read the value from the application prop file.
                  .parseClaimsJws(token)
                  .getBody();
          Integer id_int = Integer.parseInt(id);//convert str to int;
          repo2.tokenvalidation(id_int, token).orElseThrow(() -> new Exception("token is not validated"));
          return true;
      } catch (java.text.ParseException e) {
          throw e;
      }
  }
}