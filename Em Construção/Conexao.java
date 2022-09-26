package entrega2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/clienteltda";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public Connection getConnection() { 
	    try {
			return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}