package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonModel {
	
	public int add(PersonBean bean) throws ClassNotFoundException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement ps = conn.prepareStatement(
				"insert into person values(?,?,?,?,?)");
		ps.setInt(1,bean.getId());
		ps.setString(2,bean.getName());
		ps.setString(3,bean.getLastname());
		ps.setString(4,bean.getCity());
		ps.setInt(5,bean.getNumber());
		
		int i = ps.executeUpdate();
		System.out.println(i + " record insert");
		
		conn.close();
		ps.close();
		
		return bean.getId();
		
		
	}
	
	public void update(PersonBean bean) throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement ps = conn.prepareStatement(
				"update person name = ?, lastname = ?, city = ?, number = ? where id = ?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getLastname());
		ps.setString(3,bean.getCity());
		ps.setInt(4,bean.getNumber());
		ps.setInt(5,bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println(i + " record update");
		
		conn.close();
		ps.close();
	}

}
