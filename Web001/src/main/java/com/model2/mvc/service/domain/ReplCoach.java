package com.model2.mvc.service.domain;

import java.util.Date;

public class ReplCoach {
	
	//Field
	private String coachId;
	private String repName;
	private Date repDate;
	private String repMain;
	private int repNumber;

	//Constructor
	public ReplCoach() {
	
	}

	//getter and setter
	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
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

	public int getRepNumber() {
		return repNumber;
	}

	public void setRepNumber(int repNumber) {
		this.repNumber = repNumber;
	}		
	
	//toString
	@Override
	public String toString() {
		return "ReplCoach [coachId=" + coachId + ", repName=" + repName + ", repDate=" + 
					repDate + ", repMain=" + repMain + ",repNumber=" + repNumber  + "]";
	}


}
