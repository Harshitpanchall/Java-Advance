package com.in.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++) {
			
			testsearch();
			System.out.println("Connection" + i);
		}
	}

	private static void testsearch() {
		Connection conn = null;
		try {
			conn = JdbcDataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from st_user where id = 1");
			
			while(rs.next()) {
				System.out.println("id" + rs.getInt(1));
				System.out.println("fastname:" + rs.getString(2));
			}
			}catch(Exception e) {
				e.getMessage();
			}
			
		
	}
}
