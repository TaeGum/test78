package com.model2.mvc.service.domain;

public class Student {
	
	private Member student;
	private String resume;
	private String spicture;
	
	public Student(){
		
	}
	
	public Member getStudent() {
		return student;
	}
	public void setStudent(Member student) {
		this.student = student;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getSpicture() {
		return spicture;
	}
	public void setSpicture(String spicture) {
		this.spicture = spicture;
	}
	@Override
	public String toString() {
		return "Student [student=" + student + ", resume=" + resume + ", spicture=" + spicture + "]";
	}
	
	
}
