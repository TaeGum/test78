package com.model2.mvc.service.payrec;

import java.util.List;

import com.model2.mvc.service.domain.PayRec;

public interface PayRecDao {

	public void addPayRec(PayRec payrec) throws Exception;

	public List<PayRec> getPayRecList() throws Exception;

	public PayRec getPayRec(int payNumber) throws Exception;

}
