package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/new")
	public String newUser(Model model)
	{
		System.out.println("User/new Controller");
		User newUser = new User();
		model.addAttribute("user", newUser);
		
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid User user,Errors errors)
	{
		if( errors.hasErrors())
		{
			System.out.println("Have validation error ");
			return "user/new";
		}
		System.out.println("User name "+user.getName());
		System.out.println("User email "+user.getEmail());
		//model.addAttribute("user", newUser);
		
		return "user/new";
	}
}
