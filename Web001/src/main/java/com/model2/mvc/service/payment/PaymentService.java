package com.model2.mvc.service.payment;

import java.util.Map;

import com.model2.mvc.service.domain.Payment;

public interface PaymentService {

	public void addPayment(Payment payment) throws Exception;

	public Map<String, Object> getPaymentList() throws Exception;

	public Payment getPayment(int payNumber) throws Exception;

}
