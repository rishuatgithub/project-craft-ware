package com.craft.ware.www.pack.src.bean;

public class CWLoginUserBean {
	
	private String userID;
	private String userPasscode;
	private int userLoginCount;
	
	
	public String getUserPasscode() {
		return userPasscode;
	}
	public void setUserPasscode(String userPasscode) {
		this.userPasscode = userPasscode;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getGetUserLoginQuery() {
		return getUserLoginQuery;
	}
	public void setGetUserLoginQuery(String getUserID, String getUserPass) {
		
		String getUserLoginQuery="select craftware.cw_usercredential_check('"+getUserID+"','"+getUserPass+"')";
		
		this.getUserLoginQuery = getUserLoginQuery;
	}

	public int getUserLoginCount() {
		return userLoginCount;
	}
	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	private String getUserLoginQuery;

}
