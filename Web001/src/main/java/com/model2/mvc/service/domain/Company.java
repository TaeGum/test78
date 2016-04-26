package com.model2.mvc.service.domain;

public class Company {
	
		//Field
		int companyNumber;
		String companyName;
		String companyType;
		String companyAddr;
		String companyPresentation;
		String companyPicture;
		String companyMap;
		
		//Constructor
		public Company() {
		}
	
		//getter AND setter Method
		public int getCompanyNumber() {
			return companyNumber;
		}
	
		public void setCompanyNumber(int companyNumber) {
			this.companyNumber = companyNumber;
		}
	
		public String getCompanyName() {
			return companyName;
		}
	
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
	
		public String getCompanyType() {
			return companyType;
		}
	
		public void setCompanyType(String companyType) {
			this.companyType = companyType;
		}
	
		public String getCompanyAddr() {
			return companyAddr;
		}
	
		public void setCompanyAddr(String companyAddr) {
			this.companyAddr = companyAddr;
		}
	
		public String getCompanyPresentation() {
			return companyPresentation;
		}
	
		public void setCompanyPresentation(String companyPresentation) {
			this.companyPresentation = companyPresentation;
		}
	
		public String getCompanyPicture() {
			return companyPicture;
		}
	
		public void setCompanyPicture(String companyPicture) {
			this.companyPicture = companyPicture;
		}
	
		public String getCompanyMap() {
			return companyMap;
		}
	
		public void setCompanyMap(String companyMap) {
			this.companyMap = companyMap;
		}
	    
		@Override
		public String toString() {
			return "Company [companyNumber=" + companyNumber + ", companyName=" + companyName + ", companyType=" + companyType + ", companyAddr=" + 
					  companyAddr + ", companyPresentation=" + companyPresentation + ", companyPicture=" + companyPicture + ", companyMap=" + companyMap + "]";
		}
	
	}
