package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	// inject data from the props file
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	
	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}


	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
