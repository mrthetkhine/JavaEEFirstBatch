package com.example.demo.servie.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserNameAndEmail;
import com.example.demo.dto.UserSearch;
import com.example.demo.model.User;
import com.example.demo.servie.UserService;
import com.example.demo.servie.specification.UserSpecification;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users = userJpaRepository.findAll(Sort.by("name").descending());
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		for(User user : users)
		{
			UserDto dto = new UserDto(user);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public void saveOrUpdate(UserDto user) {
		User userEntity = user.getEntity();
		this.userJpaRepository.save(userEntity);
		
	}

	@Override
	public void deleteById(Long id) {
		this.userJpaRepository.deleteById(id);
		
	}

	@Override
	public List<UserDto> searchUserByName(String name) {
		
		List<User> users  = this.userJpaRepository.findByNameWithNativeQuery(name);
		
		ArrayList<UserDto> dtos = entityListToDtos(users);
		
		List<UserNameAndEmail> userNameEmails = this.userJpaRepository.getAllUserNameAndEmail();
		for(UserNameAndEmail user : userNameEmails)
		{
			System.out.println("Class "+user.getClass());
			System.out.println("Name "+ user.getName() + " Email "+user.getEmail());
		}
		return dtos;
	}

	@Override
	public int updateName(String name, Long id) {
		
		return this.userJpaRepository.updateName(name, id);
	}

	@Override
	public List<UserDto> searchUserByNameOrEmail(UserSearch search) {
	
		List<User> users  =  this.userJpaRepository.findAll(UserSpecification.getUserByNameOrEmail(search));
		ArrayList<UserDto> dtos = entityListToDtos(users);
		return dtos;
	}

	private ArrayList<UserDto> entityListToDtos(List<User> users) {
		ArrayList<UserDto> dtos  = new ArrayList<UserDto>();
		for(User user : users)
		{
			System.out.println("Class "+user.getClass());
			UserDto dto = new UserDto(user);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UserDto getById(Long id) {
		User user = this.userJpaRepository.getOne(id);
		//System.out.println("Course "+user.getCourse());
		UserDto dto = new UserDto(user);
		return dto;
	}

}
