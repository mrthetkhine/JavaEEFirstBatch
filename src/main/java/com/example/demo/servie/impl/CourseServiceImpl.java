package com.example.demo.servie.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseJpaRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;
import com.example.demo.servie.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseJpaRepository courseRepository;
	
	
	@Override
	public List<CourseDto> getAllCourse() {
		
		System.out.println("get all course");
		List<Course> courses = this.courseRepository.findAll();
		
		List<CourseDto> dtos = entityToDtoList(courses);
		return dtos;
	}


	private List<CourseDto> entityToDtoList(List<Course> courses) {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		for(Course course : courses)
		{
			CourseDto dto = new CourseDto(course);
			dtos.add(dto);
		}
		return dtos;
	}


	@Override
	public CourseDto createNewCourse(CourseDto dto) {
		Course course = dto.getEntity();
		Course newCourse = this.courseRepository.save(course);
		return new CourseDto(course);
	}

}
