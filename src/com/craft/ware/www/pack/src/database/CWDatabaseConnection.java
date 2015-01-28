package com.craft.ware.www.pack.src.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CWDatabaseConnection {
	
	private static final String DB_HOST="localhost"; 
	private static final String DB_PORT="5433";
	private static final String DB_NAME="postgres";
	private static Connection conn=null;	
	
	/**
	 * 
	 * @true/false : returns true if connection connects
	 * @throws SQLException
	 */
	public static boolean getCWdbConnection() throws SQLException{
		
		try {
			
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME;
			Properties props = new Properties();
		
			props.setProperty("user","postgres");
			props.setProperty("password","postgres");
			
			conn = DriverManager.getConnection(url, props);
			
			return true;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	

	/**
	 * Closing the Connection
	 */
	public static void closeCWdbConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
