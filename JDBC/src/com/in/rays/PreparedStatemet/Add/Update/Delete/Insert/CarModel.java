package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class CarModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app");
	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String user = rb.getString("user");
	String password = rb.getString("password");
	
	public int add(CarBean bean) throws Exception {
		
		Class.forName(driver);
		Connection conn  = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement("insert into car values(?,?,?,?,?)");
		ps.setInt(1,bean.getCarId());
		ps.setString(2,bean.getCarCode());
		ps.setString(3,bean.getCarName());
		ps.setString(4,bean.getCarModel());
		ps.setString(5,bean.getCarStatus());
		
		int i = ps.executeUpdate();
		System.out.println(i + "record is insert");
	
		conn.close();
		ps.close();
		
		return bean.getCarId();
		
	}
	
	
public void delete(CarBean bean) throws Exception {
		
		Class.forName(driver);
		Connection conn  = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement("delete from car where id = ?");
		ps.setInt(1,bean.getCarId());
		
		int i = ps.executeUpdate();
		System.out.println(i + "record is delete");
	
		conn.close();
		ps.close();
		
	
}


public void update(CarBean bean) throws Exception {
	
	Class.forName(driver);
	Connection conn  = DriverManager.getConnection(url,user,password);
	
	PreparedStatement ps = conn.prepareStatement("update car set code = ?, name = ?, model = ?, status = ? where id = ?");
	
	ps.setString(1,bean.getCarCode());
	ps.setString(2,bean.getCarName());
	ps.setString(3,bean.getCarModel());
	ps.setString(4,bean.getCarStatus());
	ps.setInt(5,bean.getCarId());
	
	int i = ps.executeUpdate();
	System.out.println(i + "record is update");

	conn.close();
	ps.close();
	
}

public CarBean findByPK(int id) throws Exception {
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,user,password);
	
	PreparedStatement ps = conn.prepareStatement("select * from car where id = ?");
	
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	
	CarBean bean = null;
	while(rs.next()) {
		bean = new CarBean();
		bean.setCarCode(rs.getString(1));
		bean.setCarName(rs.getString(2));
		
		
	}
	conn.close();
	ps.close();
	return bean;
	
}

public List<CarBean> search(CarBean bean) throws Exception {
	
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url,user,password);
	
	PreparedStatement ps = conn.prepareStatement("select * from car");
	
	ResultSet rs = ps.executeQuery();
	List<CarBean> l = new ArrayList();

	CarBean bean1 = null;
	while(rs.next()) {
		bean1 = new CarBean();
		bean1.setCarId(rs.getInt(1));
		bean1.setCarCode(rs.getString(2));
		bean1.setCarName(rs.getString(3));
		bean1.setCarModel(rs.getString(4));
		bean1.setCarStatus(rs.getString(5));
		l.add(bean1);
		
	}
	
	return l;
	
}

}
