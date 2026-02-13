package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		
		/// load drive
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		/// address bata ha ki database bana ha or connection karta hai databases se drivermanager connection karta hai database ko
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		System.out.println("java is connected in mysql sucessfully");
	
		/// create statement 
		
		Statement stmt = conn.createStatement();
		
		// execute Query get result
		ResultSet rs = stmt.executeQuery("select * from student");
		
		while(rs.next()) {
			System.out.print("id : " + rs.getInt(1));
			System.out.print("name : " + rs.getString(2));
			System.out.println("phone :" + rs.getInt(3));
			
		}
		conn.close();
		stmt.close();
		
		
		
		/// 
	}

}
