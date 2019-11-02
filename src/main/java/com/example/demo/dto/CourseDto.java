package com.example.demo.dto;
import com.example.demo.model.*;
public class CourseDto {

	Long id;
	String name;
	String description;
	
	public CourseDto(Course entity)
	{
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
	
	
	
}
