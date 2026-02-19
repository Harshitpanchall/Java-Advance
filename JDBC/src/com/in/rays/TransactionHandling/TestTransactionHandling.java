package com.in.rays.TransactionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into person1 values(34, 'sumita','indore',343434343)");
			i = stmt.executeUpdate("insert into person1 values(29,'vijay','bhopal',543434)");
			
			System.out.println(i);
			conn.commit();
			
			conn.close();
			stmt.close();
			
			
		}catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
			
		}
	}

}
