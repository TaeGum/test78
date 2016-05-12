package com.model2.mvc.service.replmento;

import java.util.Map;

import com.model2.mvc.service.domain.ReplMento;

public interface ReplMentoService {

	public void addMentoRepl(ReplMento replmento) throws Exception;

	public Map<String, Object> getMentoReplList() throws Exception;

	public void updateMentoRepl(ReplMento replmento) throws Exception;

}
