package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		Connection conn = null;
		conn = ConnectionUtil.getConnection();
		
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); //if DB does not respond in 30 seconds, quit
			//SQL statement to create table
//			statement.executeUpdate("CREATE TABLE order history(id INTEGER PRIMARY KEY AUTOINCREMENT, "
//					+ "description varchar",
//					+ "cost INTEGER");
//			statement.executeUpdate("INSERT INTO orderHistory (description, cost)"
//					+ "VALUES ('mocha', 3.0)");
//			ResultSet rs = statement.executeQuery("SELECT * FROM orderHistory");
			ResultSet rs = statement.executeQuery("DELETE FROM orderHistory");
			while(rs.next()) {
				System.out.println("Description: " + rs.getString("description"));
				System.out.println("Cost: " + rs.getString("cost"));
				System.out.println("Total: " + rs.getString("total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(conn);
		}

	}

}
