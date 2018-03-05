package com.beverly.personal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.beverly.personal.common.ConstString;
import java.sql.PreparedStatement;

public class DBConnect {
	
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName(ConstString.DRIVER.getString());
		connection = DriverManager.getConnection(ConstString.DBPATH.getString(), ConstString.USERNAME.getString(), ConstString.PASSWORD.getString());
	}

	
	public void closeConnection() throws SQLException {
		connection.close();
		closeStatement();
		closePreparedStatement();
	}
	
	public PreparedStatement getPrepareStatement(String query) throws SQLException {
		preparedStatement = connection.prepareStatement(query);
		return preparedStatement;
	}
	
	public Connection getConnection() {
		return connection;
	}


	public Statement getStatement() throws SQLException {
		statement = connection.createStatement();
		return statement;
	}
	
	private void closeStatement() throws SQLException {
		if(statement != null) {
			statement.close();
		}
	}
	
	private void closePreparedStatement() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	}
	
}
