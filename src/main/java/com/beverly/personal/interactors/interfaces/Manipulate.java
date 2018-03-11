package com.beverly.personal.interactors.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.TableWithId;
import com.beverly.personal.util.DBConnect;

public interface Manipulate {
	boolean updateById(DBConnect sqlOpt, List<InsertObject> data, TableWithId tblid) throws ClassNotFoundException, SQLException;
}
