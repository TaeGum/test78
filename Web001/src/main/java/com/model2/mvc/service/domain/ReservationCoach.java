package com.model2.mvc.service.domain;

public class ReservationCoach {
	
	//Field
	int reservationNumber;
	String userId;
	String coachName;
	String reservationId;
	String reservationName;
	String reservationDate;
	String reservationTime;
	
	//Constructor
	public ReservationCoach() {
	}
	
	//getter and setter
	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
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
		return "Reservation [reservationNumber=" + reservationNumber + ", userId=" + userId + ", coachName=" + coachName + ", reservationId=" + 
				reservationId + ", reservationName=" + reservationName + ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + "]";
	}	

}
