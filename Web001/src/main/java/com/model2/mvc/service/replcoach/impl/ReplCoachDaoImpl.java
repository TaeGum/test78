package com.model2.mvc.service.replcoach.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.replcoach.ReplCoachDao;
import com.model2.mvc.common.Search;

@Repository("replCoachDaoImpl")
public class ReplCoachDaoImpl implements ReplCoachDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public ReplCoachDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addCoachRepl(ReplCoach replcoach) throws Exception {
		sqlSession.insert("ReplCoachMapper.addCoachRepl", replcoach);
	}

	@Override
	public List<ReplCoach> getCoachReplList() throws Exception {
		return sqlSession.selectList("ReplCoachMapper.getCoachReplList");
	}

	@Override
	public void updateCoachRepl(ReplCoach replcoach) throws Exception {
		sqlSession.update("ReplCoachMapper.updateCoachRepl", replcoach);
	}

}
