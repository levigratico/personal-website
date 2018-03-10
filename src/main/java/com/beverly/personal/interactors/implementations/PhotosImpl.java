package com.beverly.personal.interactors.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.ConstString;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.ServicesModel;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.SQLBuilder;

public class PhotosImpl implements Retrieve {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		SQLBuilder builder = new SQLBuilder().selectAll().from("services_tbl");
		String query = builder.build();
		ResultSet result = sqlOpt.getStatement().executeQuery(query);
		CommonListModel<ServicesModel> common = createModel(result);
		sqlOpt.closeConnection();
		return common;
	}

	@Override
	public Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CommonListModel<ServicesModel> createModel(ResultSet result) throws SQLException {
		CommonListModel<ServicesModel> common = new CommonListModel<>();
		while(result.next()) {
			ServicesModel model = new ServicesModel();
			model.setId(result.getInt("id"));
			model.setTitle(result.getString("title"));
			model.setDescription(result.getString("description"));
			model.setPicture(String.format("%s/resources/images/%s", ConstString.BASEURL.getString(), result.getString("picture")));
			common.setListOfModel(model);
		}
		return common;
	}

}
