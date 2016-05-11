package com.model2.mvc.service.replcompany.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.ReplCompany;
import com.model2.mvc.service.replcompany.ReplCompanyDao;

@Repository("replCompanyDaoImpl")
public class ReplCompanyDaoImpl implements ReplCompanyDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public ReplCompanyDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addCompanyRepl(ReplCompany replcompany) throws Exception {
		sqlSession.insert("ReplCompanyMapper.addCompanyRepl", replcompany);
	}

	@Override
	public List<ReplCompany> getCompanyReplList() throws Exception {
		return sqlSession.selectList("ReplCompanyMapper.getCompanyReplList");
	}

	@Override
	public void updateCompanyRepl(ReplCompany replcompany) throws Exception {
		sqlSession.update("ReplCompanyMapper.updateCompanyRepl", replcompany);
	}

}
