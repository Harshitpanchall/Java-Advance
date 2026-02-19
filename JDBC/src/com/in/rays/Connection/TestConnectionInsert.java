package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionInsert {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into person1 values(3,'harshit','indore',987698768)");
		
		System.out.println(i + "all records saved");
		
		conn.close();
		stmt.close();
	}

}
