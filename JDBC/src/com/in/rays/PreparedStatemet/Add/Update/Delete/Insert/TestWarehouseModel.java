package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.util.Iterator;
import java.util.List;

public class TestWarehouseModel {
	public static void main(String[] args) throws Exception {
		
//		testadd();
//		testupdate();
//		testdelete();
//		testfindByPK();
		testsearch();
		
		
	}

	private static void testsearch() throws Exception {
		WarehouseBean bean = new WarehouseBean();
		WarehouseModel model = new WarehouseModel();
		
		List<WarehouseBean> l = model.search(bean);
		Iterator<WarehouseBean> it = l.iterator();
		
		while(it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getWarehouseId());
			System.out.println(bean.getWareouseName());
			System.out.println(bean.getLocation());
			System.out.println(bean.getCapacity());
		}
		
	}

	private static void testfindByPK() throws Exception {
		WarehouseBean bean = new WarehouseBean();
		WarehouseModel model = new WarehouseModel();
		
		bean = model.findByPK(3);
		System.out.println(bean.getLocation());
		
	}

	private static void testdelete() throws Exception {
		    WarehouseBean bean = new WarehouseBean();
			bean.setWarehouseId(1);
			
			
			WarehouseModel model = new WarehouseModel();
			model.delete(bean);
		
	}

	private static void testupdate() throws Exception {
         WarehouseBean bean = new WarehouseBean();
		
		bean.setWareHouseName("delhiwarehouse store");
		bean.setLocation("pune");
		bean.setCapacity(3000);
		bean.setWarehouseId(3);
		
		WarehouseModel model = new WarehouseModel();
		model.update(bean);
		
	}

	private static void testadd() throws Exception {
		WarehouseBean bean = new WarehouseBean();
		
		bean.setWarehouseId(3);
		bean.setWareHouseName("bhopal store");
		bean.setLocation("delhi");
		bean.setCapacity(1000);
		
		WarehouseModel model = new WarehouseModel();
		model.add(bean);
		
	}

}
