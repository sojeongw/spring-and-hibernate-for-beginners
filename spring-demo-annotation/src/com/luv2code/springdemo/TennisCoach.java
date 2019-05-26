package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

// the bean id: Spring will automatically register this bean.
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

}
