package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class testConncetion {
	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String password = rb.getString("password");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate(
				"create table employee(id int primary key, name varchar(45), lastname varchar(45), city varchar(45), login varchar(45), password varchar(45))");
		System.out.println(i + "create in record");
		
		
		
		
		conn.close();
		stmt.close();
		
		
		
		
	}
	

}
