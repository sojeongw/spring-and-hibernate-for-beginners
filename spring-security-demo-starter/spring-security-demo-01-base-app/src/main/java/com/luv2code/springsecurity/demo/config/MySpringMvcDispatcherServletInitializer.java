package com.luv2code.springsecurity.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// xml에서 설정하던 부분을 java code로 변경
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// no root config classes for our project. only servlet config classes
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// return servlet config class that we created earlier
		return new Class[] { DemoAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// servlet mapping을 위해서 slash를 붙여준다.
		return new String[] { "/" };
	}

}
