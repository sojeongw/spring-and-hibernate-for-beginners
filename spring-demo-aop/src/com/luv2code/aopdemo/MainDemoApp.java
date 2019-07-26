package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		// behind the scenes, AOP advice is listening/monitoring the network, spying on all communications.
		theAccountDAO.addAccount();
		
		// do it again!
		System.out.println("\nlet's call it again!\n");
		
		// call the business nethod again
		theAccountDAO.addAccount();
		
		// close the context
		context.close();
	}

}
