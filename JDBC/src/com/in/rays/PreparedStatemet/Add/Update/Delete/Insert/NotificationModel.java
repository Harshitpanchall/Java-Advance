package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NotificationModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.bundle.app");
	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String user = rb.getString("user");
	String password = rb.getString("password");

	public long add(NotificationBean bean) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		PreparedStatement ps = conn.prepareStatement("insert into notification values (?, ?, ?, ?, ?)");

		ps.setLong(1, bean.getNotificationId());
		ps.setString(2, bean.getNotificationCode());
		ps.setString(3, bean.getMessage());
		ps.setString(4, bean.getSentTo());
		ps.setTimestamp(5, new Timestamp(new Date().getTime()));

		int i = ps.executeUpdate();
		System.out.println(i + "record is insert");

		conn.close();
		ps.close();

		return bean.getNotificationId();

	}

	public void update(NotificationBean bean) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		PreparedStatement ps = conn.prepareStatement(
				"update notification set notificationcode = ?, message = ?, sent = ?, localdatetime = ? where id = ? ");

		ps.setString(1, bean.getNotificationCode());
		ps.setString(2, bean.getMessage());
		ps.setString(3, bean.getSentTo());
		ps.setTimestamp(4, java.sql.Timestamp.valueOf(bean.getSentTime()));
		ps.setLong(5, bean.getNotificationId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is update");

		conn.close();
		ps.close();
	}

	public void delete(NotificationBean bean) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		PreparedStatement ps = conn.prepareStatement("delete from notification where id = ? ");

		ps.setLong(1, bean.getNotificationId());

		int i = ps.executeUpdate();
		System.out.println(i + "record is delete");

		conn.close();
		ps.close();
	}

	public NotificationBean findByPK(long id) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

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

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

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
			bean.setSentTime(rs.getTimestamp(5).toLocalDateTime());
			l.add(bean);

		}

		return l;

	}
}
