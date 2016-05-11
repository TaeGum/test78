package com.model2.mvc.service.payment.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.Payment;
import com.model2.mvc.service.domain.ReservationCoach;
import com.model2.mvc.service.payment.PaymentDao;
import com.model2.mvc.service.payment.PaymentService;

@Service("paymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	//Field
	@Autowired
	@Qualifier("paymentDaoImpl")
	private PaymentDao paymentDao;
	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao= paymentDao;
	}
	
	//Constructor
	public PaymentServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addPayment(Payment payment) throws Exception {
		paymentDao.addPayment(payment);
	}

	@Override
	public Map<String, Object> getPaymentList() throws Exception {
		
		List<Payment> list = paymentDao.getPaymentList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public Payment getPayment(int payNumber) throws Exception {
		return paymentDao.getPayment(payNumber);
	}
}
