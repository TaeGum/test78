package com.model2.mvc.service.replmento.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.ReplMento;
import com.model2.mvc.service.replmento.ReplMentoDao;

@Repository("replMentoDaoImpl")
public class ReplMentoDaoImpl implements ReplMentoDao {
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public ReplMentoDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addMentoRepl(ReplMento replmento) throws Exception {
		sqlSession.insert("ReplMentoMapper.addMentoRepl", replmento);
	}

	@Override
	public List<ReplMento> getMentoReplList() throws Exception {
		return sqlSession.selectList("ReplMentoMapper.getMentoReplList");
	}

	@Override
	public void updateMentoRepl(ReplMento replmento) throws Exception {
		sqlSession.update("ReplMentoMapper.updateMentoRepl", replmento);
	}

}
