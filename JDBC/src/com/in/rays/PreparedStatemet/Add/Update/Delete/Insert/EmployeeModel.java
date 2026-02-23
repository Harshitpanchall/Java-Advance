package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.in.rays.util.JdbcDataSource;

public class EmployeeModel {

	public int add(EmployeeBean bean) throws Exception {

		EmployeeBean existBean = findByLogin(bean.getLogin());
		if (existBean != null) {
			throw new Exception("alrealy is email exists");

		}

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getCity());
		pstmt.setString(5, bean.getLogin());
		pstmt.setString(6, bean.getPassword());

		int i = pstmt.executeUpdate();
		System.out.println(i + "insert into record");

		conn.close();
		pstmt.close();
		return bean.getId();

	}

	public EmployeeBean update(EmployeeBean bean) throws Exception {
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update employee set name = ?, lastname = ?, city = ?, login = ?, password = ? where id = ?");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getCity());
		ps.setString(4, bean.getLogin());
		ps.setString(5, bean.getPassword());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + " record in update");

		conn.close();
		ps.close();
		return bean;
	}

	public EmployeeBean delete(EmployeeBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from employee where id = ?");
		ps.setInt(1, bean.getId());
		int i = ps.executeUpdate();
		System.out.println(i + "record in delete");

		conn.close();
		ps.close();
		return bean;

	}

	private EmployeeBean findByLogin(String login) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhist:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from employee where login = ?");

		ps.setString(1, login);

		ResultSet rs = ps.executeQuery();

		EmployeeBean bean = null;

		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCity(rs.getString(4));
			bean.setLogin(rs.getString(5));
			bean.setPassword(rs.getString(6));

		}

		conn.close();
		ps.close();

		return bean;
	}

	public EmployeeBean findByPK(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		EmployeeBean bean = null;

		while (rs.next()) {
			bean = new EmployeeBean();
			bean.setName(rs.getString(1));
			bean.setLastname(rs.getString(2));
		}

		conn.close();
		ps.close();

		return bean;

	}

	public List<EmployeeBean> search(EmployeeBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from employee");

		ResultSet rs = ps.executeQuery();

		List<EmployeeBean> l = new ArrayList();
		EmployeeBean bean1 = null;

		while (rs.next()) {
			bean1 = new EmployeeBean();
			bean1.setId(rs.getInt(1));
			bean1.setName(rs.getString(2));
			bean1.setLastname(rs.getString(3));
			bean1.setCity(rs.getString(4));
			bean1.setLogin(rs.getString(5));
			bean1.setPassword(rs.getString(6));
			l.add(bean1);

		}
		conn.close();
		ps.close();

		return l;

	}
}
