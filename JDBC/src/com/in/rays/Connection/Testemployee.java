package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Testemployee {
	
	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app");
		
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String password = rb.getString("password");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user, password);
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into employee values(2, 'vijay','tiwari','bhopal','vijaytiwari@mail.com','vijay123')");
		
		System.out.println(i + "insert record");
		
		conn.close();
		stmt.close();
	}

}
