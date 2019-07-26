package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

// Spring will find it using components scan
@Component
public class AccountDAO {	// the target object
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
