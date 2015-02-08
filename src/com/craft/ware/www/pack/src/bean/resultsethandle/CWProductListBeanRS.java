package com.craft.ware.www.pack.src.bean.resultsethandle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CWProductListBeanRS {
	
	private ResultSet prodlistrs;
	private String productid;
	private String productname;
	private String productprice;
	private String productcurrencytype;
	private String productimagelink;
	
	JSONArray jsonarr=null;
	JSONObject jsonobj=null;
	
	public JSONArray fetchProductList(ResultSet r){
		
		jsonarr=new JSONArray();
		jsonobj=new JSONObject();
		List<JSONObject> jobjlist=new ArrayList<JSONObject>();
		
		try {
			while(r.next()){
				
				if(r.getString(1)!=null){
					setProductid(r.getString(1));
				}
				if(r.getString(2)!=null){
					setProductname(r.getString(2));
				}
				if(r.getString(3)!=null){
					setProductprice(r.getString(3));
				}
				if(r.getString(4)!=null){
					setProductcurrencytype(r.getString(4));
				}
				if(r.getString(5)!=null){
					setProductimagelink(r.getString(5));
				}
				
				jsonobj.put("productid", getProductid());
				jsonobj.put("productname", getProductname());
				jsonobj.put("productprice", getProductprice());
				jsonobj.put("productcurrtype", getProductcurrencytype());
				jsonobj.put("productimglink", getProductimagelink());
				
				jobjlist.add(jsonobj);
				
				jsonobj=new JSONObject();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonarr.put(jobjlist);
		
		return jsonarr;
	}
	
	
	
	
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getProductcurrencytype() {
		return productcurrencytype;
	}

	public void setProductcurrencytype(String productcurrencytype) {
		this.productcurrencytype = productcurrencytype;
	}

	public String getProductimagelink() {
		return productimagelink;
	}

	public void setProductimagelink(String productimagelink) {
		this.productimagelink = productimagelink;
	}

	public ResultSet getProdlistrs() {
		return prodlistrs;
	}

	public void setProdlistrs(ResultSet prodlistrs) {
		this.prodlistrs = prodlistrs;
	}
	
	
	

}
