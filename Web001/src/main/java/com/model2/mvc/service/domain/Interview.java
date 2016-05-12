package com.model2.mvc.service.domain;

import java.sql.Date;

public class Interview {

	//Field
	private int interviewNo;
	private int recordNo;
	private String mentoId;
	private String studentId;	
	private String studentName;	

	//Constructor
	public Interview() {
	
	}
	
	//getter and setter
	public int getInterviewNo() {
		return interviewNo;
	}

	public void setInterviewNo(int interviewNo) {
		this.interviewNo = interviewNo;
	}

	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
	}

	public String getMentoId() {
		return mentoId;
	}

	public void setMentoId(String mentoId) {
		this.mentoId = mentoId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "Interview [interviewNo=" + interviewNo + ", recordNo=" + recordNo + ", mentoId=" + mentoId + ", studentId="
				+ studentId + ", studentName=" + studentName + "]";
	}
	
}
