package com.model2.mvc.service.company.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.Company;
import com.model2.mvc.service.company.CompanyDao;
import com.model2.mvc.common.Search;


@Repository("companyDaoImpl")
public class CompanyDaoImpl implements CompanyDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Constructor
	public CompanyDaoImpl() {
		System.out.println(this.getClass());
	}
	
	//Method
	@Override
	public void addCompany(Company company) throws Exception {
		sqlSession.insert("CompanyMapper.addCompany", company);
	}
	
	@Override
	public List<Company> getCompanyList() throws Exception {
		return sqlSession.selectList("CompanyMapper.getCompanyList");
	}
	
	@Override
	public Company getCompany(int number) throws Exception {
		return sqlSession.selectOne("CompanyMapper.getCompany", number);
	}

	@Override
	public void updateCompany(Company company) throws Exception {
		sqlSession.update("CompanyMapper.updateCompany", company);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("CompanyMapper.getTotalCount", search);
	}


}
