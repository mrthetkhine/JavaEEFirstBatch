package com.example.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookJpaRepository;
import com.example.demo.dto.CourseDto;
import com.example.demo.dto.ErrorMessage;
import com.example.demo.servie.CourseService;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v2/course")
public class CourseApi2 {

	@Autowired
	CourseService courseService;
	
	@GetMapping( produces = "application/json")
    public ResponseEntity<List<CourseDto>> getAllCourse() 
    {
        return ResponseEntity.ok(this.courseService.getAllCourse());
    }
	@GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Object> getCourse(@PathVariable("id") Long id) 
    {
		CourseDto dto  = null;
		try
		{
			dto = this.courseService.getCourseById(id);
			return ResponseEntity.ok(dto);
		}
		catch(Exception e)
		{
			ErrorMessage message = new ErrorMessage();
			message.setMessage("No id "+ id +" found ");
			message.setDescription("Invalid id in course");
			return ResponseEntity.badRequest().body(message);
		}
		
        
    }
	@PostMapping
	public CourseDto newCourse(@RequestBody CourseDto dto)
	{
		System.out.println("Course dto in API "+dto);
		return this.courseService.createNewCourse(dto);
	}
	@PutMapping(path="/{id}")
	public CourseDto updateCourse(@PathVariable("id") Long id,@RequestBody CourseDto courseDto)
	{
		courseDto.setId(id);
		System.out.println("Course dto in API "+courseDto);
		return this.courseService.updateCourse(courseDto);
	}
	@DeleteMapping(path="/{id}")
	public void deleteCourse(@PathVariable("id") Long id)
	{
		this.courseService.deleteCourseById(id);
	}
}
