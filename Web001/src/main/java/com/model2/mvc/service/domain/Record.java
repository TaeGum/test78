package com.model2.mvc.service.domain;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.core.style.ToStringCreator;

public class Record {
	
	//Field
	private int recordNo;
	private String studentId;
	private String studentName;
	private String recordFile;
	private String recordName;
	private Date recordDate;
	private Timestamp recordTime;
	
	//Constructor
	public Record() {

	}

	//getter and setter
	public int getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(int recordNo) {
		this.recordNo = recordNo;
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

	public String getRecordFile() {
		return recordFile;
	}

	public void setRecordFile(String recordFile) {
		this.recordFile = recordFile;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	
	@Override
	public String toString() {
		return "Record [recordNo=" + recordNo + ", studentId=" + studentId + ", studentName=" + studentName + ", recordFile="
				+ recordFile + ", recordName=" + recordName + ", recordDate=" + recordDate + ", recordTime=" + recordTime +"]";

	}

}
