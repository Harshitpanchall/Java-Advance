package com.in.rays.Prepared;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		
//		testadd();
//		testupdate();
//		testdelete();
//		testauthenticate();
//		testfindbypk();
		testsearch();	
		
	}


	private static void testsearch() throws Exception {
		UserModel um = new UserModel();
		UserBean bean= new UserBean();
		
		List<UserBean> l = um.search(bean);
		
		Iterator<UserBean> it = l.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			
		}
		
		
	}


	private static void testfindbypk() throws Exception {
		
		UserModel um = new UserModel();
		UserBean ub = new UserBean();
		
		ub = um.findByPK(1);
		System.out.println(ub.getFirstname());
		System.out.println(ub.getLastname());
		
	}


	private static void testauthenticate() throws Exception, SQLException {
		UserModel um = new UserModel();
		UserBean ub = new UserBean();
		
		ub = um.authenticate("harshit@gmail.com","harshit123");
		if(ub != null) {
			System.out.println(ub.getFirstname());
			System.out.println(ub.getLastname());
		}else {
			System.out.println("invalid login or password");
		}
		
		
	}


	private static void testdelete() throws Exception {
		UserBean ub = new UserBean();
		
		ub.setId(10);
		
		UserModel um = new UserModel();
		um.delete(ub);
		
		
	}

	private static void testupdate() throws Exception{
		UserBean bean = new UserBean();
		bean.setFirstname("vijay");
		bean.setLastname("tiwari");
		bean.setLogin("vijay@gmail.com");
		bean.setPassword("vijay123");
		bean.setDob(new Date());
		bean.setId(10);
		
		UserModel um = new UserModel();
		um.update(bean);
		
	}

	private static void testadd() throws Exception{
		UserBean ub = new UserBean();
		ub.setId(1);
		ub.setFirstname("hatshit");
		ub.setLastname("panchal");
		ub.setLogin("harshit@gmail.cim");
		ub.setPassword("harshit123");
		ub.setDob(new Date());
		
		UserModel um = new UserModel();
		int id = um.add(ub);
		
		
	}
	

}
