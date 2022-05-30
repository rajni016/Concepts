package com.java_springboot.java_springboot.Repo;

import com.java_springboot.java_springboot.Model.regpostmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface regpostrepo extends JpaRepository<regpostmodel,Integer> {
   @Query("select c from regpostmodel c where c.email=?1 and c.password=?2")// should not mention table name directly, mention model name
   //c is used as alias(instead of star)
   Optional< regpostmodel> check(String email, String password);// Customer model is the return type
   // optional is to give the error, optional condition will help to check the data exist or not in the regpostmodel
   //  if data is present will return true
   //if data is not exist it will throw error of "user not exist(mentioned in service)"
}
