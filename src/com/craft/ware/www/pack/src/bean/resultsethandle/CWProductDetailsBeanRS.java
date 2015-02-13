package com.craft.ware.www.pack.src.bean.resultsethandle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CWProductDetailsBeanRS {
	
	private ResultSet rs;
	private String product_d_name;
	private String product_d_image;
	private String product_d_rating;
	private String product_d_descr;
	private String product_d_price;
	private String product_d_currtype;
	private String product_d_sellerid;
	private String product_d_sellername;
	private String product_d_sellerregion;
	private String product_d_selleremail;
	private String product_d_sellercontact;
	
	JSONArray jsonarr=null;
	JSONObject jsonobj=null;
		
	
	public JSONArray fetchProductDetails(){
		jsonarr=new JSONArray();
		jsonobj=new JSONObject();
		List<JSONObject> jobjlist=new ArrayList<JSONObject>();
		
		ResultSet r=this.rs;
		
		try {
			while(r.next()){
				
				if(r.getString(1)!=null){
					setProduct_d_name(r.getString(1));
				}
				if(r.getString(2)!=null){
					setProduct_d_image(r.getString(2));
				}
				if(r.getString(3)!=null){
					setProduct_d_rating(r.getString(3));
				}
				if(r.getString(4)!=null){
					setProduct_d_descr(r.getString(4));
				}
				if(r.getString(5)!=null){
					setProduct_d_price(r.getString(5));
				}
				if(r.getString(6)!=null){
					setProduct_d_currtype(r.getString(6));
				}
				if(r.getString(7)!=null){
					setProduct_d_sellerid(r.getString(7));
				}
				if(r.getString(8)!=null){
					setProduct_d_sellername(r.getString(8));
				}
				if(r.getString(9)!=null){
					setProduct_d_sellerregion(r.getString(9));
				}
				if(r.getString(10)!=null){
					setProduct_d_selleremail(r.getString(10));
				}
				if(r.getString(11)!=null){
					setProduct_d_sellercontact(r.getString(11));
				}
				
				jsonobj.put("product_name", getProduct_d_name());
				jsonobj.put("product_image", getProduct_d_image());
				jsonobj.put("product_rating", getProduct_d_rating());
				jsonobj.put("product_descr", getProduct_d_descr());
				jsonobj.put("product_price", getProduct_d_price());
				jsonobj.put("product_currtype", getProduct_d_currtype());
				jsonobj.put("product_sellerid", getProduct_d_sellerid());
				jsonobj.put("product_sellername", getProduct_d_sellername());
				jsonobj.put("product_sellerregion", getProduct_d_sellerregion());
				jsonobj.put("product_selleremail", getProduct_d_selleremail());
				jsonobj.put("product_sellercontact", getProduct_d_sellercontact());
				
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
		
	
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getProduct_d_name() {
		return product_d_name;
	}

	public void setProduct_d_name(String product_d_name) {
		this.product_d_name = product_d_name;
	}

	public String getProduct_d_image() {
		return product_d_image;
	}

	public void setProduct_d_image(String product_d_image) {
		this.product_d_image = product_d_image;
	}

	public String getProduct_d_rating() {
		return product_d_rating;
	}

	public void setProduct_d_rating(String product_d_rating) {
		this.product_d_rating = product_d_rating;
	}

	public String getProduct_d_descr() {
		return product_d_descr;
	}

	public void setProduct_d_descr(String product_d_descr) {
		this.product_d_descr = product_d_descr;
	}

	public String getProduct_d_price() {
		return product_d_price;
	}

	public void setProduct_d_price(String product_d_price) {
		this.product_d_price = product_d_price;
	}

	public String getProduct_d_currtype() {
		return product_d_currtype;
	}

	public void setProduct_d_currtype(String product_d_currtype) {
		this.product_d_currtype = product_d_currtype;
	}

	public String getProduct_d_sellerid() {
		return product_d_sellerid;
	}

	public void setProduct_d_sellerid(String product_d_sellerid) {
		this.product_d_sellerid = product_d_sellerid;
	}

	public String getProduct_d_sellername() {
		return product_d_sellername;
	}

	public void setProduct_d_sellername(String product_d_sellername) {
		this.product_d_sellername = product_d_sellername;
	}

	public String getProduct_d_sellerregion() {
		return product_d_sellerregion;
	}

	public void setProduct_d_sellerregion(String product_d_sellerregion) {
		this.product_d_sellerregion = product_d_sellerregion;
	}

	public String getProduct_d_selleremail() {
		return product_d_selleremail;
	}

	public void setProduct_d_selleremail(String product_d_selleremail) {
		this.product_d_selleremail = product_d_selleremail;
	}

	public String getProduct_d_sellercontact() {
		return product_d_sellercontact;
	}

	public void setProduct_d_sellercontact(String product_d_sellercontact) {
		this.product_d_sellercontact = product_d_sellercontact;
	}

	
	
}
