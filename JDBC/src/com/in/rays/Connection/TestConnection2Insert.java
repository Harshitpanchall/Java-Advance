package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestConnection2Insert {
	
	public static void main(String[] args) throws Exception  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into Employee values(4,'harshit','tiwarti','indore')");
		
		System.out.println(i + "row is records");
		
		conn.close();
		stmt.close();
		
		
	}

}
