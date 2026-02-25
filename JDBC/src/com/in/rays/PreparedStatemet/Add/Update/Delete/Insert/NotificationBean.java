package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

import java.time.LocalDateTime;

public class NotificationBean {
	private long notificationid;
	private String notificationcode;
	private String message;
	private String sentTo;
    private LocalDateTime sentTime;
    
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
    
    public LocalDateTime getSentTime() {
    	return sentTime;
    	
    }
    
    public void setSentTime(LocalDateTime sentTime) {
    	this.sentTime = sentTime;
    }
    

}
