package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {	// JpaRepository<entity type, primary key>

	// that's it...no need to write any code!
	
	// add a method to sort by last name
	// Spring Data JPA will parse the method name. Looks for a specific format and pattern.
	// Creates appropriate query...behind the scenes.
	public List<Employee> findAllByOrderByLastNameAsc();
}
