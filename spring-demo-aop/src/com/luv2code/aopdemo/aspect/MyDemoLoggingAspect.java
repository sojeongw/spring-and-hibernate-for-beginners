package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	/* pointcut expression - Run this code BEFORE target object method: "public void addAccount()"
	 * DAO가 달라도 addAccount를 가지고 있으면 모두 적용된다.
	@Before("execution(public void addAccount())") 
	*/
	
	/* 특정 클래스만 적용하기 
	 * @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	 */
	
	/* wild card
	@Before("execution(public void add*())")
	*/
	
	/* Modifier is optional, so you can delete it.
	 * this only matches a method that returns void
	@Before("execution(void add*())")
	*/
	
	/* matches any return type
	@Before("execution(* add*())")
	*/
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=========>>> Executing @Before advice on method");
	}
	
}
