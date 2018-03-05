package com.beverly.personal.dao;

import java.sql.SQLException;
import java.util.Map;

import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.util.DBConnect;

public class DatabaseOperationDao {
	
	public static Object findAll(Retrieve retrieve) {
		DBConnect db = new DBConnect();
		try {
			return retrieve.findAll(db);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object findByWhere(Retrieve retrieve, Map<String, Object> where) {
		DBConnect db = new DBConnect();
		try {
			return retrieve.findByWhere(db, where);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
