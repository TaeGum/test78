package com.model2.mvc.service.mento.impl;

import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.mento.MentoDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("mentoDaoImpl")
public class MentoDaoImpl implements MentoDao {
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public MentoDaoImpl(){
		System.out.println(this.getClass());
	}
	
	@Override
	public void addMento(Mento mento) throws Exception {
		sqlSession.insert("MentoMapper.addMento",mento);
	}

	@Override
	public List<Mento> getMentoList() throws Exception {
		return sqlSession.selectList("MentoMapper.getMentoList");
	}

	@Override
	public Mento getMento(String userId) throws Exception {
		return sqlSession.selectOne("MentoMapper.getMento", userId);
	}

	@Override
	public void updateMento(Mento mento) throws Exception {
		sqlSession.update("MentoMapper.updateMento", mento);
	}
}
