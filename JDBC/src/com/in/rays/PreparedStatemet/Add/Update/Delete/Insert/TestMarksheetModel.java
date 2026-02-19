package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.in.rays.Prepared.PersonBean;
import com.in.rays.Prepared.PersonModel;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
//		testadd();
//		testupdate();
//		testdelete();
//		testroll();
//		testmeritlist();
		testsearch();

	}

	private static void testsearch() throws Exception  {
		MarksheetBean mb = new MarksheetBean();
		MarksheetModel mm = new MarksheetModel();
		
		List<MarksheetBean> l = mm.search(mb);
		
		Iterator<MarksheetBean> it = l.iterator();
		while(it.hasNext()) {
			mb = it.next();
			
			System.out.println(mb.getId());
			System.out.println(mb.getRoll());
			System.out.println(mb.getName());
			System.out.println(mb.getMaths());
			System.out.println(mb.getPhy());
			System.out.println(mb.getHin());
			
		}
		
		
	}

	private static void testmeritlist() throws Exception, SQLException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel mm = new MarksheetModel();
		
		List<MarksheetBean> l = mm.getMeritList(bean);
		
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

	private static void testroll() throws ClassNotFoundException, SQLException {

		MarksheetModel mm = new MarksheetModel();

		MarksheetBean mb1 = mm.rollno(1);

		System.out.println(mb1.getId());
		System.out.println(mb1.getRoll());
		System.out.println(mb1.getName());
		System.out.println(mb1.getMaths());
		System.out.println(mb1.getPhy());
		System.out.println(mb1.getHin());

	}

	private static void testdelete() throws Exception {
		MarksheetBean mb = new MarksheetBean();

		mb.setId(6);
		MarksheetModel mm = new MarksheetModel();
		mm.delete(mb);

	}

	private static void testupdate() throws Exception {
		MarksheetBean mb = new MarksheetBean();
		mb.setId(2);
		mb.setName("shyam bhiya");
		mb.setMaths(77);
		mb.setPhy(88);
		mb.setHin(97);

		MarksheetModel mm = new MarksheetModel();
		mm.update(mb);

	}

	private static void testadd() throws Exception {

		MarksheetBean mb = new MarksheetBean();
		mb.setId(12);
		mb.setName("vijay Tiwari");
		mb.setMaths(84);
		mb.setHin(88);
		mb.setPhy(87);

		MarksheetModel mm = new MarksheetModel();
		mm.add(mb);

	}

}
