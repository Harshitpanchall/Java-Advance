package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionUpdate {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update person1 set name = 'root', city = 'bhola', number = 987987987 where id = 2");
		System.out.println(i + "saved the data");

		conn.close();
		stmt.close();
	}

}
