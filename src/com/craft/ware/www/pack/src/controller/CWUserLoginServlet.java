package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.craft.ware.www.pack.src.bean.CWLoginUserBean;
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
		JSONObject jsonobj=null;
		JSONArray jsonarr=null;
		
		loginuserBean.setUserID(request.getParameter("username"));
		loginuserBean.setUserPasscode(request.getParameter("password"));
				
		try {
						
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
							
				
				loginuserBean.setGetUserLoginQuery(loginuserBean.getUserID(), loginuserBean.getUserPasscode());
				
				ResultSet rs=CWDatabaseConnection.executePreparedStatement(loginuserBean.getGetUserLoginQuery());
				
				jsonobj=new JSONObject();
				jsonarr=new JSONArray();
				
				while(rs.next()){
					
					if(rs.getInt(1)!=0){
						loginuserBean.setUserLoginCount(rs.getInt(1));
					}
					if(rs.getString(2)!=null){
						loginuserBean.setUserName(rs.getString(2));
					}
					if(rs.getString(3)!=null){
						loginuserBean.setUserRole(rs.getString(3));
					}
					
					jsonobj.put("userLoginCount",loginuserBean.getUserLoginCount());
					jsonobj.put("userName", loginuserBean.getUserName());
					jsonobj.put("userRole",loginuserBean.getUserRole());
					
				}
				
				jsonarr.put(jsonobj);
				
				
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
