package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.craft.ware.www.pack.src.bean.CWSignUpUserBean;
import com.craft.ware.www.pack.src.bean.resultsethandle.CWSignUpUserBeanRS;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;

/**
 * Servlet implementation class CWUserSignUpServlet
 */
public class CWUserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWUserSignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CWSignUpUserBean signupobj=new CWSignUpUserBean();
		CWSignUpUserBeanRS signuprsobj=new CWSignUpUserBeanRS();
		
		signupobj.setNewUserName(request.getParameter("nwusername"));
		signupobj.setNewUserEmail(request.getParameter("nwemailid"));
		signupobj.setNewUserPasswd(request.getParameter("nwpassword"));
		

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		try {
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
				
				/*
				 * Checking For User Name
				 */
				signupobj.setGetUserNameCheckQuery(signupobj.getNewUserName());
				
				signuprsobj.setSignupresultset(CWDatabaseConnection.executePreparedStatement(signupobj.getGetUserNameCheckQuery()));
				JSONArray jsonarr=signuprsobj.fetchsignup(signuprsobj.getSignupresultset());
				
				
				if(signuprsobj.getSignupcount()==0){
					
					/*
					 * Inserting user to the database
					 */
					signupobj.setGetNewUserSignUpQuery(signupobj.getNewUserName(), signupobj.getNewUserEmail(), signupobj.getNewUserPasswd());
					
					signuprsobj.setSignupresultset(CWDatabaseConnection.executePreparedStatement(signupobj.getGetNewUserSignUpQuery()));
					JSONArray jsonarrnwuser=signuprsobj.fetchsignup(signuprsobj.getSignupresultset());
					
					
					response.getWriter().write(jsonarrnwuser.get(0).toString());
				}else{
					
					response.getWriter().write(jsonarr.get(0).toString());
				}
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CWDatabaseConnection.closeCWdbConnection();			
		}
		
	}

}
