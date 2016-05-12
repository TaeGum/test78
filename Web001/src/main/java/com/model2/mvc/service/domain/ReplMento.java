package com.model2.mvc.service.domain;

import java.util.Date;

public class ReplMento {
	
	//Field
	private int repNumber;
	private String mentoId;
	private String repName;
	private Date repDate;
	private String repMain;

	//Constructor
	public ReplMento() {
	
	}

	//getter and setter
	public int getRepNumber() {
		return repNumber;
	}

	public void setRepNumber(int repNumber) {
		this.repNumber = repNumber;
	}

	public String getMentoId() {
		return mentoId;
	}

	public void setMentoId(String mentoId) {
		this.mentoId = mentoId;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public String getRepMain() {
		return repMain;
	}

	public void setRepMain(String repMain) {
		this.repMain = repMain;
	}
	
	//toString
	@Override
	public String toString() {
		return "ReplMento [repNumber=" + repNumber + ", mentoId=" + mentoId + ", repName=" + 
				repName + ", repDate=" + repDate + ",repMain=" + repMain  + "]";
	}		
	

}
