package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")	// parent mapping -> 아래에 있는 모든 link가 영향을 받음.
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";	// jsp page
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new a controller method to read form data
	// and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {	
		// model is used to pass data around between controllers and view
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "YO! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);	// (name -> the same name that the form will use, value)
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {	// studentName으로 받아서 theName에 assign
		
		/*
		Now, Spring automatically does this work behind the scenes! Magic :-)
		
		String theName = request.getParameter("studentName");
		*/
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey my friend, " + theName;
		
		// add message to the model
		model.addAttribute("message", result);	// (name, value)
		
		return "helloworld";
	}

}
