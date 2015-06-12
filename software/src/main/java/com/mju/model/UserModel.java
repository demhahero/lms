package com.mju.model;

import java.util.HashMap;

import com.mju.frame.CModel;

public class UserModel extends CModel {
	int id;
	String username;
	String password;
	int rank;
	
	// Constructor
	public UserModel(){
		id = 0;
		username = "";
		password = "";
		rank = 0;
	}
	
	// Getter/setter
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}

	public int getRank(){
		return this.rank;
	}
	
	public int getID(){
		return this.id;
	}
	
	// DAO communicate
	public HashMap<String, String> getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (id > 0) {
			map.put("id", String.valueOf(id));
		}
		
		if (!username.equals("")) {
			map.put("username", username);
		}
		
		if (!password.equals("")) {
			map.put("password", password);
		}
		
		if (rank > 0) {
			map.put("id", String.valueOf(rank));
		}
		
		return map;
	}
	
	public void setData(HashMap<String, String> data) {
		if (data.get("id") != null) {
			id = Integer.parseInt(data.get("id"));
		}
		if (data.get("username") != null) {
			username = data.get("username");
		}
		if (data.get("password") != null) {
			password = data.get("password");
		}
		if (data.get("rank") != null) {
			rank = Integer.parseInt(data.get("rank"));
		}
	}
	
	public String getTableName() {
		return "users";
	}
}
