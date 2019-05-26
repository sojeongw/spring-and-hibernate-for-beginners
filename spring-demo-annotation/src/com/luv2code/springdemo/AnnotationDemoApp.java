package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file: bean 등록 
		// 이걸 불러옴으로써 TennisCoach에 있는 모든 생성자와 메소드가 실행된다.
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		// 왜 바로 impl 받은 클래스 안쓰고 인터페이스로 선언하지...? 인터페이스가 원래 이렇게 사용되는건지 찾아봐야할듯.
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		// autowired로 injection이 됐기 때문에 fortune에 있는 메소드를 coach에서 잘 불러온다.
		// autowired를 없애면 NullPointerException이 뜬다.
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();

	}

}