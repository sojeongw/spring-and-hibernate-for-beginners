package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n========>>> The exception is: " + theExc);
	}
	
	// 메서드가 성공하든 실패하든 결과에 상관없이 무조건 실행한다.
	// After가 먼저 실행된 뒤에 최종 결과인 AfterThrowing과 AfterReturning이 실행된다.
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @Aftr(finally) on method: " + method);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",	// 소괄호 안에 넣는 것 잊지 말기.
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {	// returning과 parameter name이 일치해야 한다.
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n========>>> result is: " + result);
		
		// let's post-process the data...let's modify it :)
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		// main과 아래의 print에는 수정된 최종 내용이 반영된다.
		System.out.println("\n========>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for(Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update thename on the account
			tempAccount.setName(theUpperName);
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {	// JoinPoint has metadata about method call
		System.out.println("\n=========>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);	// Method: void com.luv2code.aopdemo.dao.AccountDAO.addAccount(Account,boolean)
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				// tempArg가 Account 타입일 경우 downcast 해서 실제 data를 get한다.
				// 기본적으로 Account 객체의 hashcode를 보여주기 때문이다.
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
}
