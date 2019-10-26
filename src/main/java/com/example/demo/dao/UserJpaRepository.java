package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserNameAndEmail;
import com.example.demo.model.User;;

@Repository

public interface UserJpaRepository extends JpaRepository<User, Long>{	
	
	@Query("FROM User WHERE name LIKE CONCAT('%',:name,'%') ")
	List<User> findByName(@Param("name")String name);
	
	@Query(value="SELECT * FROM user WHERE name LIKE CONCAT('%',:name,'%') ",nativeQuery=true)
	List<User> findByNameWithNativeQuery(@Param("name")String name);
	
	@Query(value="SELECT name, email FROM user",nativeQuery=true)
	List<UserNameAndEmail> getAllUserNameAndEmail();
	
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.id = ?2")
	int updateName(String name, Long id);
}
 