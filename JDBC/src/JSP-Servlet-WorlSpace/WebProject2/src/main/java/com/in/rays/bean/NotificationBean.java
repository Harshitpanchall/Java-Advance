package com.in.rays.bean;

import java.util.Date;

public class NotificationBean {
	private long notificationid;
	private String notificationcode;
	private String message;
	private String sentTo;
    private Date dob;
    
    public long getNotificationId() {
    	return notificationid;
    	
    }
    
    public void setNotificationId(long notificationid) {
    	this.notificationid = notificationid;
    	
    }
    
    public String getNotificationCode() {
    	return notificationcode;
    	
    }
    
    public void setNotificationCode(String notificationcode) {
    	this.notificationcode = notificationcode;
    	
    }
    
    public String getMessage() {
    	return message;
    	
    }
    
    public void setMessage(String message) {
    	this.message = message;
    	
    }
    
    public String getSentTo() {
    	return sentTo;
    	
    }
    
    public void setSentTo(String sentTo) {
    	this.sentTo = sentTo;
    	
    }
    
    public Date getDob() {
    	return dob;
    	
    }
    
    public void setDob(Date dob) {
    	this.dob = dob;
    }
    

}
