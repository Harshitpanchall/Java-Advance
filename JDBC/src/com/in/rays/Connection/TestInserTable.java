package com.in.rays.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInserTable {
	
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		
		
		int i = stmt.executeUpdate("insert into st_user values(4 , 'smmit' , 'pandey' , 'sumit@gmail.com' , 'sumit124' , '1999-05-25'),(3 , 'harsh' , 'tiwari' , 'harsh@gmail.com' , 'harsh123' , '2001-05-14')");
		
		conn.close();
		stmt.close();
		
	}

}
