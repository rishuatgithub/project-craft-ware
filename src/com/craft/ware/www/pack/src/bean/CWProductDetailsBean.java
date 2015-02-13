package com.craft.ware.www.pack.src.bean;

public class CWProductDetailsBean {
	
	private String pid;
	private String productDetailsQuery;
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getProductDetailsQuery() {
		return productDetailsQuery;
	}

	public void setProductDetailsQuery() {
		
		String productDetailsQuery="select * from craftware.cw_productdetails('"+this.pid+"')";
		this.productDetailsQuery = productDetailsQuery;
	}

}
