package com.in.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
	
	private static 	ComboPooledDataSource cpds = null;
	
	private JdbcDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/rays");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setMaxAdministrativeTaskTime(100);
			cpds.setMinPoolSize(10);
			cpds.setAcquireIncrement(10);
			cpds.setInitialPoolSize(10);
			
		}catch(PropertyVetoException e) {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
