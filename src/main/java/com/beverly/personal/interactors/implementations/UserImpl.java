package com.beverly.personal.interactors.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.UserModel;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.QueryBuilder;
import com.beverly.personal.util.SQLBuilder;

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
	public Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		SQLBuilder builder = buildQuery(where);
		PreparedStatement preparedStatement = QueryBuilder.setPreparedQuery(sqlOpt.getPrepareStatement(builder.build()),
				builder.getValue());
		ResultSet result = preparedStatement.executeQuery();
		UserModel model = new UserModel();
		int counter = 0;
		while (result.next()) {
			model.setUsername(result.getString("username"));
			model.setPassword(result.getString("password"));
			counter++;
		}
		sqlOpt.closeConnection();

		if (counter != 0) {
			return model;
		}

		return null;
	}
	
	private SQLBuilder buildQuery(List<QueryObject> obj) {
		SQLBuilder builder = new SQLBuilder().selectAll().from("user_tbl").where(obj);
		return builder;
	}

}
