package com.craft.ware.www.pack.src.bean;

public class CWUserRoleBean {

	private String userrole;
	private String getUserRoleQuery;
	
	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getGetUserRoleQuery() {
		return getUserRoleQuery;
	}

	public void setGetUserRoleQuery() {
		
		String getUserRoleQuery="select * from  craftware.cw_userrolelist('"+this.userrole+"')";
		
		this.getUserRoleQuery = getUserRoleQuery;
	}
	
	
	
}
