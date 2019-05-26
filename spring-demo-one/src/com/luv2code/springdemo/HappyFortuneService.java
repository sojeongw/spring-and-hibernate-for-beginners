package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		
		String[] fortune = new String[3];
		
		fortune[0] = "happy day";
		fortune[1] = "sad day";
		fortune[2] = "gloomy day";
		
		Random rand = new Random();
		int n = rand.nextInt(3);
		
		return fortune[n];
	}

}
