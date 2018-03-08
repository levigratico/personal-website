package com.beverly.personal.common;

public enum Operations {
	GT(">"),LT("<"),EQ("="),NOT("<>");
	
	private String operator;
	
	Operations(String opt) {
		operator = opt;
	}
	
	public String getOperator() {
		return operator;
	}
	

}
