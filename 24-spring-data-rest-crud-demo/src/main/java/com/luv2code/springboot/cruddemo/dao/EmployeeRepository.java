package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path="members")		// 기본값과 다르게 url을 설정
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {	// JpaRepository<entity type, primary key>

	// that's it...no need to write any code!
}
