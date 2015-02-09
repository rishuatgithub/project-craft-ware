package com.craft.ware.www.pack.src.bean.resultsethandle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CWSignUpUserBeanRS {
	
	private ResultSet signupresultset;
	private int signupcount;

	JSONArray jsonarr=null;
	JSONObject jsonobj=null;

	public ResultSet getSignupresultset() {
		return signupresultset;
	}

	public void setSignupresultset(ResultSet signupresultset) {
		this.signupresultset = signupresultset;
	}
	
	
	
	public JSONArray fetchsignup(){
		
		jsonarr=new JSONArray();
		jsonobj=new JSONObject();
		List<JSONObject> jobjlist=new ArrayList<JSONObject>();
		ResultSet r=this.signupresultset;
		
		try {
			while(r.next()){
				
				if(r.getInt(1)!=0){
					setSignupcount(r.getInt(1));
				}			
				
				jsonobj.put("signupcount", getSignupcount());
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

	public int getSignupcount() {
		return signupcount;
	}

	public void setSignupcount(int signupcount) {
		this.signupcount = signupcount;
	}
	
	
	

}
