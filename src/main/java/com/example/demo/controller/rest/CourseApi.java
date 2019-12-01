package com.example.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.servie.CourseService;
import java.util.List;

@RestController
@RequestMapping(path = "/api/course")
public class CourseApi {

	@Autowired
	CourseService courseService;
	
	@GetMapping(path="/", produces = "application/json")
    public List<CourseDto> getAllCourse() 
    {
        return this.courseService.getAllCourse();
    }
     
}
