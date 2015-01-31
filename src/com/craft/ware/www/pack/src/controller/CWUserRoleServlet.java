package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.craft.ware.www.pack.src.bean.CWUserRoleBean;
import com.craft.ware.www.pack.src.bean.resultsethandle.CWUserRoleBeanRS;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;

/**
 * Servlet implementation class CWUserRoleServlet
 */
public class CWUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWUserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CWUserRoleBean userrolebean=new CWUserRoleBean();
		CWUserRoleBeanRS userrolebeanrs=new CWUserRoleBeanRS();
		
		userrolebean.setUserrole(request.getParameter("userRole"));
		
		System.out.println(userrolebean.getUserrole());
		
		try {
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			
			if(getConnect){
				
				userrolebean.setGetUserRoleQuery(userrolebean.getUserrole());
				
				userrolebeanrs.setRoleresultset(CWDatabaseConnection.executePreparedStatement(userrolebean.getGetUserRoleQuery()));
				
				JSONArray jsonarr=userrolebeanrs.assignUserRoleBeanRS(userrolebeanrs.getRoleresultset());
				
				System.out.println(jsonarr);
				
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
