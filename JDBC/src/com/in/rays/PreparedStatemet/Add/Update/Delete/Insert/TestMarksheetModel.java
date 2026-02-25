package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		
//		testadd();
//		testupdate();
//		testroll();
//		testgetmeritlist();
		testsearch();
		
	}

	private static void testsearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		List<MarksheetBean> l = model.search(bean);
		
		Iterator<MarksheetBean> it = l.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getRoll());
			System.out.println(bean.getName());
			System.out.println(bean.getMaths());
			System.out.println(bean.getPhy());
			System.out.println(bean.getHin());
			
		}
		
	}

	private static void testgetmeritlist() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> l = model.getMertlist(bean);
		Iterator<MarksheetBean> it = l.iterator();

		while(it.hasNext()) {
			bean = it.next();
			
			System.out.println("Id :" + bean.getId());
			System.out.println("Roll :" + bean.getRoll());
			System.out.println("name : " + bean.getName());
			System.out.println("maths :" + bean.getMaths());
			System.out.println("phy :" + bean.getPhy());
			System.out.println("hin :" + bean.getHin());
			
		}
	}

	private static void testroll() throws Exception {
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = model.findByRoll(66);
		
		System.out.println(bean.getId());
		System.out.println(bean.getRoll());
		System.out.println(bean.getName());
		System.out.println(bean.getMaths());
		System.out.println(bean.getPhy());
		System.out.println(bean.getHin());
			
	}

	private static void testupdate() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setRoll(66);
		bean.setName("yogesh");
		bean.setMaths(77);
		bean.setPhy(65);
		bean.setHin(99);
		bean.setId(3);
		
		MarksheetModel model = new MarksheetModel();
		model.update(bean);
		
	}

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(14);
		bean.setRoll(23);
		bean.setName("harshit");
		bean.setMaths(88);
		bean.setPhy(76);
		bean.setHin(96);
		
		MarksheetModel model = new MarksheetModel();
		model.add(bean);
		
	}
	

}
