package com.in.rays.Prepared;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	public int add(UserBean bean) throws Exception {

		UserBean existBean = findByLogin(bean.getLogin());

		if (existBean != null) {
			throw new Exception("already email id exists");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstname());
		ps.setString(3, bean.getLastname());
		ps.setString(4, bean.getLogin());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = ps.executeUpdate();
		System.out.println(i + " record is added");
		conn.close();
		ps.close();
		return bean.getId();
	}

	public void update(UserBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update st_user set firstname = ?, lastname = ?, login = ?, password = ?, dob = ? where id = ?");
		ps.setString(1, bean.getFirstname());
		ps.setString(2, bean.getLastname());
		ps.setString(3, bean.getLogin());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new Date(bean.getDob().getTime()));
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		System.out.println(i + " record is update");

		conn.close();
		ps.close();

	}

	public void delete(UserBean bean) throws ClassNotFoundException, Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from st_user where id = ?");

		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is deleted");

		conn.close();
		ps.close();

	}

	public UserBean findByLogin(String login) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rayd", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from st_user where login = ?");
		ps.setString(1, login);
		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}

		return bean;
	}

	public UserBean authenticate(String login, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from st_user where login = ? and password = ?");
		ps.setString(1, login);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		return bean;

	}

	public UserBean findByPK(int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from st_user where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;

	}

	public List<UserBean> search(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from st_user");

		ResultSet rs = ps.executeQuery();

		List<UserBean> l = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			l.add(bean);
		}
		return l;

	}
}
