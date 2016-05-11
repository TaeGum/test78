package com.model2.mvc.service.payment;

import java.util.List;

import com.model2.mvc.service.domain.Payment;

public interface PaymentDao {

	public void addPayment(Payment payment) throws Exception;

	public List<Payment> getPaymentList() throws Exception;

	public Payment getPayment(int payNumber) throws Exception;

}
