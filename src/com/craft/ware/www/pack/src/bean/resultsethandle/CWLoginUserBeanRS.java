package com.craft.ware.www.pack.src.bean.resultsethandle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CWLoginUserBeanRS {

	private ResultSet resultset;
	private int userLoginCount;
	private String userRole;
	private String userName;
	
	JSONArray jsonarr=null;
	JSONObject jsonobj=null;

	public ResultSet getResultset() {
		return resultset;
	}

	public void setResultset(ResultSet resultset) {
		this.resultset = resultset;
	}
	
	
	public JSONArray assignLoginUserBeanRS(){
		
		jsonarr=new JSONArray();
		jsonobj=new JSONObject();
		List<JSONObject> jobjlist=new ArrayList<JSONObject>();
		
		ResultSet r=this.resultset;
		try {
			
			while(r.next()){
				
				if(r.getInt(1)!=0){
					setUserLoginCount(r.getInt(1));
				}
				if(r.getString(2)!=null){
					setUserName(r.getString(2));
				}
				if(r.getString(3)!=null){
					setUserRole(r.getString(3));
				}
				
				jsonobj.put("userLoginCount",getUserLoginCount());
				jsonobj.put("userName", getUserName());
				jsonobj.put("userRole",getUserRole());
				
				jobjlist.add(jsonobj);
				
				jsonobj=new JSONObject();
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonarr.put(jobjlist);
		
		return jsonarr;	
		
	}

	public int getUserLoginCount() {
		return userLoginCount;
	}

	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




	
	
}
