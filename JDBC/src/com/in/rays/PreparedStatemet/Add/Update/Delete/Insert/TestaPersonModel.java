package com.in.rays.PreparedStatemet.Add.Update.Delete.Insert;

public class TestaPersonModel {
	public static void main(String[] args) throws Exception {
		
		testadd();
//		testupdate();
		
	}

	private static void testupdate() throws Exception {
PersonBean pb = new PersonBean();
		
		pb.setId(5);
		pb.setName("nanni");
		pb.setLastname("panchal");
		pb.setCity("bhopal");
		pb.setNumber(987687687);
		
		PersonModel pm = new PersonModel();
		pm.add(pb);
		
	}

	private static void testadd() throws ClassNotFoundException, Exception {
		PersonBean pb = new PersonBean();
		
		pb.setId(7);
		pb.setName("viyat");
		pb.setLastname("tiwari");
		pb.setCity("indore");
		pb.setNumber(987987698);
		
		PersonModel pm = new PersonModel();
		pm.add(pb);
		
	}

}
