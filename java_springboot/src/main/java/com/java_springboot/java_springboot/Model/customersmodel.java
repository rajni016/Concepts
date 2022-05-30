package com.java_springboot.java_springboot.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//model is used to connect to the database.Each model class will have one pojo class with variables same as table column names
//We need to add dependencies, for jpa and mysql connections.
@Entity
@Table(name="customers")// mentioned the exact table to connect to the database
public class customersmodel {
    @Id     //It should be mentioned above the primary key
    Integer cust_num;
    String cust_name,mobile,city;

    public Integer getCust_num() {
        return cust_num;
    }

    public void setCust_num(Integer cust_num) {
        this.cust_num = cust_num;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}


