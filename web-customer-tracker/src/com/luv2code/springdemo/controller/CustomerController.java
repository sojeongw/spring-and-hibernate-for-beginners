package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer DAO.
	// Spring will scan for a component that implements CustomerDAO interface.
	// it's able to find CustomerDAOImpl with @Repository and make it available and inject it.
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add the customers to the model
		// addAttribute(name, value) name은 jsp에서 사용할 이름을 말한다.
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";	// jsp 파일 이름 
	}
}
