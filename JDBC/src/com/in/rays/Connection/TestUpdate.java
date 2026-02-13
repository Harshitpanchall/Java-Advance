package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws ClassNotFoundException, Exception  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("update st_user set firstname = 'utkarsh' , lastname = 'tiwari' , login = 'utkarsh@gmail.com' , password = 'utlarsk123' where id = 2");
		
		conn.close();
		stmt.close();
		
	}

}
