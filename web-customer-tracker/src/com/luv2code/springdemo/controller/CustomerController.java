package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// delegate calls to service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		// addAttribute(name, value) name은 jsp에서 사용할 이름을 말한다.
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";	// jsp 파일 이름 
	}
}
