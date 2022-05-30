package com.java_springboot.java_springboot.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="regpost")
public class regpostmodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// this is to say that this column is incremented and no need to insert data
    Integer id;
    String name,email,password;
    String token;

    @Column(updatable = false, insertable = false)// for this column we donot need to update or insert the data
    LocalDate date;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public regpostcitymodel getCitymodel() {//you need to get getter and setter
        return citymodel;
    }

    public void setCitymodel(regpostcitymodel citymodel) {
        this.citymodel = citymodel;
    }

    @OneToOne
    @JoinColumn(name="id",referencedColumnName = "cityid")//name= id is name of the column from regpost and cityid is from regpostcity
    regpostcitymodel citymodel;// referenced column is not necessary when any of the table contains primary key
    //@Joincolumn(name="cityid") is enough



    @OneToMany
    @JoinColumn(name="id",referencedColumnName = "id")// @Joincolumn(name="id") is enough
    List<regpostmobilemodel> mobilemodel;

    public List<regpostmobilemodel> getMobilemodel() {
        return mobilemodel;
    }

    public void setMobilemodel(List<regpostmobilemodel> mobilemodel) {
        this.mobilemodel = mobilemodel;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
