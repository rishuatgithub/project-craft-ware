package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.craft.ware.www.pack.src.bean.CWProductListBean;
import com.craft.ware.www.pack.src.bean.resultsethandle.CWProductListBeanRS;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;

/**
 * Servlet implementation class CWProductListServlet
 */
public class CWProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CWProductListBean prodlstobj=new CWProductListBean();
		CWProductListBeanRS prodlstrsobj=new CWProductListBeanRS();
		
		prodlstobj.setCategorychoosed(request.getParameter("productcategory"));
		
		try {
			boolean getConnect=CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
				
				prodlstobj.setGetproductlistquery();
				
				prodlstrsobj.setProdlistrs(CWDatabaseConnection.executePreparedStatement(prodlstobj.getGetproductlistquery()));
				
				JSONArray jsonarr=prodlstrsobj.fetchProductList();
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				
				response.getWriter().write(jsonarr.get(0).toString());
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			CWDatabaseConnection.closeCWdbConnection();
		}
		
		
	}

	
}
