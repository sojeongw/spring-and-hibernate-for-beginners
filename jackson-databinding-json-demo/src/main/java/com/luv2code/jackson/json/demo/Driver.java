package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read JSON file and map/convert to Java POJO: data/sample-lite.json
			
			// print first name and last name
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
