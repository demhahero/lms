package com.mju.software;

import java.util.HashMap;

import com.mju.dao.DAO;

import com.mju.dbinterface.DBHelper;
import com.mju.model.UserModel;


public class ControllerClass {
	public DBHelper dbhelper;
	
	public ControllerClass(){
		dbhelper = new DBHelper();
	}
	

}
