package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Customer;

// We need for Spring to be able to component scan, find this repository
// and also handle the exception translation for us.
// So remember @Repository is always applied to DAO implementations.
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	// xml에 정의된 sesssionFactory를 주입시킨다.
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	// remove @Transactional because we've moved this functionality up to the service layer.
	// so the service will start a transaction, and then it'll make the appropriate calls here to DAOs.
	// and then the service will cleanup the transaction.
	// so, the service is kind of managing the transaction.
 	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query, sort by last name
		// package 정확히 선택해야 함.
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(theCustomer);
		
	}

}
