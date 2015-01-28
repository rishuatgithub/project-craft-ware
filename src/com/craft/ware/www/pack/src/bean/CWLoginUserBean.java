package com.craft.ware.www.pack.src.bean;

public class CWLoginUserBean {
	
	private String userID;
	private String userPasscode;
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
	
	
	private String generateUserLoginQuery;
	
	public String getGenerateUserLoginQuery() {
		return generateUserLoginQuery;
	}
	public void setGenerateUserLoginQuery(String generateUserLoginQuery) {
		this.generateUserLoginQuery = generateUserLoginQuery;
	}

}
