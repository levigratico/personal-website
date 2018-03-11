package com.beverly.personal.model;

public class InsertObject {
	private String column;
	private Object data;
	
	public InsertObject(String column, Object data) {
		this.column = column;
		this.data = data;
	}

	public String getColumn() {
		return column;
	}

	public Object getData() {
		return data;
	}	
	
}
