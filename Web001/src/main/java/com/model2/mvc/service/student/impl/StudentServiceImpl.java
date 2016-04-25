package com.model2.mvc.service.student.impl;

import com.model2.mvc.service.domain.Student;
import com.model2.mvc.service.student.StudentDao;
import com.model2.mvc.service.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier("studentDaoImpl")
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student getStudent(String userId) throws Exception {
		// TODO Auto-generated method stub
		return studentDao.getStudent(userId);
	}

	@Override
	public void updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		studentDao.uploadStudent(student);
	}

}
