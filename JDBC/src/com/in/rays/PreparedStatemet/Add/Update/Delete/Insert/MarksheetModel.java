package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public int add(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getMaths());
		ps.setInt(4, bean.getPhy());
		ps.setInt(5, bean.getHin());

		int i = ps.executeUpdate();
		System.out.println(i + " row record insert");

		conn.close();
		ps.close();
		return bean.getId();

	}

	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn
				.prepareStatement("update marksheet set name = ?, maths = ?, phy = ?, hin = ? where id = ?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getMaths());
		ps.setInt(3, bean.getPhy());
		ps.setInt(4, bean.getHin());
		ps.setInt(5, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + " record update");

		conn.close();
		ps.close();

	}

	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");

		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "record deleted");

		conn.close();
		ps.close();

	}

	public MarksheetBean rollno(int roll) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll = ?");
		ps.setInt(1, roll);

		ResultSet rs = ps.executeQuery();

		MarksheetBean mb = null;

		while (rs.next()) {
			mb = new MarksheetBean();
			mb.setId(rs.getInt(1));
			mb.setRoll(rs.getInt(2));
			mb.setName(rs.getString(3));
			mb.setMaths(rs.getInt(4));
			mb.setPhy(rs.getInt(5));
			mb.setHin(rs.getInt(6));

		}
		return mb;

	}

	public List<MarksheetBean> getMeritList(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"select *, (maths + phy + hin) as total from marksheet where maths >= 33 and phy >= 33 and hin >= 33 order by total desc limit 5");
		ResultSet rs = ps.executeQuery();

		List<MarksheetBean> l = new ArrayList<MarksheetBean>();
		MarksheetBean mb = null;
		while (rs.next()) {

			mb = new MarksheetBean();

			mb.setId(rs.getInt(1));
			mb.setRoll(rs.getInt(2));
			mb.setName(rs.getString(3));
			mb.setMaths(rs.getInt(4));
			mb.setPhy(rs.getInt(5));
			mb.setHin(rs.getInt(6));
			l.add(mb);
		}
			conn.close();
			ps.close();
		
		return l;

	}
	
	public List<MarksheetBean> search(MarksheetBean bean) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		
		ResultSet rs = ps.executeQuery();
		List<MarksheetBean> l = new ArrayList<MarksheetBean>();
		
		while(rs.next()) {
			bean= new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRoll(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setMaths(rs.getInt(4));
			bean.setPhy(rs.getInt(5));
			bean.setHin(rs.getInt(6));
			l.add(bean);
		}
		
		return l;
		
	}

}
