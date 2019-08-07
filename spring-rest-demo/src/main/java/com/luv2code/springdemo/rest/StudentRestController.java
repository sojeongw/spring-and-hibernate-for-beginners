package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data...only once!
	// this is much better because we can only load students data once. 
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}
	
	// define endpoint for "/students/{studentId}" - return students at index
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {	// by default, variables should match the method parameter
		
		
		// just index into the list...keep it simple for now
		return theStudents.get(studentId);	// use studentId for the index
	}
}
