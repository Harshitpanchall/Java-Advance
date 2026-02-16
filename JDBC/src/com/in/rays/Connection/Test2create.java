package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test2create {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update employee set name = 'rohit' , lastname = 'shrama' , city = 'rewa' where id = 1");
		
		System.out.println(i + "all record saved");
		
		conn.close();
		stmt.close();
	}

}
