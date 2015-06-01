package com.mju.model;

public class ClassModel {
	int id;
	String title;
	int prof_id;


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
}
