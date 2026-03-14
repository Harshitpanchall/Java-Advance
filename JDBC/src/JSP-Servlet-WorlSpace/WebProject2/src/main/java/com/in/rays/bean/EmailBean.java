package com.in.rays.bean;

import java.util.Date;

public class EmailBean {
	private long id;
	private double amount;
	private Date dueDate;
	private String status;
	
	
	public long getId() {
		return id;
		
	}
	
	public void setId(long id) {
		this.id = id;
		
	}
	
	public double getAmount() {
		return  amount;
		
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
		
	}
	
	public Date getDueDate() {
		return dueDate;
		
	}
	
	public void setDueDate(Date duedate) {
		this.dueDate = duedate;
		
	}
	
	public String getStatus() {
		return status;
		
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
