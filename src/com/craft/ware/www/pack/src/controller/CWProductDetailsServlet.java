package com.craft.ware.www.pack.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.craft.ware.www.pack.src.bean.CWProductDetailsBean;
import com.craft.ware.www.pack.src.bean.resultsethandle.CWProductDetailsBeanRS;
import com.craft.ware.www.pack.src.database.CWDatabaseConnection;

/**
 * Servlet implementation class CWProductDetailsServlet
 */
public class CWProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CWProductDetailsBean pdetailbean=new CWProductDetailsBean();
		CWProductDetailsBeanRS pdetailbeanRS=new CWProductDetailsBeanRS();
		
		pdetailbean.setPid(request.getParameter("productid"));
		
		try {
			boolean getConnect = CWDatabaseConnection.getCWdbConnection();
			
			if(getConnect){
				
				pdetailbean.setProductDetailsQuery();
				
				pdetailbeanRS.setRs(CWDatabaseConnection.executePreparedStatement(pdetailbean.getProductDetailsQuery()));
				
				JSONArray jsonarr=pdetailbeanRS.fetchProductDetails();
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				
				response.getWriter().write(jsonarr.get(0).toString());
				
				/*request.setAttribute("pdetails", jsonarr.get(0).toString());
				ServletContext sc=getServletContext();
				RequestDispatcher rd=sc.getRequestDispatcher("/productdetails.jsp");
				rd.forward(request, response);*/
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CWDatabaseConnection.closeCWdbConnection();
		}
		
		
				
	}

}
