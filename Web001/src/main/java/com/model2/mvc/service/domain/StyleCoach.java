package com.model2.mvc.service.domain;

public class StyleCoach {
	
	//Field
	private String userId;
	private String coachPicture;
	private String coachName;
	private String coachType;
	private String coachPresentation;
	private String companyNumber;
	
	//Constructor
	public StyleCoach(){
		
	}
	
	//Getter AND Setter Method
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCoachPicture() {
		return coachPicture;
	}
	
	public void setCoachPicture(String coachPicture) {
		this.coachPicture = coachPicture;
	}
	
	public String getCoachName() {
		return coachName;
	}
	
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	
	public String getCoachType() {
		return coachType;
	}
	
	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}
	
	public String getCoachPresentation() {
		return coachPresentation;
	}
	
	public void setCoachPresentation(String coachPresentation) {
		this.coachPresentation = coachPresentation;
	}
	
	public String getCompanyNumber() {
		return companyNumber;
	}
	
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	//toString
	@Override
	public String toString() {
		return "StyleCoach [userId=" + userId + ", coachPicture=" + coachPicture + ", coachName=" + coachName + ", coachType=" + coachType
				+ ", coachPresentation=" + coachPresentation + ", shopNumber=" + companyNumber + "]";
	}
	
} //end of class
