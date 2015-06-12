package com.mju.frame;


import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public <T extends CModel> ArrayList<T> selectAll(CModel model, Class<T> returnType) throws InstantiationException, IllegalAccessException {
		ArrayList<T> data = new ArrayList<T>();

		// Build query
		String query = String.format("select * from %s", model.getTableName());
		HashMap<String, String> d = model.getData();
		if (d.keySet().size() > 0) {
			List<String> list = new ArrayList<String>();
			for (String key : d.keySet()) {
				list.add(String.format("%s='%s'", key, d.get(key)));
			}
			String where = String.join(" and ", list);		
			query += " where " + where;
		}
		try {
			ResultSet rs = statement.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				HashMap<String, String> class1 = new HashMap<String, String>(); 
				
				for(int i=1; i<rsmd.getColumnCount()+1; i++){
					class1.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
				}
				
				T mdl = returnType.newInstance();
				mdl.setData(class1);
				
				data.add(mdl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
	
	public boolean insert(CModel model) {
		// Build query
		HashMap<String, String> d = model.getData();
		String keys = String.join(",", d.keySet());
		List<String> list = new ArrayList<String>();
		for (String key : d.keySet()) {
			list.add("'"+d.get(key)+"'");
		}
		String values = String.join(",", list);
		String query =  String.format("insert into %s(%s) values (%s)", model.getTableName(), keys, values);

		try {
			statement.execute(query);
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(CModel model) {

		// Build query
		String query = String.format("delete from %s", model.getTableName());
		HashMap<String, String> d = model.getData();
		if (d.keySet().size() > 0) {
			List<String> list = new ArrayList<String>();
			for (String key : d.keySet()) {
				list.add(String.format("%s='%s'", key, d.get(key)));
			}
			String where = String.join(" and ", list);		
			query += " where " + where;
		}
		
		try {
			statement.execute(query);
		
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(String query) {
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
