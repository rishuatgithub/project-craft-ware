package com.craft.ware.www.pack.src.bean;

public class CWSignUpUserBean {
	
	private String newUserName;
	private String newUserEmail;
	private String newUserPasswd;
	
	
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public String getNewUserEmail() {
		return newUserEmail;
	}
	public void setNewUserEmail(String newUserEmail) {
		this.newUserEmail = newUserEmail;
	}
	public String getNewUserPasswd() {
		return newUserPasswd;
	}
	public void setNewUserPasswd(String newUserPasswd) {
		this.newUserPasswd = newUserPasswd;
	}
	
	

	/*
	 * Checking the UserName
	 */
	private String getUserNameCheckQuery;
	
	public String getGetUserNameCheckQuery() {
		return getUserNameCheckQuery;
	}
	public void setGetUserNameCheckQuery() {
		
		String getUserNameCheckQuery="select * from craftware.cw_nwusernamecheck('"+this.newUserName+"')";
		this.getUserNameCheckQuery = getUserNameCheckQuery;
	}
	
	/*
	 * Fetching the New User Insert Query
	 */
	private String getNewUserSignUpQuery;
	
	public String getGetNewUserSignUpQuery() {
		return getNewUserSignUpQuery;
	}
	public void setGetNewUserSignUpQuery() {
		
		String getNewUserSignUpQuery="select * from craftware.cw_nwusersignup('"+this.newUserName+"','"+this.newUserEmail+"','"+this.newUserPasswd+"')";
		
		this.getNewUserSignUpQuery = getNewUserSignUpQuery;
	}

}
