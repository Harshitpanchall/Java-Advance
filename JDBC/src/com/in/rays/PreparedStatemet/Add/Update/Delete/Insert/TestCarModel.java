package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.util.Iterator;
import java.util.List;

public class TestCarModel {
	public static void main(String[] args) throws Exception {
		
//	testadd();
//		testdelete();
		//testupdate();
//	testfindByPK();
		testsearch();
		
		
		
	}

	private static void testsearch() throws Exception {
		CarBean bean = new CarBean();
		CarModel model = new CarModel();
		
		List<CarBean> l = model.search(bean);
		
		Iterator<CarBean> it = l.iterator(); 
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getCarId());
			System.out.println(bean.getCarCode());
			System.out.println(bean.getCarName());
			System.out.println(bean.getCarModel());
			System.out.println(bean.getCarStatus());
		}
		
	}

	private static void testfindByPK() throws Exception {
		CarBean bean = new CarBean();
		CarModel model= new CarModel();
		bean = model.findByPK(2);
		if(bean != null) {
			System.out.println(bean.getCarCode());
			System.out.println(bean.getCarModel());
		
		}else {
			System.out.println("not invalid user");
		}
		
	}

	private static void testupdate() throws Exception {
		CarBean bean = new CarBean();
		
		bean.setCarCode("xc001");
		bean.setCarName("verna");
		bean.setCarModel("00lu");
		bean.setCarStatus("available");
		bean.setCarId(9);
		
		CarModel model = new CarModel();
		model.update(bean);
		
	}

	private static void testdelete() throws Exception {
		CarBean bean = new CarBean();
		
		bean.setCarId(1);
		
		CarModel model = new CarModel();
		
		model.delete(bean);
		
	}

	private static void testadd() throws Exception {
		CarBean bean = new CarBean();
		
		bean.setCarId(12);
		bean.setCarCode("001xu");
		bean.setCarName("rang Rover");
		bean.setCarModel("v005i");
		bean.setCarStatus("not available");
		
		CarModel model = new CarModel();
		model.add(bean);
		
		
		
	}

}
