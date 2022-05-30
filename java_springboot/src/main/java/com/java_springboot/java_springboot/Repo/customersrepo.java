package com.java_springboot.java_springboot.Repo;

import com.java_springboot.java_springboot.Model.customersmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// generic class like arraylist, Data type (Integer) is datatype of primary key

public interface customersrepo extends JpaRepository<customersmodel,Integer> {

}

