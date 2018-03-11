package com.beverly.personal.interactors.implementations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beverly.personal.common.CommonListModel;
import com.beverly.personal.interactors.interfaces.Retrieve;
import com.beverly.personal.model.OrdersModel;
import com.beverly.personal.model.QueryObject;
import com.beverly.personal.util.DBConnect;
import com.beverly.personal.util.SQLBuilder;

public class OrdersImpl implements Retrieve {

	@Override
	public Object findAll(DBConnect sqlOpt) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		String query = retrivedOrder();
	 	ResultSet rs = sqlOpt.getStatement().executeQuery(query);
	 	CommonListModel<OrdersModel> listOfModel = createMode(rs);
	 	sqlOpt.closeConnection();
		return listOfModel;
	}

	@Override
	public Object findById(DBConnect sqlOpt, int id) throws ClassNotFoundException, SQLException {
		sqlOpt.connect();
		String query = retrivedOrder(id);
		ResultSet rs = sqlOpt.getStatement().executeQuery(query);
	 	OrdersModel listOfModel = createOrdersModel(rs);
	 	sqlOpt.closeConnection();
		return listOfModel;
	}

	@Override
	public Object findByWhere(DBConnect sqlOpt, List<QueryObject> where) throws ClassNotFoundException, SQLException {
		
		return null;
	}
	
	private String retrivedOrder() {
		SQLBuilder builder = new SQLBuilder();
		return builder.customQuery("SELECT a.*, b.title FROM `orders_tbl` a INNER JOIN `services_tbl` b ON a.service_id = b.id").getQuery();
	}
	
	private String retrivedOrder(int id) {
		SQLBuilder builder = new SQLBuilder();
		return builder.customQuery(String.format("SELECT a.*, b.title, b.price FROM `orders_tbl` a INNER JOIN `services_tbl` b ON a.service_id = b.id WHERE a.id = %d", id)).getQuery();
	}
	
	private CommonListModel<OrdersModel> createMode(ResultSet rs) throws SQLException {
		CommonListModel<OrdersModel> model = new CommonListModel<>();
		while(rs.next()) {
			OrdersModel orders = new OrdersModel();
			orders.setId(rs.getInt("id"));
			orders.setName(rs.getString("name"));
			orders.setAddress(rs.getString("address"));
			orders.setEmail(rs.getString("email"));
			orders.setContact(rs.getString("contact"));
			orders.setStatus((rs.getInt("status") == 1 ? "paid" : "not paid"));
			orders.setDate(rs.getString("date"));
			orders.setTitle(rs.getString("title"));
			model.setListOfModel(orders);
		}
		return model;
	}
	
	private OrdersModel createOrdersModel(ResultSet rs) throws SQLException {
		OrdersModel order = new OrdersModel();
		while(rs.next()) {
			order.setId(rs.getInt("id"));
			order.setName(rs.getString("name"));
			order.setAddress(rs.getString("address"));
			order.setEmail(rs.getString("email"));
			order.setContact(rs.getString("contact"));
			order.setStatus((rs.getInt("status") == 1 ? "paid" : "not paid"));
			order.setDate(rs.getString("date"));
			order.setTitle(rs.getString("title"));
			order.setPrice(rs.getDouble("price"));
		}
		return order;
	}

}
