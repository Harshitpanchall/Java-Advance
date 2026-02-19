package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

public int add(UserBean bean) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	
	PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
	
	ps.setInt(1,bean.getId());
	ps.setString(2,bean.getName());
	ps.setString(3,bean.getLastName());
	ps.setString(4,bean.getCity());
	
	int i = ps.executeUpdate();
	System.out.println(i + "all record is row");
	
	conn.close();
	ps.close();
	return bean.getId();
		
	}

       public void update(UserBean bean) throws ClassNotFoundException, SQLException {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
    	   PreparedStatement ps = conn.prepareStatement("update employee set name = ?, lastname = ?, city = ? where id = ?");
    	   ps.setString(1, bean.getName());
    	   ps.setString(2,bean.getLastName());
    	   ps.setString(3,bean.getCity());
    	   ps.setInt(4, bean.getId());
    	   
    	   int i = ps.executeUpdate();
    	   System.out.println(i + "all record are same and updated");
    	   
    	   conn.close();
    	   ps.close();
    	   
    	   
       }
       
       public void delete(UserBean bean) throws ClassNotFoundException, SQLException {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
    	    PreparedStatement ps = conn.prepareStatement("delete from employee where id = ?");
    	    
    	    ps.setInt(1,bean.getId());
    	    
    	    int i = ps.executeUpdate();
    	    System.out.println(i + "all 1 record is delete");
    	    
    	    conn.close();
    	    ps.close();
       }


}

