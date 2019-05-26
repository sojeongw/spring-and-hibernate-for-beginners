package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		// let's come back to this
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		// theCoach 객체에 literal value를 inject 했음을 확인
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// practice activity
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
