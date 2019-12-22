package com.example.demo.controller;


import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dao.StudentJpaRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Book;
import com.example.demo.model.BookDetail;
import com.example.demo.model.Course;
import com.example.demo.model.StdCourse;
import com.example.demo.model.Student;
import com.example.demo.servie.CourseService;
import com.example.demo.servie.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomController {
	
	@Autowired
	StudentJpaRepository studentRepository;
	
	@Autowired
	BookJpaRepository bookRepository;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	
	public void testManyToMany()
	{
		Student st1 = new Student();
		st1.setName("Student1");
		
		Student st2 = new Student();
		st2.setName("Student2");
		
		StdCourse c1 = new StdCourse();
		c1.setName( "Course 1");
		
		StdCourse c2 = new StdCourse();
		c2.setName( "Course 2");
		
		HashSet<StdCourse> courses = new HashSet<StdCourse>();
		courses.add(c1);
		courses.add(c2);
		
		st1.setCourses(courses);
		
		st2.setCourses(courses);
		
		this.studentRepository.save(st1);
		this.studentRepository.save(st2);
		
	}
	public void queryStudentOne()
	{
		Student stud1 = this.studentRepository.getOne(1L);
		Set<StdCourse> courses = stud1.getCourses();
		StdCourse c3 = new StdCourse();
		c3.setName( "Course 3");
		
		//courses.add(c3);
		//this.studentRepository.save(stud1);
		
		for(StdCourse course : courses)
		{
			System.out.println("st1 course "+course.getName());
		}
		
	}
	public void saveOneToOne()
	{
		Book b1 = new Book();
	
		b1.setTitle("PHP");
		
		BookDetail b1Detail = new BookDetail();
		b1Detail.setContent("PHP is Blah Blah");
		
		b1.setBookDetail(b1Detail);
		
		this.bookRepository.save(b1);
		
	}
	@GetMapping("/book")
	String book(Model model) throws Exception{
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		
	
		return "home";
	}
	@GetMapping("/courseTest")
	String course(Model model) throws Exception{
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		List<CourseDto> courseDtos = this.courseService.getAllCourse();
		for(CourseDto dto : courseDtos)
		{
			System.out.println("Course "+dto.getName());
		}
	
		return "home";
	}
	@GetMapping("/")
	String home(Model model) throws Exception{
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		//testManyToMany();
		//this.queryStudentOne();
		//this.saveOneToOne();
		
		//throw new Exception("Exception");
		
		//this.courseService.getAllCourse();
		//this.userService.getAllUser();
		//this.userService.getById(-1L);
		
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
		
		List<UserDto> users = new ArrayList<UserDto>();
		UserDto user = new UserDto();
		user.setName("User one");
		user.setEmail("userone@gmail.com");
		
		users.add(user);
		
		UserDto user1 = new UserDto();
		user1.setName("User 1");
		user1.setEmail("user2@gmail.com");
		
		users.add(user1);
		
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		return "users";
	}
	@GetMapping("/login")
	String login(Model model){
		System.out.println("Login get");
		
		return "login";
	}
	@PostMapping("/login")
	String loginPost(Model model){
		System.out.println("Login post");

		
		return "login";
	}
	@GetMapping("/userAccountInfo")
	String page(Model model){
		
		List<UserDto> users = new ArrayList<UserDto>();
		UserDto user = new UserDto();
		user.setName("User one");
		user.setEmail("userone@gmail.com");
		
		users.add(user);
		
		UserDto user1 = new UserDto();
		user1.setName("User 1");
		user1.setEmail("user2@gmail.com");
		
		users.add(user1);
		
		model.addAttribute("users", users);
		
		System.out.println("User List Controller");
		return "users";
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex)
	{
		System.out.println("Exception handler run");
		ex.printStackTrace();
	    //Do something additional if required
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", ex.getMessage());
	    return modelAndView;
	}
}
