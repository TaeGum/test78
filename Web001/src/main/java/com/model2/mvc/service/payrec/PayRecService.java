package com.model2.mvc.service.payrec;

import java.util.Map;

import com.model2.mvc.service.domain.PayRec;

public interface PayRecService {

	public void addPayRec(PayRec payrec) throws Exception;

	public Map<String, Object> getPayRecList() throws Exception;

	public PayRec getPayRec(int payNumber) throws Exception;

}
