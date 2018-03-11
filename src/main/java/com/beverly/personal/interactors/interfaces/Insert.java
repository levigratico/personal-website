package com.beverly.personal.interactors.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.model.InsertObject;
import com.beverly.personal.util.DBConnect;

public interface Insert {
	
	boolean insertData(DBConnect sqlOpt, List<InsertObject> obj, String table) throws ClassNotFoundException, SQLException;
	
}
