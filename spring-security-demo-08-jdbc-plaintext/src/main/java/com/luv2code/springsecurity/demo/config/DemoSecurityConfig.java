 package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	// configure users(in memory, database...)
		
		// use jdbc authentication...oh yeah
		// tell spring security to use JDBC authentication with our data source. no longer hard-coding users.
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	// configure security of web paths in application, login, logout etc
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")	
			.antMatchers("/leaders/**").hasRole("MANAGER")	// role에 따라 접근할 수 있는 페이지에 제한을 둔다.
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")	// show our custom form at the request mapping
				.loginProcessingUrl("/authenticateTheUser")	// login form should POST data to this URL for processing(check user id and password)
				.permitAll()	// allow everyone to see login page. no need to be logged in.
			.and()
			.logout()
				.permitAll()	// default로 logout 기능 support
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");	// 에러 발생 시 이동할 페이지 설정
	}
}
