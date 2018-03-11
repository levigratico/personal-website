package com.beverly.personal.common;


public enum ConstString {
	DRIVER("com.mysql.jdbc.Driver"),
	DBPATH("jdbc:mysql://MYSQL5016.site4now.net/db_a36e6f_beverly"),
	USERNAME("a36e6f_beverly"),
	PASSWORD("BEVlev13"),
	BASEURL("/mypersonalweb"),
	TYPE_TITLE("title"),
	TYPE_PAR("paragraph"),
	TYPE_SKILLS("skills"),
	IMAGE_PATH("http://l3dedvvy-site.btempurl.com/uploading/images/");
	
	
	private final String datum;
	
	ConstString(String ownString) {
		this.datum = ownString;
	}
	
	public String getString() {
		return datum;
	}
	
	
}


