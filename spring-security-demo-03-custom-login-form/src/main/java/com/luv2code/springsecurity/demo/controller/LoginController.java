package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class LoginController {
	
	@GetMapping("/showMyLoginPage")	// this is based on spring security config file
	public String showMyLoginPage() {
		
		return "plain-login";	// and then maps over to this jsp
	}
}
