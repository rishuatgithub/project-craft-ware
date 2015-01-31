package com.craft.ware.www.pack.src.bean.resultsethandle;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CWUserRoleBeanRS {
	
	public String getTabenable() {
		return tabenable;
	}
	public void setTabenable(String tabenable) {
		this.tabenable = tabenable;
	}
	public String getSpanid() {
		return spanid;
	}
	public void setSpanid(String spanid) {
		this.spanid = spanid;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getHyperlink() {
		return hyperlink;
	}
	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	
	private String tabenable;
	private String spanid;
	private String classid;
	private String hyperlink;
	private ResultSet roleresultset;
	
	JSONArray jsonarr=null;
	JSONObject jsonobj=null;
	JSONObject jsonobjappend=null;
	
	public JSONArray assignUserRoleBeanRS(ResultSet r){
		
		jsonarr=new JSONArray();
		jsonobj=new JSONObject();
		jsonobjappend=new JSONObject();
		
		try {
			while(r.next()){
				
				if(r.getString(1)!=null){
					setTabenable(r.getString(1));
					
				}
				if(r.getString(2)!=null){
					setSpanid(r.getString(2));
				}
				if(r.getString(3)!=null){
					setClassid(r.getString(3));
				}
				if(r.getString(4)!=null){
					setHyperlink(r.getString(4));
				}
				
				/*jsonobj.put("tabenable", getTabenable());
				jsonobj.put("spanid", getSpanid());
				jsonobj.put("classid", getClassid());
				jsonobj.put("hyperlink",getHyperlink());*/
				

				jsonobj.accumulate("tabenable", getTabenable());
				jsonobj.accumulate("spanid", getSpanid());
				jsonobj.accumulate("classid", getClassid());
				jsonobj.accumulate("hyperlink",getHyperlink());
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsonarr.put(jsonobj);
		
		return jsonarr;	
		
	}
	public ResultSet getRoleresultset() {
		return roleresultset;
	}
	public void setRoleresultset(ResultSet roleresultset) {
		this.roleresultset = roleresultset;
	}
	

	

}