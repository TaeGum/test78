package com.model2.mvc.service.mento;

import java.util.List;
import java.util.Map;

import com.model2.mvc.service.domain.*;

public interface MentoService {
	
	public void addMento(Mento mento) throws Exception;

	public Map<String, Object> getMentoList() throws Exception;

	public Mento getMento(String userId) throws Exception;

	public void updateMento(Mento mento) throws Exception;
	
	
}
