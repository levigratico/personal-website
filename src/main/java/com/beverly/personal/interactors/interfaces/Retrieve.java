package com.beverly.personal.interactors.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.model.QueryObject;
import com.beverly.personal.util.DBConnect;

public interface Retrieve {
	Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException;
	Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException;
	Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException;
}
