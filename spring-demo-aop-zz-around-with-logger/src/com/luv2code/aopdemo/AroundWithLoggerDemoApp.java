package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	// 스프링에서 자체적으로 log를 찍는 outstream이 따로 있어서 sysout하는 outstream과 순서 싱크가 안맞는다.
	// 스프링에서 쓰는 Logger class를 불러와서 해결한다. aspect에도 똑같이 적용해준다.
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		// 스트링값은 소문자로 시작하는 것에 주의
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		
		// close the context
		context.close();
	}

}
