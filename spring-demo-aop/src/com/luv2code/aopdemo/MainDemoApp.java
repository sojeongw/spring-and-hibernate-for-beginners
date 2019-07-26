package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method, will match on the @Before advice
		// behind the scenes, AOP advice is listening/monitoring the network, spying on all communications.
		theAccountDAO.addAccount();
		
		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.addSillyMember();
		
		
		// close the context
		context.close();
	}

}
