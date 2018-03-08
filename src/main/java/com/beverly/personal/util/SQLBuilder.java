package com.beverly.personal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import com.beverly.personal.common.BoleanOperators;
import com.beverly.personal.common.Operations;
import com.beverly.personal.model.InsertObject;
import com.beverly.personal.model.QueryObject;

public class SQLBuilder {

	List<QueryObject> data = new ArrayList<>();
	List<Object> value = new ArrayList<>();
	List<InsertObject> updateData = new ArrayList();

	private List<String> tables = new ArrayList<>();
	private List<String> columns = new ArrayList<>();

	private String query = "";

	public SQLBuilder selectAll() {
		this.query = "SELECT * ";
		return this;
	}

	public SQLBuilder insert(String table) {
		this.query = String.format("INSERT INTO %s", table);
		return this;
	}
	
	public SQLBuilder update(String table) {
		this.query = String.format("UPDATE %s SET ", table);
		return this;
	}

	public SQLBuilder select(String column) {
		this.query = selectString();
		columns.add(column);
		return this;
	}

	public SQLBuilder select(List<String> cols) {
		this.query = selectString();
		columns.addAll(cols);
		return this;
	}

	public SQLBuilder from(String table) {
		tables.add(table);
		return this;
	}

	public SQLBuilder where(QueryObject obj) {
		data.add(obj);
		value.add(obj.getDatum());
		return this;
	}

	public SQLBuilder where(List<QueryObject> obj) {
		data.addAll(obj);
		for (Iterator<QueryObject> tempObject = obj.iterator(); tempObject.hasNext();) {
			value.add(tempObject.next().getDatum());
		}
		return this;
	}
	
	public SQLBuilder prepareUpdateData(List<InsertObject> data) {
		updateData.addAll(data);
		for (Iterator<InsertObject> tempObject = data.iterator(); tempObject.hasNext();) {
			value.add(tempObject.next().getData());
		}
		return this;
	}
	
	public SQLBuilder prepareUpdateData(InsertObject data) {
		updateData.add(data);
		value.add(data.getData());
		return this;
	}

	public SQLBuilder or(String column, Operations opt, Object value) {
		data.add(buildQueryObject(column, opt, value, BoleanOperators.OR));
		return this;
	}

	public SQLBuilder and(String column, Operations opt, Object value) {
		data.add(buildQueryObject(column, opt, value, BoleanOperators.AND));
		return this;
	}

	public String build() {

		// process columns
		this.query += (processColumns() != null) ? processColumns() : "";

		// process tables
		this.query += (processTables() != null) ? processTables() : "";

		// process where clause
		this.query += (processWhere() != null) ? processWhere() : "";

		return this.query.trim();
	}

	public String buildInsert(List<InsertObject> data) {
		String questionMark = "";
		String columns = "";
		int counter = 1;
		for (Iterator<InsertObject> datum = data.iterator(); datum.hasNext();) {
			InsertObject temp = datum.next();
			columns += temp.getColumn();
			questionMark += "?";
			if (counter < data.size()) {
				questionMark += ",";
				columns += ",";
			}
			value.add(temp.getData());
			counter++;
		}
		String finalQuery = String.format("%s (%s) VALUES (%s)", this.query, columns, questionMark);

		return finalQuery;
	}
	
	public String buildUpdate() {
		this.query += processUpdateSet();
		
		this.query += processWhere();
		
		return this.query.trim();
	}

	public SQLBuilder customQuery(String sql) {
		query = sql;
		return this;
	}
	
	public String getQuery() {
		return query;
	}

	public String query() {
		return query;
	}

	public List<Object> getValue() {
		return value;
	}

	private String selectString() {
		return "SELECT ";
	}

	private String processTables() {
		if (tables.size() != 0) {
			String tempQuery = "FROM ";
			tempQuery += commonProcess(tables);
			return tempQuery;
		}
		return null;
	}
	
	private String processUpdateSet() {
		String tempQuery = "";
		int counter = 1;
		for(Iterator<InsertObject> datum = updateData.iterator(); datum.hasNext();) {
			InsertObject temp = datum.next();
			tempQuery += String.format("%s %s ?", temp.getColumn(), Operations.EQ.getOperator());
			if(counter < updateData.size()) {
				tempQuery += ", ";
			}
		}
		
		tempQuery += " ";
		
		return tempQuery;
	}

	private String processColumns() {
		if (columns.size() != 0) {
			return commonProcess(columns);
		}
		return null;
	}

	private String processWhere() {
		if (data.size() != 0) {
			String tempQuery = "WHERE ";
			int counter = 1;
			for (Iterator<QueryObject> obj = data.iterator(); obj.hasNext();) {
				QueryObject temp = obj.next();
				tempQuery += String.format("%s %s ? ", temp.getColumn(), temp.getOpt().getOperator());
				if (counter < data.size()) {
					tempQuery += temp.getBolOpt().getOperator() + " ";
				}
				counter++;
			}

			return tempQuery;
		}
		return null;
	}

	private String commonProcess(List<String> data) {
		String tempQuery = "";
		int counter = 1;
		for (Iterator<String> datum = data.iterator(); datum.hasNext();) {
			String temp = datum.next();
			tempQuery += temp;
			if (counter < tables.size()) {
				tempQuery += ", ";
			}
			counter++;
		}

		tempQuery += " ";

		return tempQuery;
	}

	private QueryObject buildQueryObject(String column, Operations opt, Object value, BoleanOperators bolOpt) {
		QueryObject obj = new QueryObject();
		obj.setColumn(column);
		obj.setDatum(value);
		obj.setOpt(opt);
		obj.setBolOpt(bolOpt);
		return obj;
	}

}
