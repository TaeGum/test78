package com.model2.mvc.service.payrec.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.PayRec;
import com.model2.mvc.service.payrec.PayRecDao;

@Repository("payrecDaoImpl")
public class PayRecDaoImpl implements PayRecDao {
	
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public PayRecDaoImpl() {
		System.out.println(this.getClass());

	}

	@Override
	public void addPayRec(PayRec payrec) throws Exception {
		sqlSession.insert("PayRecMapper.addPayRec", payrec);
		
	}

	@Override
	public List<PayRec> getPayRecList() throws Exception {
		return sqlSession.selectList("PayRecMapper.getPayRecList");
	}

	@Override
	public PayRec getPayRec(int payNumber) throws Exception {
		return sqlSession.selectOne("PayRecMapper.getPayRec", payNumber);
	}

}
