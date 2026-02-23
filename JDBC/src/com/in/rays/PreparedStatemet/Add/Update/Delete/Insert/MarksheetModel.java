package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	ResourceBundle rs = ResourceBundle.getBundle("com.in.rays.bundle.app");
	String driver = rs.getString("driver");
	String url = rs.getString("url");
	String user = rs.getString("user");
	String password = rs.getString("password");
	
	public int add(MarksheetBean bean) throws Exception  {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		
		ps.setInt(1,bean.getId());
		ps.setInt(2,bean.getRoll());
		ps.setString(3,bean.getName());
		ps.setInt(4,bean.getMaths());
		ps.setInt(5,bean.getPhy());
		ps.setInt(6,bean.getHin());
		
		int i = ps.executeUpdate();
		
		System.out.println(i + "record is insert");
		
		conn.close();
		ps.close();
		
		return bean.getId();
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement(
				"update marksheet set roll = ?, name = ?, maths = ?, phy = ?, hin = ? where id = ?");
		
		ps.setInt(1,bean.getRoll());
		ps.setString(2,bean.getName());
		ps.setInt(3,bean.getMaths());
		ps.setInt(4,bean.getPhy());
		ps.setInt(5,bean.getHin());
		ps.setInt(6,bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println(i + "record is updated");
		
		conn.close();
		ps.close();
		
	}
	
	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		
		ps.setInt(1,bean.getId()); /// queary data jaya ha
		
		int i = ps.executeUpdate(); // query database se delete ho gaya aha 
		System.out.println(i + "record delete");
		
		conn.close();
		ps.close();
		
		
	}
	
	public MarksheetBean findByRoll(int roll) throws Exception {
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll = ?");
		
		ps.setInt(1, roll);
		
		MarksheetBean mb = null;  // null  matlab marksheet nahi mili hai 
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		 mb = new MarksheetBean(); // nullpointerException nahi laga ta hu me  its a object 
			mb.setId(rs.getInt(1));
			mb.setRoll(rs.getInt(2));
			mb.setName(rs.getString(3));
			mb.setMaths(rs.getInt(4));
			mb.setPhy(rs.getInt(5));
			mb.setHin(rs.getInt(6));
			
		}
		
		conn.close();
		
		return mb;
		
	}
	
	public List<MarksheetBean> getMertlist(MarksheetBean bean) throws Exception {
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement(
				"select *, (maths + phy + hin) as total from marksheet where maths >= 33 and phy >= 33 and hin >= 33 order by total desc limit 5");
		
		ResultSet rs = ps.executeQuery();
		
		List<MarksheetBean> l = new ArrayList();
		
		MarksheetBean mb = null;
		
		while(rs.next()) {
			mb = new MarksheetBean();
			mb.setId(rs.getInt(1));
			mb.setRoll(rs.getInt(2));
			mb.setName(rs.getString(3));
			mb.setMaths(rs.getInt(4));
			mb.setPhy(rs.getInt(5));
			mb.setHin(rs.getInt(6));
			l.add(mb); // set object addd nahi duyanga tho nzhi ho ga
		}
		conn.close();
		ps.close();
		
		return l;
		
	}
	
	public List<MarksheetBean> search(MarksheetBean bean) throws Exception {
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		List<MarksheetBean> l = new ArrayList();
		ResultSet rs = ps.executeQuery();
		
		MarksheetBean bean1 = null;
		
		while(rs.next()) {
			bean1 = new MarksheetBean();
			
			bean1.setId(rs.getInt(1));
			bean1.setRoll(rs.getInt(2));
			bean1.setName(rs.getString(3));
			bean1.setMaths(rs.getInt(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setHin(rs.getInt(6));
			l.add(bean1);
			
		}
		
		return l;
		
	}
	
	
	
	
	

}
