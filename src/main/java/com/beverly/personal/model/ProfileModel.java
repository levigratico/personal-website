package com.beverly.personal.model;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel {
	private List<Contact> contacts = new ArrayList<>();
	private List<Education> education = new ArrayList<>();
	public List<Contact> getContacts() {
		return contacts;
	}
	public List<Education> getEducation() {
		return education;
	}
	public List<PersonalSkills> getSkills() {
		return skills;
	}
	public List<TechnicalSkills> getTskills() {
		return tskills;
	}
	public void setTskills(TechnicalSkills tskills) {
		this.tskills.add(tskills);
	}
	public void setContacts(Contact contacts) {
		this.contacts.add(contacts);
	}
	public void setEducation(Education education) {
		this.education.add(education);
	}
	public void setSkills(PersonalSkills skills) {
		this.skills.add(skills);
	}
	private List<PersonalSkills> skills = new ArrayList<>();
	private List<TechnicalSkills> tskills = new ArrayList<>();
}
