package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);	// 5초 동안 sleep
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// return a fortune
		return "Expect heavy traffic this morning";
	}
	
	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		// 같은 String을 출력하고 싶을 땐 하드코딩 보다는 재사용으로.
		return getFortune();
	}
}
