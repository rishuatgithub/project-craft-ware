package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.craft.ware.www.pack.src.bean.CWLoginUserBean;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;




/**
 * Servlet implementation class CWUserLogin
 */
public class CWUserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CWUserLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
			
		CWLoginUserBean loginuserBean=new CWLoginUserBean();
		loginuserBean.setUserID(request.getParameter("username"));
		loginuserBean.setUserPasscode(request.getParameter("password"));
				
		try {
						
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
				
				loginuserBean.setGetUserLoginQuery(loginuserBean.getUserID(), loginuserBean.getUserPasscode());
				
				ResultSet rs=CWDatabaseConnection.executePreparedStatement(loginuserBean.getGetUserLoginQuery());
				
				while(rs.next()){
					loginuserBean.setUserLoginCount(rs.getInt(1));
				}
				
				response.setContentType("application/html");
				response.setCharacterEncoding("UTF-8");
				
				if(loginuserBean.getUserLoginCount()==1){
					
					response.getWriter().write(loginuserBean.getUserID());
					
				}else{
					
					response.getWriter().write("Invalid User");
					
				}
			}
			
			CWDatabaseConnection.closeCWdbConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			CWDatabaseConnection.closeCWdbConnection();
		}
		
		
	}

}
