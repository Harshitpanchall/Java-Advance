package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.in.rays.util.JdbcDataSource;

public class WarehouseModel {
	public long add(WarehouseBean bean) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into warehouse values(?, ?, ?, ?)");
	
		ps.setLong(1,bean.getWarehouseId());
		ps.setString(2,bean.getWareouseName());
		ps.setString(3,bean.getLocation());
		ps.setLong(4,bean.getCapacity());
		
		int i = ps.executeUpdate();
		System.out.println(i + "record is insert");
		
		conn.close();
		ps.close();
		return bean.getWarehouseId();
		
		
	}
	public void update(WarehouseBean bean) throws Exception {
		
	Connection conn = JdbcDataSource.getConnection();
	PreparedStatement ps = conn.prepareStatement("update Warehouse set warehousename = ?, location = ?, capacity = ? where id = ?");

	ps.setString(1,bean.getWareouseName());
	ps.setString(2,bean.getLocation());
	ps.setLong(3,bean.getCapacity());
	ps.setLong(4,bean.getWarehouseId());
	
	int i = ps.executeUpdate();
	System.out.println(i + "record is update");
	
	conn.close();
	ps.close();
	}
	
	public void delete(WarehouseBean bean) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from warehouse where id = ?");
		ps.setLong(1,bean.getWarehouseId());
		
		int i = ps.executeUpdate();
		System.out.println(i + "record is delete");
		
		conn.close();
		ps.close();
	
}
	
	public WarehouseBean findByPK(long id) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from warehouse where id = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		
		WarehouseBean bean = null;
		while(rs.next()) {
			bean = new WarehouseBean();
			
		bean.setWareHouseName(rs.getString(1));
		bean.setLocation(rs.getString(2));
	
		}
		conn.close();
		ps.close();
		
		return bean;
		
	}
	

	public List<WarehouseBean> search(WarehouseBean bean) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from warehouse");
		ResultSet rs = ps.executeQuery();
		List<WarehouseBean> l = new ArrayList<WarehouseBean>();
		
		WarehouseBean bean1 = null;
		while(rs.next()) {
			bean1 = new WarehouseBean();
			
		bean1.setWarehouseId(rs.getLong(1));
		bean1.setWareHouseName(rs.getString(2));
		bean1.setLocation(rs.getString(3));
		bean1.setCapacity(rs.getLong(4));
		l.add(bean1);
		
		}
		conn.close();
		ps.close();
		return l;
	
		}
	}
