package com.in.rays.PreparedStatement;

public class TestUserEmployee1 {
	
	public static void main(String[] args) throws Exception {
		
		Employee up = new Employee();
	up.setId(3);
	up.setName("hatshit");
	up.setLastName("panchsl");
	up.setCity("bhopal");
	
	UserEmployee up1 = new UserEmployee();
	
	int i = up1.add(up);
	System.out.println(i + "all record saved");
		
	}

}
