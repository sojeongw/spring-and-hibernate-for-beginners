package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		// jdbc:mysql://localhost:3306/스키마 이름
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?userSSL=false";	// get rid of MySql SSL warnings
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
