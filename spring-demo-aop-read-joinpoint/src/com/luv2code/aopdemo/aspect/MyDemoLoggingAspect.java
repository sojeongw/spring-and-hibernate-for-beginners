package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
	// 순서를 정하지 않으면 랜덤으로 출력된다.
	// 이번 시간에는 만들어놨던 pointcut을 각각의 클래스로 분리해보자.
	
	// fully qualified name으로 패키지가 변경된 pointcut인 forDaoPackageNoGetterSetter를 불러온다.  
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
