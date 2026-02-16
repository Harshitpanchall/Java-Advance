package TransactionHanding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into Person1 values(7,'hello','satna',6546543)");
			
			i = stmt.executeUpdate("insert into Person1 values(9,'rishab','jaipure',87687658)");
			
			i = stmt.executeUpdate("insert into Person1 values(8,'udat','kanpure',23434543)");
			
			conn.commit();
			System.out.println("all record are saved");
			
			conn.close();
			stmt.close();
		
		}catch(Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		
	}

}
