package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.model.Course;
import com.example.demo.model.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

	Long id;
	
   @NotNull
   @Size(min=5, message="Name must be at least 5 characters long")
   String name;
   
   @NotNull
   @Size(min=5, message="Email must be at least 5 characters long")
   String email;
   
   String gender;
   
   Long courseId;
   
   String course;
   
   public UserDto(Long id, String name, String email , String gender)
   {
	   this.id = id;
	   this.name = name;
	   this.email = email;
	   this.gender = gender;
   }
   public UserDto()
   {
	   
   }
   public UserDto(User entity)
   {
	   this.id = entity.getId();
	   this.name= entity.getName();
	   this.email = entity.getEmail();
	   this.gender = entity.getGender();
	   this.course = entity.getCourse().getName();
   }
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getEntity()
	{
		User user = new User();
		System.out.println("User id "+this.id);
		user.setId(this.id);
		user.setName(this.name);
		user.setEmail(this.email);
		user.setGender(this.gender);
		
		Course course = new Course();
		course.setId(this.getCourseId());
		
		user.setCourse(course);
		
		return user;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
}
