package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		///Ye SQL query run karne ke liye object banata hai.
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into Person1 values(1,'uday','odisha',98343435),(2,'rohan','rewa',56767876)");
		System.out.println(i + "insert table");
		
		conn.close();
		stmt.close();
		
		
		
		
	}

}
