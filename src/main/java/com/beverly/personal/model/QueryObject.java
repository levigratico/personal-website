package com.beverly.personal.model;

import com.beverly.personal.common.BoleanOperators;
import com.beverly.personal.common.Operations;

public class QueryObject {
	private Operations opt;
	private Object datum;
	private BoleanOperators bolOpt;
	private String column;
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Operations getOpt() {
		return opt;
	}
	public void setOpt(Operations opt) {
		this.opt = opt;
	}
	public Object getDatum() {
		return datum;
	}
	public void setDatum(Object datum) {
		this.datum = datum;
	}
	public BoleanOperators getBolOpt() {
		return bolOpt;
	}
	public void setBolOpt(BoleanOperators bolOpt) {
		this.bolOpt = bolOpt;
	}
}
