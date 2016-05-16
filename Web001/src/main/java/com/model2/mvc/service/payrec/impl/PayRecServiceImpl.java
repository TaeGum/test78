package com.model2.mvc.service.payrec.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.PayRec;
import com.model2.mvc.service.domain.Payment;
import com.model2.mvc.service.payment.PaymentDao;
import com.model2.mvc.service.payrec.PayRecDao;
import com.model2.mvc.service.payrec.PayRecService;

@Service("payrecServiceImpl")
public class PayRecServiceImpl implements PayRecService {

	//Field
	@Autowired
	@Qualifier("payrecDaoImpl")
	private PayRecDao payrecDao;
	public void setPayRecDao(PayRecDao payrecDao) {
		this.payrecDao= payrecDao;
	}
	
	//Constructor
	public PayRecServiceImpl() {
		System.out.println(this.getClass());
	}


	@Override
	public void addPayRec(PayRec payrec) throws Exception {
		payrecDao.addPayRec(payrec);
	}

	@Override
	public Map<String, Object> getPayRecList() throws Exception {
		
		List<PayRec> list = payrecDao.getPayRecList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public PayRec getPayRec(int payNumber) throws Exception {
		return payrecDao.getPayRec(payNumber);
	}

}
