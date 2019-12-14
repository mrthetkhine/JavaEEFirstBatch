package com.example.demo.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.dto.CourseDto;

public class CourseNameValidator implements ConstraintValidator<ValidCourseName,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.println("Is valid "+value);
		return Character.isUpperCase( value.charAt(0));
	}

}
