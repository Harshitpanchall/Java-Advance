package com.in.rays.bundle;

import java.util.ResourceBundle;

public class Testapp {
	public static void main(String[] args) {
		
		ResourceBundle rs = ResourceBundle.getBundle("com.in.rays.bundle.app");
		String driver = rs.getString("driver");
		String url = rs.getString("url");
		String user = rs.getString("user");
		String password = rs.getString("password");
		
		System.out.println(driver + "\n" + url + "\n" + user+ "\n" + password);
	}

}