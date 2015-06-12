package com.mju.model;

import java.util.HashMap;

import com.mju.frame.CModel;

public class ClassModel extends CModel {
	int id;
	String title;
	int prof_id;

	// Constructor
	public ClassModel () {
		id = 0;
		title = "";
		prof_id = 0;
	}
	
	// Getter/setter
	public void setID(int id){
		this.id = id;
	}
	

	public void setProfID(int prof_id){
		this.prof_id = prof_id;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	
	public int getID(){
		return this.id;
	}
	
	public int getProfID(){
		return this.prof_id;
	}
	
	// DAO communicate
	public HashMap<String, String> getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (id > 0) {
			map.put("id", String.valueOf(id));
		}
		
		if (!title.equals("")) {
			map.put("title", title);
		}
		
		if (prof_id > 0) {
			map.put("prof_id", String.valueOf(prof_id));
		}
		
		return map;
	}
	
	public void setData(HashMap<String, String> data) {
		if (data.get("id") != null) {
			id = Integer.parseInt(data.get("id"));
		}
		if (data.get("title") != null) {
			title = data.get("title");
		}
		if (data.get("prof_id") != null) {
			prof_id = Integer.parseInt(data.get("prof_id"));
		}
	}
	
	public String getTableName() {
		return "classes";
	}
}
