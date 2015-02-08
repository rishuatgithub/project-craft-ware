package com.craft.ware.www.pack.src.bean;

public class CWProductListBean {

	private String categorychoosed;
	private String getproductlistquery;
	
	public String getCategorychoosed() {
		return categorychoosed;
	}

	public void setCategorychoosed(String categorychoosed) {
		this.categorychoosed = categorychoosed;
	}

	public String getGetproductlistquery() {
		return getproductlistquery;
	}

	public void setGetproductlistquery(String category) {
		
		String getproductlistquery="select * from craftware.cw_productlist('"+category+"')";
		this.getproductlistquery = getproductlistquery;
	}
	
	
	
}

