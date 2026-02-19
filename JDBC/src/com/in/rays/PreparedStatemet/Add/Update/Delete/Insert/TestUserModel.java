package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.SQLException;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testupdate();
		testdelete();
		
	}

	private static void testdelete() throws Exception {
		UserBean bean = new UserBean();
		
		bean.setId(1);
		
		UserModel um = new UserModel();
		um.delete(bean);
		
	}

	private static void testupdate() throws Exception {
		UserBean ub = new UserBean();
		ub.setId(1);
		ub.setName("harsh");
		ub.setLastname("tiwari");
		ub.setCity("jaipure");
		
		UserModel um = new UserModel();
		um.update(ub);
		
		
		
		
	}

	private static void testAdd() throws Exception {
        UserBean ub = new UserBean();
		
		ub.setId(23);
		ub.setName("vijay");
		ub.setLastname("tiwari");
		ub.setCity("bilashpure");
		
		UserModel um = new UserModel();
		
		int i = um.add(ub);
		System.out.println(i + "record in insert");
		
		
	}

}
