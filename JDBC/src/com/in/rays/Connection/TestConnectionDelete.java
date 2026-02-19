package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionDelete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from person1 where id = 1");
		System.out.println(i + "id is deletedd");
		
		conn.close();
		stmt.close();
		
		
	}

}
