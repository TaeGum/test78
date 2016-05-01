package com.model2.mvc.service.domain;

public class ReservationInfo {
	
	//Field
	int companyNumber;
	String companyName;
	String reservationId;
	String reservationName;
	String reservationDate;
	String reservationTime;
	
	//Constructor
	public ReservationInfo() {
	}
	
	//getter and setter
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

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	
	@Override
	public String toString() {
		return "Reservation [companyNumber=" + companyNumber + ", companyName=" + companyName + ", reservationId=" + reservationId + ", reservationName=" + 
				reservationName + ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + "]";
	}


} //end of class
