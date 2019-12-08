package com.example.demo.servie;
import java.util.List;

import com.example.demo.dto.CourseDto;

public interface CourseService {
	List<CourseDto> getAllCourse();
	CourseDto createNewCourse(CourseDto course);
	CourseDto getCourseById(Long id);
	CourseDto updateCourse(CourseDto courseDto);
	void deleteCourseById(Long id);
}
