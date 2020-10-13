package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String args[]) {
		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database : " + jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL,user,pass);
			System.out.println("connection successful");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
