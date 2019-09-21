package com.example.demo.controller;

import com.example.demo.dto.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {
	
	@GetMapping("/")
	String home(Model model){
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		return "home";
	}
	/*
	@GetMapping("/user")
	String user(Model model){
		
		User user = new User();
		user.setName("TK");
		user.setEmail("myemail@gmail.com");
		model.addAttribute("user", user);
		
		System.out.println("User Controller");
		return "user";
	}
	*/
	@GetMapping("/users")
	String userList(Model model){
		
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setName("User one");
		user.setEmail("userone@gmail.com");
		
		users.add(user);
		
		User user1 = new User();
		user1.setName("User 1");
		user1.setEmail("user2@gmail.com");
		
		users.add(user1);
		
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		return "users";
	}
}
