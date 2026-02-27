package com.in.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	private static ComboPooledDataSource cpds = null;

	private static ResourceBundle rb = ResourceBundle.getBundle("com.in.rays.system");

	private JdbcDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("user"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxPoolSize")));
			cpds.setMinPoolSize(Integer.parseInt(rb.getString("minPoolSize")));
			cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireIncrement")));
			cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialPoolSize")));
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}
	
	private static JdbcDataSource jdbc = null;
	
	private static JdbcDataSource getInstance() {
		if(jdbc == null) {
			jdbc = new JdbcDataSource();
			
		}
		return jdbc;
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
		
	}
	
