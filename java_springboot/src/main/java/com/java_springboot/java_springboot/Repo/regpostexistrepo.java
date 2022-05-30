package com.java_springboot.java_springboot.Repo;

import com.java_springboot.java_springboot.Model.regpostmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface regpostexistrepo extends JpaRepository<regpostmodel, Integer> {
    @Query("select c from regpostmodel c where c.email=?1 and c.password=?2")
        // should not mention table name directly, mention model name
        //c is used as alias(instead of star)
    Optional< regpostmodel> check(String email, String password);// Customer model is the return type

    @Query("select r from regpostmodel r where r.email=?1")
    Optional<regpostmodel> checkemail(String email );

    @Transactional
    @Modifying
    @Query("update regpostmodel set password=?1 where id=?2")
    void passwordupdate(String password ,Integer id);// as it is updating we dont need any return type
    @Transactional
    @Modifying
    @Query("delete from regpostmodel where id=?1")
    void deleteid(Integer id);

    @Transactional
    @Modifying
    @Query("update regpostmodel set token=?1 where id=?2")
    void tokenupdate(String token,Integer id);



    @Query("select c from regpostmodel c where c.id=?1 and c.token=?2")
    Optional<regpostmodel> tokenvalidation(Integer id,String token);

    @Query("select c from regpostmodel c where c.id=?1 ")
   String getTokenByUserId(Integer id);
}
