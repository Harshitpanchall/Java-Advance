package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

public class TestNotificationModel {
	public static void main(String[] args) throws Exception {
		
		testadd();
//		testupdate();
//		testdelete();
//		testfindByPK();
//		testsearch();
		
	}

	private static void testsearch() throws Exception {
	NotificationBean bean = new NotificationBean();
	NotificationModel model = new NotificationModel();
	
	List<NotificationBean> l = model.search(1);
	
	Iterator<NotificationBean> it = l.iterator();
	
	while(it.hasNext()) {
		bean = it.next();
		System.out.println(bean.getNotificationId());
		System.out.println(bean.getNotificationCode());
		System.out.println(bean.getMessage());
		System.out.println(bean.getSentTo());
		System.out.println(bean.getSentTime());
	}
	}

	private static void testfindByPK() throws Exception {
		NotificationBean bean = new NotificationBean();
		NotificationModel model = new NotificationModel();
		
		bean = model.findByPK(1);
		System.out.println(bean.getMessage());
		System.out.println(bean.getSentTo());
		
		
		
	}

	private static void testdelete() throws Exception {
		  NotificationBean bean = new NotificationBean();
			bean.setNotificationId(2);
			
			NotificationModel model = new NotificationModel();
			model.delete(bean);
		
	}

	private static void testupdate() throws Exception {
		
        NotificationBean bean = new NotificationBean();
		
		bean.setNotificationCode("yes 0021");
		bean.setMessage("hello order is not complete");
		bean.setSentTo("anup");
		bean.setSentTime(LocalDateTime.now());
		bean.setNotificationId(1);
		
		NotificationModel model = new NotificationModel();
		model.update(bean);
		
	}

	private static void testadd() throws Exception {
	NotificationBean bean = new NotificationBean();
		
		bean.setNotificationId(6);
		bean.setNotificationCode("yes 0032");
		bean.setMessage("hey is sucessfully");
		bean.setSentTo("saket");
		bean.setSentTime(LocalDateTime.now());
		
		NotificationModel model = new NotificationModel();
		model.add(bean);
		
	}
	
	

}
