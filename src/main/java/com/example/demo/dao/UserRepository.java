package com.example.demo.dao;

import com.example.demo.dto.UserDto;

public interface UserRepository {
	  Iterable<UserDto> findAll();
	  UserDto findOne(Long id);
	  UserDto save(UserDto user);
	  UserDto update(UserDto user);
	  void deleteUser(Long id);
}
