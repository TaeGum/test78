package com.model2.mvc.service.replmento;

import java.util.List;

import com.model2.mvc.service.domain.ReplMento;

public interface ReplMentoDao {

	public void addMentoRepl(ReplMento replmento) throws Exception;

	public List<ReplMento> getMentoReplList() throws Exception;

	public void updateMentoRepl(ReplMento replmento) throws Exception;

}
