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
		// save: INSERT new record
		// update: UPDATE existing record
		// saveOrUpdate: if (primaryKey or Id) empty then INSERT new customer else UPDATE exiting customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve or read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		// createQuery에 있는 id 값과 setParameter의 값이 'customerId'로 일치해야 한다.
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		// executeUpdate is just a generic purpose method. this works for update, delete and so on.
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		// only search by name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length()>0) {
			// search for firstName of lastName...case insensitive
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",
												Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// theSearchName is empty...so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

}
