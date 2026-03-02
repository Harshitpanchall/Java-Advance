package com.in.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.in.rays.bean.NotificationBean;
import com.in.rays.util.JdbcDataSource;

public class NotificationModel {
	
	public int nextpk() throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from notification");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
			
		}
		return pk + 1 ;
	}

	public long add(NotificationBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("insert into notification values (?, ?, ?, ?, ?)");

		ps.setLong(1, nextpk());
		ps.setString(2, bean.getNotificationCode());
		ps.setString(3, bean.getMessage());
		ps.setString(4, bean.getSentTo());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));

		int i = ps.executeUpdate();
		System.out.println(i + "record is insert");

		conn.close();
		ps.close();

		return bean.getNotificationId();

	}

	public void update(NotificationBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"update notification set notificationcode = ?, message = ?, sent = ?, localdatetime = ? where id = ? ");

		ps.setString(1, bean.getNotificationCode());
		ps.setString(2, bean.getMessage());
		ps.setString(3, bean.getSentTo());
		ps.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		ps.setLong(5, bean.getNotificationId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is update");

		conn.close();
		ps.close();
	}

	public void delete(NotificationBean bean) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("delete from notification where id = ? ");

		ps.setLong(1, bean.getNotificationId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is delete");

		conn.close();
		ps.close();
	}

	public NotificationBean findByPK(long id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from notification where id = ?");

		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();

		NotificationBean bean = null;

		while (rs.next()) {
			bean = new NotificationBean();
			bean.setMessage(rs.getString(1));
			bean.setSentTo(rs.getString(2));

		}

		return bean;

	}

	public List<NotificationBean> search(long id) throws Exception {

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from notification");

		ResultSet rs = ps.executeQuery();
		List<NotificationBean> l = new ArrayList<NotificationBean>();

		NotificationBean bean = null;

		while (rs.next()) {
			bean = new NotificationBean();

			bean.setNotificationId(rs.getLong(1));
			bean.setNotificationCode(rs.getString(2));
			bean.setMessage(rs.getString(3));
			bean.setSentTo(rs.getString(4));
			bean.setDob(new java.sql.Date(bean.getDob().getTime()));
			l.add(bean);

		}

		return l;

	}
}
