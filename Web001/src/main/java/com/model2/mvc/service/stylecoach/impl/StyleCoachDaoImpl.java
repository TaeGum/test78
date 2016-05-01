package com.model2.mvc.service.stylecoach.impl;

import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.stylecoach.StyleCoachDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("stylecoachDaoImpl")
public class StyleCoachDaoImpl implements StyleCoachDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public StyleCoachDaoImpl() {
		System.out.println(this.getClass());
	}
		

	@Override
	public void addStyleCoach(StyleCoach styleCoach) throws Exception {
		sqlSession.insert("StyleCoachMapper.addStyleCoach", styleCoach);
	}

	@Override
	public List<StyleCoach> getStyleCoachList() throws Exception {
		return sqlSession.selectList("StyleCoachMapper.getStyleCoachList");
	}

	@Override
	public StyleCoach getStyleCoach(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("StyleCoachMapper.getStyleCoach", userId);
	}
	
	@Override
	public void updateStyleCoach(StyleCoach styleCoach) throws Exception {
		sqlSession.update("StyleCoachMapper.updateStyleCoach", styleCoach);
	}




}
