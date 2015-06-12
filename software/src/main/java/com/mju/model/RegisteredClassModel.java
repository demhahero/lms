package com.mju.model;

import java.util.HashMap;

import com.mju.frame.CModel;

public class RegisteredClassModel extends CModel {

	private int student_id;
	private int class_id;
	
	public RegisteredClassModel() {
		student_id = 0;
		class_id = 0;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
	// DAO communicate
	public HashMap<String, String> getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (student_id > 0) {
			map.put("student_id", String.valueOf(student_id));
		}
		if (class_id > 0) {
			map.put("class_id", String.valueOf(class_id));
		}
		
		return map;
	}
	
	public void setData(HashMap<String, String> data) {
		if (data.get("student_id") != null) {
			student_id = Integer.parseInt(data.get("student_id"));
		}
		if (data.get("class_id") != null) {
			class_id = Integer.parseInt(data.get("class_id"));
		}
	}
	
	public String getTableName() {
		return "student_class";
	}

}
