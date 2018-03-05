package com.beverly.personal.model;

import java.util.ArrayList;
import java.util.List;

public class UserQueryPreparation {
	
	private List<Object> data = new ArrayList<>();
	private String query;
	
	public List<Object> getData() {
		return data;
	}
	public Object getData(int index) {
		return data.get(index);
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public void setData(Object datum) {
		this.data.add(datum);
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
}
