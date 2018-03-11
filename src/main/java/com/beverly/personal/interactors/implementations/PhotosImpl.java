package com.beverly.personal.interactors.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.common.ConstString;
import com.beverly.personal.interactors.interfaces.Insert;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.model.ServicesCollection;
import com.beverly.personal.model.ServicesModel;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.QueryBuilder;
import com.beverly.personal.util.SQLBuilder;

public class PhotosImpl implements Retrieve, Insert {

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
		sqlOpt.connect();
		SQLBuilder builder = buildQuery(where);
		PreparedStatement preparedStatement = QueryBuilder.setPreparedQuery(sqlOpt.getPrepareStatement(builder.build()),
				builder.getValue());
		ResultSet result = preparedStatement.executeQuery();
		CommonListModel<ServicesCollection> model = createServiceModelCollectionModel(result);
		sqlOpt.closeConnection();
		return model;
	}
	
	private CommonListModel<ServicesModel> createModel(ResultSet result) throws SQLException {
		CommonListModel<ServicesModel> common = new CommonListModel<>();
		while(result.next()) {
			ServicesModel model = new ServicesModel();
			model.setId(result.getInt("id"));
			model.setTitle(result.getString("title"));
			model.setDescription(result.getString("description"));
			model.setPrice(result.getDouble("price"));
			model.setPicture(String.format("%s/resources/images/%s", ConstString.BASEURL.getString(), result.getString("picture")));
			common.setListOfModel(model);
		}
		return common;
	}
	
	private CommonListModel<ServicesCollection> createServiceModelCollectionModel(ResultSet result) throws SQLException {
		CommonListModel<ServicesCollection> common = new CommonListModel<>();
		while(result.next()) {
			ServicesCollection model = new ServicesCollection();
			model.setCaption(result.getString("caption"));
			model.setId(result.getInt("id"));
			model.setPicture(String.format("%s%s", ConstString.IMAGE_PATH.getString(), result.getString("picture")));
			model.setServiceTitle(result.getString("title"));
			model.setServiceDescription(result.getString("description"));
			common.setListOfModel(model);
		}
		return common;
	}
	
	private SQLBuilder buildQuery(List<QueryObject> obj) {
		SQLBuilder builder = new SQLBuilder().customQuery("SELECT a.*, b.title, b.description FROM photos_tbl a INNER JOIN services_tbl b ON a.service_id = b.id ").where(obj);
		return builder;
	}

	@Override
	public boolean insertData(DBConnect sqlOpt, List<InsertObject> obj, String table) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		SQLBuilder builder = new SQLBuilder().insert(table);
		PreparedStatement preparedStatement = sqlOpt.getPrepareStatement(builder.buildInsert(obj));
		int rows = QueryBuilder.setPreparedQuery(preparedStatement, builder.getValue()).executeUpdate();
		sqlOpt.closeConnection();
		
		return (rows > 0);
	}
	
	

}
