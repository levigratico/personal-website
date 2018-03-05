package com.beverly.personal.model;

import java.util.ArrayList;
import java.util.List;

public class IntroductionModel {
	
	private Skills skills;
	private List<Paragraph> paragraph = new ArrayList<>();
	private Title title;
	
	
	public Skills getSkills() {
		return skills;
	}
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	public List<Paragraph> getParagraph() {
		return paragraph;
	}
	public Paragraph getParagraph(int index) {
		return paragraph.get(index);
	}
	public void setParagraph(List<Paragraph> paragraph) {
		this.paragraph = paragraph;
	}
	public void setParagraph(Paragraph par) {
		this.paragraph.add(par);
	}
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
}
