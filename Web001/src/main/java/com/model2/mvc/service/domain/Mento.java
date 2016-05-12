package com.model2.mvc.service.domain;

public class Mento {

	//Field
	private String mentoId;
	private String mentoName;
	private String mentoImage;
	private String shortIntro;
	private String longIntro;
	
	//Constructor
	public Mento() {
		
	}

	//getter and setter
	public String getMentoId() {
		return mentoId;
	}

	public void setMentoId(String mentoId) {
		this.mentoId = mentoId;
	}

	public String getMentoName() {
		return mentoName;
	}

	public void setMentoName(String mentoName) {
		this.mentoName = mentoName;
	}

	public String getMentoImage() {
		return mentoImage;
	}

	public void setMentoImage(String mentoImage) {
		this.mentoImage = mentoImage;
	}

	public String getShortIntro() {
		return shortIntro;
	}

	public void setShortIntro(String shortIntro) {
		this.shortIntro = shortIntro;
	}

	public String getLongIntro() {
		return longIntro;
	}

	public void setLongIntro(String longIntro) {
		this.longIntro = longIntro;
	}

	@Override
	public String toString() {
		return "Mento [mentoId=" + mentoId + ", shortIntro=" + shortIntro + ", longIntro=" + longIntro + ", mentoImage="
				+ mentoImage + ", mentoName=" + mentoName + "]";
	}
	
}
