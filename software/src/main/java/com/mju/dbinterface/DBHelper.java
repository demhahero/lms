package com.mju.dbinterface;

import java.util.ArrayList;
import java.util.HashMap;

import com.mju.dao.DAO;
import com.mju.model.ClassModel;
import com.mju.model.UserModel;

public class DBHelper {
	public DAO dao;
	
	public DBHelper(){
		try {
			dao = new DAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserModel login(UserModel am) {
		UserModel um = new UserModel();
		ArrayList<HashMap<String, String>> users;
		users = dao.select("select * from users where `username`='"+am.getUsername()+"' and `password`='"+am.getPassword()+"'");
		if(users != null){
			um.setRank(Integer.parseInt(users.get(0).get("rank")));
			um.setID(Integer.parseInt(users.get(0).get("id")));
			if (users.get(0) != null){
				return um;
			}
			else
				return null;
		}
		else return null;
	}
	public boolean createClass(String title, int prof_id) {
		// TODO Auto-generated method stub
		boolean res = dao.insert("insert into `classes` (`title`, `prof_id`) values ('"+title+"','"+prof_id+"')");
		
		return res;
	}
	public boolean registerclass(String class_id, int student_id) {
		// TODO Auto-generated method stub
		
		boolean res = dao.insert("insert into `student_class` (`student_id`, `class_id`) values ('"+student_id+"','"+class_id+"')");
		
		return res;
	}
	public ClassModel[] getAllClasses() {
		// TODO Auto-generated method stub
		ClassModel[] cma = new ClassModel[10];
		ArrayList<HashMap<String, String>> classes;
		classes = dao.select("select * from `classes`");
		
		int i=0;
		for(HashMap<String, String> cs : classes)
		{
			
			cma[i] = new ClassModel();
			cma[i].setID(Integer.parseInt(cs.get("id")));
			cma[i].setTitle(cs.get("title"));
			i++;
		}
		return cma;
	}
	public ClassModel[] getAllUserClasses(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<HashMap<String, String>> student_class;
		student_class = dao.select("select * from `student_class` where `student_id`='"+id+"'");
		
		ArrayList<HashMap<String, String>> cls;
		
		ClassModel[] cma = new ClassModel[student_class.size()];
		int i=0;
		for(HashMap<String, String> sc : student_class)
		{
			cma[i] = new ClassModel();
			cls = dao.select("select * from `classes` where `id`='"+sc.get("class_id")+"'");
			cma[i].setID(Integer.parseInt(cls.get(0).get("id")));
			cma[i].setTitle(cls.get(0).get("title"));
			i++;
		}
		return cma;
	}
	
	public boolean unregisterclass(String class_id, int student_id) {
		// TODO Auto-generated method stub
		
		boolean res = dao.delete("delete from `student_class` where `student_id`='"+student_id+"' and `class_id`='"+class_id+"'");
		
		return res;
	}
	public ClassModel[] getAllProfessorClasses(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<HashMap<String, String>> classes;
		classes = dao.select("select * from `classes` where `prof_id`='"+id+"'");
		ClassModel[] cma = new ClassModel[classes.size()];
		ArrayList<HashMap<String, String>> cls;
		
		int i=0;
		for(HashMap<String, String> sc : classes)
		{
			cma[i] = new ClassModel();
	
			cma[i].setID(Integer.parseInt(sc.get("id")));
			cma[i].setTitle(sc.get("title"));
			cma[0].setProfID(2);
			i++;
		}
		return cma;
	}
	public boolean removeClass(String id) {
		boolean res = dao.delete("delete from `classes` where `id`='"+id+"'");
		
		return res;
	}
}
