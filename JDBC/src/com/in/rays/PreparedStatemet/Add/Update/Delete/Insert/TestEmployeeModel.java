package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.util.Iterator;
import java.util.List;

public class TestEmployeeModel {
	public static void main(String[] args) throws Exception {
//		testadd();
//		testupdate();
		testdelete();
//		testfindByPK();
//		testsearch();
	}
	
	private static void testdelete() throws Exception {
		EmployeeBean bean = new EmployeeBean();
		
		bean.setId(2);
		
		EmployeeModel model = new EmployeeModel();
		 bean = model.delete(bean);
		
		
		
	}

	private static void testsearch() throws Exception {
	
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
				
				List<EmployeeBean> l = model.search(bean);
				
				Iterator<EmployeeBean> it = l.iterator();
				
				while(it.hasNext()) {
					bean = it.next();
					
					System.out.println(bean.getId());
					System.out.println(bean.getName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getCity());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					
						
					}
	}



	private static void testfindByPK() throws Exception {
		EmployeeBean bean = new EmployeeBean();
		EmployeeModel model = new EmployeeModel();
		
		bean = model.findByPK(2);
		
		if(bean != null) {
			System.out.println(bean.getName());
			System.out.println(bean.getLastName());
			
		}else {
			System.out.println("user in valid");
		}
		
		
	}



	private static void testupdate() throws Exception {
		EmployeeBean bean = new EmployeeBean();
	
		bean.setId(2);
		bean.setName("harshit");
		bean.setLastname("panchal");
		bean.setCity("kitna");
		bean.setLogin("harshit@gmail.com");
		bean.setPassword("harsh123");
		bean.setId(2);
		
		EmployeeModel  model = new EmployeeModel();
		bean = model.update(bean);
	}

	private static void testadd() throws Exception {
        EmployeeBean bean = new EmployeeBean();
		
		bean.setId(6);
		bean.setName("raju");
		bean.setLastname("nhiya");
		bean.setCity("katni");
		bean.setLogin("raju@gmail.com");
		bean.setPassword("raju123");
		
		EmployeeModel model = new EmployeeModel();
		model.add(bean);
		
	}

}
