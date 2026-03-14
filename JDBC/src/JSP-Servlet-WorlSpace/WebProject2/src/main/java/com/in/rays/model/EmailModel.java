package com.in.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.in.rays.bean.EmailBean;
import com.in.rays.util.JdbcDataSource;

public class EmailModel {
	public long add(EmailBean bean) throws Exception {
		
		Connection conn = JdbcDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("insert into email values(?,?,?,?)");
		pstmt.setLong(1, bean.getId());
		pstmt.setDouble(2, bean.getAmount());
		pstmt.setDate(3, new java.sql.Date(bean.getDueDate().getTime()));
		pstmt.setString(4, bean.getStatus());
		
		int i = pstmt.executeUpdate();
		System.out.println(i + "record is add");
		
		conn.close();
		pstmt.close();
		
		return bean.getId();
		
	}

}
