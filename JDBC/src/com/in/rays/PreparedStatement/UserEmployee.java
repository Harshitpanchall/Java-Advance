package com.in.rays.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserEmployee {
	public int add(Employee p) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement ps = conn.prepareStatement("insert into Employee values(?,?,?,?)");
		
		ps.setInt(1,p.getId());
		ps.setString(2, p.getName());
		ps.setString(3,p.getLastName());
		ps.setString(4,p.getCity());
		
		
		int i = ps.executeUpdate();
		System.out.println(i);
		
		return p.getId();
		
		
		
		
	}

}
