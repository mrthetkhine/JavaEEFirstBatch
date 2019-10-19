package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;

@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private  UserRepository userRepository;
	
	@GetMapping("/list")
	String userList(Model model){
		
		Iterable<UserDto> users = this.userRepository.findAll();
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		return "user/users";
	}
	
	@GetMapping("/new")
	public String newUser(Model model)
	{
		//System.out.println("User/new Controller");
		UserDto newUser = new UserDto();
		model.addAttribute("user", newUser);
		
		System.out.println("User/new Get");
		
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid UserDto user,Errors errors)
	{
		System.out.println("User/new post");
		if( errors.hasErrors())
		{
			System.out.println("Have validation error ");
			return "user/new";
		}
		else
		{
			if( user.getId() != null)
			{
				userRepository.update(user);
			}
			else
			{
				userRepository.save(user);
			}
			
			return "redirect:/user/list";
		}
		
	}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id,Model model)
	{
		System.out.println("User/edit");
		UserDto newUser = this.userRepository.findOne(id);
		model.addAttribute("user", newUser);
		
		return "user/new";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		this.userRepository.deleteUser(id);
		return "redirect:/user/list";
		
	}
	
}
