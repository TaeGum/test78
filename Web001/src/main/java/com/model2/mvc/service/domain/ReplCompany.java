package com.model2.mvc.service.domain;

import java.util.Date;

public class ReplCompany {
	
	//Field
	private int companyNumber;
	private String repName;
	private Date repDate;
	private String repMain;
	private int repNumber;

	//Constructor
	public ReplCompany() {
	}

	//getter and setter
	public int getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(int companyNumber) {
		this.companyNumber = companyNumber;
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
		return "ReplCompany [companyNumber=" + companyNumber + ", repName=" + repName + 
				", repDate=" + repDate + ", repMain=" + repMain + ",repNumber" + repNumber + "]";
	}		
	
}
