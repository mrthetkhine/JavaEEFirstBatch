package com.example.demo.dto;
import java.io.Serializable;

import com.example.demo.model.*;
public class CourseDto implements Serializable{

	Long id;
	String name;
	String description;
	
	public CourseDto()
	{
		
	}
	
	public CourseDto(Course entity)
	{
		System.out.println("Course Dto "+entity);
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course getEntity()
	{
		Course course = new Course();
		if(this.id != null)
		{
			course.setId(id);
		}
		course.setName(this.name);
		course.setDescription(this.description);
		
		return course;
	}
	
}
