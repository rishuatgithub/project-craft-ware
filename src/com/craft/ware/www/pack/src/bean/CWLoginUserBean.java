package com.craft.ware.www.pack.src.bean;

/**
 * This is a bean class to handle the Login Credentials
 * @author Rishu
 *
 */
public class CWLoginUserBean {
	
	private String userID;
	private String userPasscode;	
	private String getUserLoginQuery;
	
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
		
		String getUserLoginQuery="select * from craftware.cw_usercredential_check('"+getUserID+"','"+getUserPass+"')";
		
		this.getUserLoginQuery = getUserLoginQuery;
	}

}
