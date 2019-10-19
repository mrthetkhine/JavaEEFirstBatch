package com.example.demo.servie.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.servie.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users = userJpaRepository.findAll();
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		for(User user : users)
		{
			UserDto dto = new UserDto(user);
			dtos.add(dto);
			
		}
		return dtos;
	}

}
