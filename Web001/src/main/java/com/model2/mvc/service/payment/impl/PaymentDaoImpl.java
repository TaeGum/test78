package com.model2.mvc.service.payment.impl;

import com.model2.mvc.service.domain.Payment;
import com.model2.mvc.service.payment.PaymentDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("paymentDaoImpl")
public class PaymentDaoImpl implements PaymentDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public PaymentDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addPayment(Payment payment) throws Exception {
		sqlSession.insert("PaymentMapper.addPayment", payment);
	}

	@Override
	public List<Payment> getPaymentList() throws Exception {
		return sqlSession.selectList("PaymentMapper.getPaymentList");
	}

	@Override
	public Payment getPayment(int payNumber) throws Exception {
		return sqlSession.selectOne("PaymentMapper.getPayment", payNumber);
	}
}
