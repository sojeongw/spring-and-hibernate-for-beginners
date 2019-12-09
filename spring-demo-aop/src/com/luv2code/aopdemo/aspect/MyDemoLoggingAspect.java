package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect	// aspect임을 알려줌
@Component	// component scan으로 Aspect을 찾아냄
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advises for logging
	
	// let's start with an @Before advice
	
	/* fully qualified class name
	 * 같은 method에 다른 parameter가 더 추가되면 동작하지 않는다.
	@Before("execution(* add*(com.luv2code.aopdemo.Account))")	// pointcut expression
	*/
	
	/* must use fully qualified class name but let't get lazy
	 * this gets exception: warning no match for this type name
	@Before("execution(* add*(Account))")
	*/
	
	/* match on any number of arguments 
	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	*/
	
	/* match on ANY parameters
	 * add라는 이름이 들어가는 method면 다 match
	@Before("execution(* add*(..))")
	*/
	
	// any return type, class, method, number of parameters in the package(aopdemo.dao)
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=========>>> Executing @Before advice on method");
	}
	
}
