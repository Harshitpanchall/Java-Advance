package com.in.rays.Prepared;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestPersonModel {
public static void main(String[] args) throws Exception {
	
//	testadd();
//	testupdate();
//	testdelete();
//	testauthenticate();
//	testfindbypk();
	testsearch();
}

private static void testsearch() throws Exception {
	PersonBean bean = new PersonBean();
	PersonModel pm = new PersonModel();
	
	bean.setName("h");
	bean.setLastname("p");
	
	List<PersonBean> l = pm.search(bean);
	
	Iterator<PersonBean> it = l.iterator();
	
	while(it.hasNext()) {
		bean = it.next();
	System.out.println(bean.getId());
	System.out.println(bean.getName());
	System.out.println(bean.getLastname());
	System.out.println(bean.getCity());
	System.out.println(bean.getNumber());
	System.out.println(bean.getLogin());
	System.out.println(bean.getPassword());
	
	
	}
}

private static void testfindbypk() throws ClassNotFoundException, SQLException {
	PersonBean pb = new PersonBean();
	PersonModel pm = new PersonModel();
	
	pb =  pm.findByPK(1);
	
	System.out.println(pb.getName());
	System.out.println(pb.getLastname());
	if(pb != null) {
		System.out.println(pb.getId());
		System.out.println(pb.getName());
		System.out.println(pb.getCity());
		System.out.println(pb.getNumber());
		System.out.println(pb.getLogin());
		System.out.println(pb.getPassword());
		
		
	}
	
}

private static void testauthenticate() throws ClassNotFoundException, SQLException {
	PersonBean pb = new PersonBean();
	PersonModel pm = new PersonModel();
	
	pb = pm.authenticate("harshit@gmail.com","harshit123");
	
	if(pb != null) {
		System.out.println(pb.getName());
		System.out.println(pb.getLastname());
	}else {
		System.out.println("invalid user or password");
	}
	
}

private static void testdelete() throws ClassNotFoundException, SQLException {
	PersonBean pb = new PersonBean();
	pb.setId(2);
	pb.setName("harsh");
	
	PersonModel pm = new PersonModel();
	pm.delete(pb);
	
}

private static void testupdate() throws ClassNotFoundException, SQLException {
	PersonBean pb = new PersonBean();
	pb.setId(1);
	pb.setName("h dcahdvh");
	pb.setLastname("panchal");
	pb.setCity("indore");
	pb.setNumber(980987098);
	pb.setLogin("vijay@gmail.com");
	pb.setPassword("vijat123");
	
	PersonModel pm = new PersonModel();
	pm.update(pb);
	
}

private static void testadd() throws Exception{
	PersonBean pb = new PersonBean();
	pb.setId(2);
	pb.setName("vihaj");
	pb.setLastname("panchal");
	pb.setCity("indore");
	pb.setNumber(980987098);
	pb.setLogin("vijay@gmail.com");
	pb.setPassword("vijat123");
	
	PersonModel pm = new PersonModel();
	int id = pm.add(pb);
	
	
	
	
}
}
