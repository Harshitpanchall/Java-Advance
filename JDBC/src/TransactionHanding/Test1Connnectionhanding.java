package TransactionHanding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1Connnectionhanding {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
	
		try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
	conn.setAutoCommit(false);
	
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("insert into Person1 values(2,'hatshigt','indore',987698769)");
	i = stmt.executeUpdate("insert into Person1(id,name,city,number) values(20,'rohit','bhopal',987987987)");
	
	conn.commit();
	System.out.println("all data is savedd");
	
	conn.close();
	stmt.close();
	
	}catch(Exception e ) {
		conn.rollback();
		e.printStackTrace();
	}
		

}

}
