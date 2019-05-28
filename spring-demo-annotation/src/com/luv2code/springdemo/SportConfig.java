package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// follows the appropriate rules of directions here.
@Configuration
/* 
works exactly like XML component scanning. scans this package, 
finds all the classes that have the @Component annotation and then registers them in the spring container.
bean을 manually하게 등록했을때는(@bean) ComponentScan이 필요없다.
*/
// @ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {	// this method name will be the 'bean id'
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() { // this method name will be the 'bean id'
		
		// inject bean dependencies
		// 위에서 정의한 메소드를 그대로 intercept 해서 주입한다.
		return new SwimCoach(sadFortuneService());
	}

}
