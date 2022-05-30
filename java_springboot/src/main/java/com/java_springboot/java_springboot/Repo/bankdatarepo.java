package com.java_springboot.java_springboot.Repo;

import com.java_springboot.java_springboot.Model.bankdatamodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface bankdatarepo extends JpaRepository<bankdatamodel,Integer> {
    @Query("select b from bankdatamodel b where b.id=?1")
    public void Selectcustomers(Integer id);


    @Query("select b from bankdatamodel b where b.email=?1 and b.password=?2")
    Optional<bankdatamodel>loginvalidation (String email,String password);

    @Transactional
    @Modifying
    @Query("update bankdatamodel set password=?2 where id=?1")
    void passwordupdate(Integer id, String password);

    @Transactional
    @Modifying
    @Query("update bankdatamodel set token=?1 where id=?2")
    void tokenupdate(String token,Integer id);

    @Query("select c from bankdatamodel c where c.token=?1 and c.id=?2")
    Optional<bankdatamodel> tokenvalidation (String token,Integer id_int);

}
