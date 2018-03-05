package com.beverly.personal.interactors.interfaces;

import java.sql.SQLException;
import java.util.Map;

import com.beverly.personal.util.DBConnect;

public interface Retrieve {
	Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException;
	Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException;
	Object findByWhere(DBConnect sqlOpt, Map<String, Object> where) throws ClassNotFoundException, SQLException;
}
