package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LuvAopExpressions {
	// 모든 pointcut에 대한 access를 관리하는 클래스
	// 이전과 다르게 클래스들이 분리되었으니 접근할 수 있도록 private을 public으로 바꿔준다.
	
	// create pointcut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
	
	// create point: include package, exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}
}
