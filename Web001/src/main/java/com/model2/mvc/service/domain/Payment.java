package com.model2.mvc.service.domain;

import java.util.Date;

public class Payment {
	
	//Field
	int paymentNumber;
	String studentId;
	int reservationNumber;
	int interviewNumber;
	String paymentName;
	String paymentDate;
	String paymentCardName;
	int paymentCardNumber;
	int paymentCardPassword;
	int paymentMoney;
	
	//Constructor
	public Payment() {
		
	}

	//getter and Setter
	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	
	public int getInterviewNumber() {
		return interviewNumber;
	}

	public void setInterviewNumber(int interviewNumber) {
		this.interviewNumber = interviewNumber;
	}
	
	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentCardName() {
		return paymentCardName;
	}

	public void setPaymentCardName(String paymentCardName) {
		this.paymentCardName = paymentCardName;
	}

	public int getPaymentCardNumber() {
		return paymentCardNumber;
	}

	public void setPaymentCardNumber(int paymentCardNumber) {
		this.paymentCardNumber = paymentCardNumber;
	}

	public int getPaymentCardPassword() {
		return paymentCardPassword;
	}

	public void setPaymentCardPassword(int paymentCardPassword) {
		this.paymentCardPassword = paymentCardPassword;
	}
	
	public int getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(int paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	@Override
		public String toString() {
			return "Payment [paymentNumber=" + paymentNumber + ", studentId=" + studentId + ", reservationNumber=" + reservationNumber + ", interviewNumber=" + interviewNumber + "paymentName=" + paymentName + ", paymentDate=" + paymentDate 
					+ ", paymentCardName=" + paymentCardName + ", paymentCardNumber=" + paymentCardNumber + ", paymentCardPassword=" + paymentCardPassword + ", paymentMoney=" + paymentMoney +"]";
		}	

}
