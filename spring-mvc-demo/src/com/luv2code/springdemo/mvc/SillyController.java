package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	@RequestMapping("/showForm")	// 같은 경로를 넣으면 error
	public String displayTheForm() {
		return "silly";
	}

}
