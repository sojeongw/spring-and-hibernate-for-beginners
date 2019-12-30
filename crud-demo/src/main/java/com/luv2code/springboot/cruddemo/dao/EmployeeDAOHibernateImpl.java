package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManger;

	// set up constructor injection
	// 자동으로 Spring Boot가 만들어주지만 readable한 코드를 위해 Autowired 명시
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManger) {
		entityManger = theEntityManger;
	}

	@Override
	// @Transactional // handles transaction management so we don't have to manually
	// start and commit transaction
	// now we remove @Transactional from DAO. we will add a Service to handle Transactional.
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// create a query
		// using native hibernate API (org.hibernate.query.Query)
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);

		// return the employee;
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// save employee
		// Remember if id=0 then save/insert else update
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery(
				"delete from Employee where id=:employeeId");	// :는 parameter
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
