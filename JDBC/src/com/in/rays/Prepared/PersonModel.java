package com.in.rays.Prepared;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonModel {
	public int add(PersonBean bean) throws Exception {

		PersonBean existsBean = findByLogin(bean.getLogin());
		if (existsBean != null) {
			throw new Exception("already is email is exits ");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into person values(?,?,?,?,?,?,?)");

		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getLastname());
		ps.setString(4, bean.getCity());
		ps.setInt(5, bean.getNumber());
		ps.setString(6, bean.getLogin());
		ps.setString(7, bean.getPassword());

		int i = ps.executeUpdate();
		System.out.println(i + "record insert");

		conn.close();
		ps.close();

		return bean.getId();

	}

	public void update(PersonBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update person set name = ?, lastname = ?, city = ?, number = ?, login = ?, password = ? where id = ?");
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getLastname());
		ps.setString(3, bean.getCity());
		ps.setInt(4, bean.getNumber());
		ps.setString(5, bean.getLogin());
		ps.setString(6, bean.getPassword());
		ps.setInt(7, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "record update");

		conn.close();
		ps.close();

	}

	public void delete(PersonBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("delete from person where id = ?");
		ps.setInt(1, bean.getId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is delete");
	}

	private PersonBean findByLogin(String login) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from person where login = ?");

		ps.setString(1, login);

		ResultSet rs = ps.executeQuery();

		PersonBean pb = null;

		while (rs.next()) {
			pb = new PersonBean();
			pb.setId(rs.getInt(1));
			pb.setName(rs.getString(2));
			pb.setLastname(rs.getString(3));
			pb.setCity(rs.getString(4));
			pb.setLogin(rs.getString(5));
			pb.setPassword(rs.getString(6));
			pb.setNumber(rs.getInt(7));
		}
		return pb;
	}

	public PersonBean authenticate(String login, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from person where login = ? and password = ?");

		ps.setString(1, login);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		PersonBean pb = null;

		while (rs.next()) {
			pb = new PersonBean();
			pb.setName(rs.getString(1));
			pb.setLastname(rs.getString(2));
		}

		return pb;

	}

	public PersonBean findByPK(int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from person where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		PersonBean pb = null;
		while (rs.next()) {
			pb = new PersonBean();
			pb.setId(rs.getInt(1));
			pb.setName("harshit");
			pb.setLastname("panchal");
			pb.setCity("indore");
			pb.setNumber(987698769);
			pb.setLogin("harshitpanckal@gmail.com");
			pb.setPassword("harshit123");

		}

		return pb;

	}

	public List<PersonBean> search(PersonBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		StringBuffer sql = new StringBuffer("select * from person where 1 = 1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sql.append(" and lastname like '" + bean.getLastname() + "%'");
			}
		}

		System.out.println("sql ==> " + sql.toString());

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		List l = new ArrayList();

		while (rs.next()) {
			bean = new PersonBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCity(rs.getString(4));
			bean.setNumber(rs.getInt(5));
			bean.setLogin(rs.getString(6));
			bean.setPassword(rs.getString(7));
			l.add(bean);
		}
		return l;

	}
}
