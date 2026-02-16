package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		System.out.println("mysql is connected and ducessfully updated");
		
		Statement stmt = conn.createStatement();
		
		int i= stmt.executeUpdate("create table Person1(id int primary key, name varchar(45), city varchar(45), number int)");
		System.out.println(i + "table is create");
		conn.close();
		stmt.close();
		
	}

}
