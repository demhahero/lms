package com.mju.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class DAO {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/lms";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public String connectDB() throws Exception {

		try {
	

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connect = DriverManager.getConnection(DB_URL, USER, PASS);

			statement = connect.createStatement();
			String sql;
			sql = "SELECT * from `users`";
			ResultSet rs = statement.executeQuery(sql);

		
			
			if(rs != null)
				return "hello1";

		} catch (Exception e) {
			return e.toString();
		}
		return "hello3";

	}


	public DAO() throws Exception {

		try {
	

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			connect = DriverManager.getConnection(DB_URL, USER, PASS);

			statement = connect.createStatement();
			String sql;
			sql = "SELECT * from `users`";
			ResultSet rs = statement.executeQuery(sql);

		
			
		

		} catch (Exception e) {
	
		}
	

	}
	

	
	public ArrayList<HashMap<String, String>> select(String query) {
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		
		
		
		try {
			ResultSet rs = statement.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				HashMap<String, String> class1 = new HashMap<String, String>(); 
				
				for(int i=1; i<rsmd.getColumnCount()+1; i++){
					class1.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
				}
				data.add(class1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public boolean insert(String query) {
		try {
			statement.execute(query);
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(String query) {
		try {
			statement.execute(query);
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
