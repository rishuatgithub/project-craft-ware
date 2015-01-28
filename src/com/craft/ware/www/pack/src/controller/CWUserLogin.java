package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craft.ware.www.pack.src.database.CWDatabaseConnection;



/**
 * Servlet implementation class CWUserLogin
 */
public class CWUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CWUserLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid=request.getParameter("username");
		String userpass=request.getParameter("password");
		
		System.out.println(userid);
		System.out.println(userpass);
		
		
		try {
						
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
				
								
				CWDatabaseConnection.closeCWdbConnection();
			}else{
				
				
				
				CWDatabaseConnection.closeCWdbConnection();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			CWDatabaseConnection.closeCWdbConnection();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
