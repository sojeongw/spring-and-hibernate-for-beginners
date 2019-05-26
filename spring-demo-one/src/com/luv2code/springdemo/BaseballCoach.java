package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	// dependency를 넘겨주면
	public BaseballCoach(FortuneService theFortuneService) {
		// private 변수에 assign한다.
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune. dependency = helper!
		return fortuneService.getFortune();
	}
}
