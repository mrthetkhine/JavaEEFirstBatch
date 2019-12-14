package com.example.demo.dto.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CourseNameValidator.class})
@Documented
public @interface ValidCourseName {

	String message();
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
