package com.beverly.personal.model;

import com.beverly.personal.base.BaseModel;

public class Education extends BaseModel {
	
	private String address;
	private String level;
	public String getAddress() {
		return address;
	}
	public String getLevel() {
		return level;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setLevel(String level) {
		this.level = level;
	}

}
