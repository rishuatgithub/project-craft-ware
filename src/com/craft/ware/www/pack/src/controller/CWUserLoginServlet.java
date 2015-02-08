package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.craft.ware.www.pack.src.bean.CWLoginUserBean;
import com.craft.ware.www.pack.src.bean.resultsethandle.CWLoginUserBeanRS;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;



/**
 * Servlet implementation class CWUserLogin
 * @author Rishu
 *
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
	 * This Servlet is only for checking the user login request >> validating it and finally displaying the Welcome list
	 * 
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		
		CWLoginUserBean loginuserBean=new CWLoginUserBean();
		CWLoginUserBeanRS loginuserBeanRS=new CWLoginUserBeanRS();
		
		
		loginuserBean.setUserID(request.getParameter("username"));
		loginuserBean.setUserPasscode(request.getParameter("password"));
				
		try {
			
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
							
				loginuserBean.setGetUserLoginQuery(loginuserBean.getUserID(), loginuserBean.getUserPasscode());
										
				loginuserBeanRS.setResultset(CWDatabaseConnection.executePreparedStatement(loginuserBean.getGetUserLoginQuery()));
				
				JSONArray jsonarr=loginuserBeanRS.assignLoginUserBeanRS(loginuserBeanRS.getResultset());
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				
				response.getWriter().write(jsonarr.toString());
				
			}
			
			CWDatabaseConnection.closeCWdbConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			
			
			CWDatabaseConnection.closeCWdbConnection();
		}
		
		
	}

}
