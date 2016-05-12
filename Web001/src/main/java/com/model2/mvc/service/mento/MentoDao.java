package com.model2.mvc.service.mento;

import java.util.List;

import com.model2.mvc.service.domain.*;

public interface MentoDao {
	
	public void addMento(Mento mento) throws Exception;

	public List<Mento> getMentoList() throws Exception;

	public Mento getMento(String userId) throws Exception;

	public void updateMento(Mento mento) throws Exception;

	
	
}
