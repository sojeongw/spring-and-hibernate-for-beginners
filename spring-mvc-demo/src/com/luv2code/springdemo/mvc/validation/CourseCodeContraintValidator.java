package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
							// (HTML form data entered by the user, additional error messages)
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {	
		
		boolean result;
		
		// null check 안하면 500 error 
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}
		
		return result;
	}
	
}
