package com.model2.mvc.service.student;

import com.model2.mvc.service.domain.*;

public interface StudentDao {
	
	public Student getStudent(String userId) throws Exception;
	
	public void updateStudent(Student student) throws Exception;
	
	public void uploadStudent(Student student) throws Exception; 

}
