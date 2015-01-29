package com.craft.ware.www.pack.src.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CWDatabaseConnection {
	
	private static final String DB_HOST="localhost"; 
	private static final String DB_PORT="5433";
	private static final String DB_NAME="postgres";
	private static final String DB_USER="postgres";
	private static final String DB_PASSWD="postgres";
	private static final String DB_DRIVER="org.postgresql.Driver";
	private static Connection conn=null;	
	private static ResultSet resultSet;
	
	
	/**
	 * Connecting to the database
	 * 
	 * @true/false : returns true if connection connects
	 * @throws SQLException
	 */
	public static boolean getCWdbConnection() throws SQLException{
		
		try {
			
			Class.forName(DB_DRIVER);
			final String url = "jdbc:postgresql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME;
			final Properties props = new Properties();
		
			props.setProperty("user",DB_USER);
			props.setProperty("password",DB_PASSWD);
			
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
	
	/**
	 * Executing prepared statement [for selecting info]
	 * @throws SQLException 
	 */
	public static ResultSet executePreparedStatement(String preparedStatementQuery){
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(preparedStatementQuery);
			
			/*
			 * You should never pass a ResultSet around through public methods. 
			 * This is prone to resource leaking because you're forced to keep the statement and the connection open. 
			 * Closing them would implicitly close the result set. 
			 * But keeping them open would cause them to dangle around and 
			 * cause the DB to run out of resources when there are too many of them open.
			 */
			setResultSet(ps.executeQuery());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getResultSet();
	}


	public static ResultSet getResultSet() {
		return resultSet;
	}


	public static void setResultSet(ResultSet resultSet) {
		CWDatabaseConnection.resultSet = resultSet;
	}


		
	
}
