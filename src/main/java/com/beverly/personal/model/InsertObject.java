package com.beverly.personal.model;

public class InsertObject {
	private String column;
	private String data;
	
	public InsertObject(String column, String data) {
		this.column = column;
		this.data = data;
	}

	public String getColumn() {
		return column;
	}

	public String getData() {
		return data;
	}	
	
}
