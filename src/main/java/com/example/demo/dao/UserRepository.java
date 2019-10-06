package com.example.demo.dao;

import com.example.demo.dto.User;

public interface UserRepository {
	  Iterable<User> findAll();
	  User findOne(Long id);
	  User save(User user);
	  User update(User user);
}
