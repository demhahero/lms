package com.mju.model;

public class UserModel {
	int id;
	String username;
	String password;
	int rank;
	
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
}
