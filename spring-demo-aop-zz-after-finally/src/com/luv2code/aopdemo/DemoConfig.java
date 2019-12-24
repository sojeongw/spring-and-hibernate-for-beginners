package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration	// Spring Pure Java Configuration
@EnableAspectJAutoProxy	// Spring AOP Proxy Support
@ComponentScan("com.luv2code.aopdemo")	// Component scan for components and aspects. Recurse packages. sub package까지 포함.
public class DemoConfig {

}
