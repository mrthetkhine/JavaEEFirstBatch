package com.example.demo.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

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

import com.example.demo.dao.CourseJpaRepository;
import com.example.demo.dao.UserJpaRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserSearch;
import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.servie.UserService;
import com.example.demo.servie.CourseService;
import com.example.demo.dto.CourseDto;
@Controller
@RequestMapping("/user")
public class UserController {


	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired 
	CourseService courseService;
	
	@GetMapping("/list")
	String userList(Model model){
		
		List<UserDto> users = this.userService.getAllUser();
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		
		//this.userService.updateName("TK", 1L);
		
		return "user/users";
	}
	
	@GetMapping("/new")
	public String newUser(Model model)
	{
		//System.out.println("User/new Controller");
		UserDto newUser = new UserDto();
		model.addAttribute("user", newUser);
		
		List<CourseDto> courses = this.courseService.getAllCourse();
		model.addAttribute("courses", courses);
		System.out.println("User/new Get");
		
		return "user/new";
	}
	@PostMapping("/new")
	public String createUser(@Valid UserDto user,Errors errors)
	{
		System.out.println("User/new post");
		System.out.println("Course "+user.getCourseId());
		if( errors.hasErrors())
		{
			System.out.println("Have validation error ");
			return "user/new";
		}
		else
		{
			this.userService.saveOrUpdate(user);	
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
		this.userService.deleteById(id);
		return "redirect:/user/list";
		
	}
	@GetMapping("/searchByName")
	public String searchByName(Model model)
	{
		System.out.println("Get searchByName");
		UserSearch search = new UserSearch();
		model.addAttribute("search", search);
		
		List<UserDto> users = new ArrayList<UserDto>();
		model.addAttribute("users", users);
		
		return "user/searchByName";
		
	}
	@PostMapping("/searchByName")
	public String searchByNamePost(UserSearch search,Model model)
	{
		System.out.println("Post searchByName");
		System.out.println("Search name "+search.getName());
		
		UserSearch param = new UserSearch();
		model.addAttribute("search", param);
		
		List<UserDto> users = this.userService.searchUserByName(search.getName());
		model.addAttribute("users", users);
		
		
		return "user/searchByName";
		
	}
	@GetMapping("/searchByNameOrEmail")
	public String searchByNameOrEmail(Model model)
	{
		System.out.println("Get searchByNameOrEmail");
		UserSearch search = new UserSearch();
		model.addAttribute("search", search);
		
		List<UserDto> users = new ArrayList<UserDto>();
		model.addAttribute("users", users);
		
		return "user/searchByNameOrEmail";
		
	}
	@PostMapping("/searchByNameOrEmail")
	public String searchByNameOrEmailPost(UserSearch search,Model model)
	{
		System.out.println("Post searchByName");
		System.out.println("Search name "+search.getName());
		System.out.println("Search email "+search.getEmail());
		
		UserSearch param = new UserSearch();
		model.addAttribute("search", param);
		
		List<UserDto> users = this.userService.searchUserByNameOrEmail(search);
		model.addAttribute("users", users);
		
		
		return "user/searchByNameOrEmail";
		
	}
}
