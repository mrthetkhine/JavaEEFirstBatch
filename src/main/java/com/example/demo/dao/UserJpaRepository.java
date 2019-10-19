package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>{
	  
}
 