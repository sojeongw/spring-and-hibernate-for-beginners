package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// validatedBy = [the helper class that contains business rules or validation logic]
@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})	// apply the annotation to a method or field
@Retention(RetentionPolicy.RUNTIME)	// process this annotation at runtime
public @interface CourseCode {

	// define default CourseCode
	public String value() default "LUV";
	
	// define default error message
	public String message() default "must start with LUV";
	
	// define default groups: can group related constraints
	public Class<?>[] groups() default {};
	
	// define default payloads(additional information about the error)
	public Class<? extends Payload>[] payload() default {};
	
}
