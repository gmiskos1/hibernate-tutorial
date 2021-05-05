package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "gmiskos";
		String password = "gmiskos";
		
		try {
			System.out.println("Connecting to database..."+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection successfull!!!");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
