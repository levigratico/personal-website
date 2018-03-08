package com.beverly.personal.common;

public enum BoleanOperators {
	AND("AND"), OR("OR"), NOT("NOT");
	
	private String operator;
	
	BoleanOperators(String opt) {
		operator = opt;
	}
	
	public String getOperator() {
		return operator;
	}
	
	
}
