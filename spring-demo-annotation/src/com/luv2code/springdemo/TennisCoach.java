package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// the bean id: Spring will automatically register this bean.
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	// field injection
	@Autowired
	// default는 항상 첫 번째 lowercase이므로 따로 지정없이 사용한다.
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// inject the properties values
	@Value("${foo.email}")
	private String email;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define my init method
	// Code will execute after constructor and after injection of dependencies
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	// defint my destroy method
	// Code will execute before bean is destroyed
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	/*
	// define a setter method
	// Autowired가 fortuneService를 implement 하는 클래스를 찾는다.
	// 메소드 이름을 바꿔도 잘 불러온다!
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}
	*/
	
	/*
	// Spring will scan for a component that implements FortuneService interface.
	// HappyFortuneService meets the requirement
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		System.out.println("property value injection: " + email);
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
