package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

//    @Query("select u from USER u where u.USERNAME = 1")
//    @Transactional(readOnly = true)
//    List<User> findByUSERNAME(String USERNAME);
}

