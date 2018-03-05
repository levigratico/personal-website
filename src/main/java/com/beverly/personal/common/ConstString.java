package com.beverly.personal.common;


public enum ConstString {
	DRIVER("com.mysql.jdbc.Driver"),
	DBPATH("jdbc:mysql://localhost/beverly_db"),
	USERNAME("root"),
	PASSWORD(""),
	BASEURL("/mypersonalweb"),
	TYPE_TITLE("title"),
	TYPE_PAR("paragraph"),
	TYPE_SKILLS("skills");
	
	private final String datum;
	
	ConstString(String ownString) {
		this.datum = ownString;
	}
	
	public String getString() {
		return datum;
	}
	
	
}


