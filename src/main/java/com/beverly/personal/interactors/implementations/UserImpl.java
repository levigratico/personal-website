package com.beverly.personal.interactors.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.UserModel;
import com.beverly.personal.model.UserQueryPreparation;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.QueryBuilder;

public class UserImpl implements Retrieve {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public Object findByWhere(DBConnect sqlOpt, Map<String, Object> where) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		UserQueryPreparation data = queryBuild(where);
		PreparedStatement preparedStatement = QueryBuilder.setPreparedQuery(sqlOpt.getPrepareStatement(data.getQuery()), data.getData());
		ResultSet result = preparedStatement.executeQuery();
		UserModel model = new UserModel();
		int counter = 0;
		while(result.next()) {
			model.setUsername(result.getString("username"));
			model.setPassword(result.getString("password"));
			counter++;
		}
		sqlOpt.closeConnection();
		
		if(counter != 0) {
		  return model;
		}
		
		return null;
	}
	
	private UserQueryPreparation queryBuild(Map<String, Object> where) {
		String sqlSelect = "SELECT * FROM user_tbl WHERE ";
		return QueryBuilder.build(sqlSelect, where, " AND");
	}
	

}
