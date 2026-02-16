package com.in.rays.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	
	public int add(UserBean bean)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement ps = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
		
		ps.setInt(1,bean.getId());
		ps.setString(2,bean.getFirstname());
		ps.setString(3,bean.getLastname());
		ps.setString(4,bean.getLogin());
		ps.setString(5,bean.getPassword());
		ps.setDate(6,new java.sql.Date(bean.getDob().getTime()));
		
		int i = ps.executeUpdate();
		
		System.out.println(i + "row affecting ");
		return bean.getId();
			

	}
}
