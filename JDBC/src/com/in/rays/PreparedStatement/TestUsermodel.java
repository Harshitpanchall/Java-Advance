package com.in.rays.PreparedStatement;

import java.sql.Date;

public class TestUsermodel {
	public static void main(String[] args) throws Exception {
		
		UserBean ub = new UserBean();
		ub.setId(1);
		ub.setFristname("summita");
		ub.setLastname("Tiwari");
		ub.setLogin("summita@gmail.com");
		ub.setPassword("summita123");
		ub.setDob(new java.util.Date());
		
		UserModel um = new UserModel();
		
		int i = um.add(ub);
		System.out.println(i + "all record are add");
		
	}

}
