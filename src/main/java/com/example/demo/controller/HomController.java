package com.example.demo.controller;

import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dao.StudentJpaRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Book;
import com.example.demo.model.BookDetail;
import com.example.demo.model.Course;
import com.example.demo.model.StdCourse;
import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {
	
	@Autowired
	StudentJpaRepository studentRepository;
	
	@Autowired
	BookJpaRepository bookRepository;
	
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
	@GetMapping("/")
	String home(Model model){
		
		model.addAttribute("message", "Hello World");
		
		System.out.println("Home Controller");
		//testManyToMany();
		//this.queryStudentOne();
		this.saveOneToOne();
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
}
