package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	// 순서를 정하지 않으면 랜덤으로 출력된다.
	// 이번 시간에는 만들어놨던 pointcut을 각각의 클래스로 분리해보자.
	
	// fully qualified name으로 패키지가 변경된 pointcut인 forDaoPackageNoGetterSetter를 불러온다.  
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========>>> Executing @Before advice on method");
	}
}
