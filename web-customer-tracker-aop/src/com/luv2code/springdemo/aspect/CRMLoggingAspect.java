package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect		// AOP proxy를 설정할 수 있도록 추가
@Component	// Component scanning으로 찾을 수 있도록 추가 
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	// 첫번째 *: match on any class in the package
	// 두번째 *: any method in the class
	// (..): any number of arguments
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")	
	private void forControllerPackage() {
		
	}
	
	// do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")	
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")	
	private void forDaoPackage() {
		
	}
	
	// combine all these pointcut declarations together
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) { // JoinPoint gives us metadata about the method call
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object tempArg: args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
		
	}
	
	// add @Afterreturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void AfterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("=====>> result: " + theResult);	// Controller returns the name of view page
	}
}
