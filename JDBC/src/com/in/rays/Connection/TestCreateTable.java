package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTable {
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table st_user(id int primary key, firstname varchar(45), lastname varchar(45), login varchar(45), password varchar(45), dob date)");
		
		System.out.println(i + "table create");
		
		conn.close();
		stmt.close();
	}

}
