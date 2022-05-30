package com.java_springboot.java_springboot.Repo;

import com.java_springboot.java_springboot.Model.regpostmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface regselectrepo extends JpaRepository<regpostmodel, Integer> {
}
