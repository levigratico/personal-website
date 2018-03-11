package com.beverly.personal.model;

public class ServicesCollection {
	private int id;
	private String picture;
	private String caption;
	private String serviceTitle;
	private String serviceDescription;
	public int getId() {
		return id;
	}
	public String getPicture() {
		return picture;
	}
	public String getCaption() {
		return caption;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
}
