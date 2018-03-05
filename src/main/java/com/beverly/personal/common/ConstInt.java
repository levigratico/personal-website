package com.beverly.personal.common;

public enum ConstInt {
	NAV_HOME(0),
	NAV_PROFILE(1),
	NAV_FAV(2),
	NAV_PHOTOS(3),
	NAV_SETTINGS(4),
	NAV_LOGIN(5);
	
	private int number;
	
	ConstInt(int num) {
		number = num;
	}
	
	public int getNumber() {
		return number;
	}
}
