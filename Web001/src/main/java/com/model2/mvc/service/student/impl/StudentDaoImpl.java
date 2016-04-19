package com.model2.mvc.service.student.impl;

import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.student.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public StudentDaoImpl(){
		System.out.println(this.getClass());
	}

	@Override
	public Student getStudent(String userId) throws Exception {
		// TODO Auto-generated method stub
		return (Student)sqlSession.selectOne("StudentMapper.getStudent",userId);
	}

}
