package com.beverly.personal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.interactors.interfaces.Insert;
import com.beverly.personal.interactors.interfaces.Manipulate;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.TableWithId;
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
	
	public static Object findByWhere(Retrieve retrieve, List<QueryObject> where) {
		DBConnect db = new DBConnect();
		try {
			return retrieve.findByWhere(db, where);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object findById(Retrieve retrieve, int id) {
		DBConnect db = new DBConnect();
		try {
			return retrieve.findById(db, id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean insertData(Insert insert, List<InsertObject> obj, String table) {
		DBConnect db = new DBConnect();
		try {
			return insert.insertData(db, obj, table);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int selectLastIdInserted(String table) {
		DBConnect db = new DBConnect();
		try {
			db.connect();
			ResultSet rs = db.getStatement().executeQuery(String.format("SELECT id FROM %s ORDER BY id DESC", table));
			rs.next();
			int ret = rs.getInt(1);
			db.closeConnection();
			return ret;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public static boolean updateById(Manipulate manipulate, List<InsertObject> liInsertObjects, TableWithId tableWithId) {
		DBConnect db = new DBConnect();
		try {
			return manipulate.updateById(db, liInsertObjects, tableWithId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
