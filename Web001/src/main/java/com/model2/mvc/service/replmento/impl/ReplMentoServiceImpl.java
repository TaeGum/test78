package com.model2.mvc.service.replmento.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.domain.ReplMento;
import com.model2.mvc.service.replmento.ReplMentoDao;
import com.model2.mvc.service.replmento.ReplMentoService;

@Service("replMentoServiceImpl")
public class ReplMentoServiceImpl implements ReplMentoService {

	//Field
	@Autowired
	@Qualifier("replMentoDaoImpl")
	private ReplMentoDao replmentoDao;
	public void setReplMentoDao(ReplMentoDao replmentoDao) {
		this.replmentoDao=replmentoDao;
	}
	
	//Constructor
	public ReplMentoServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addMentoRepl(ReplMento replmento) throws Exception {
		replmentoDao.addMentoRepl(replmento);
	}

	@Override
	public Map<String, Object> getMentoReplList() throws Exception {
		
		List<ReplMento> list = replmentoDao.getMentoReplList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public void updateMentoRepl(ReplMento replmento) throws Exception {
		replmentoDao.updateMentoRepl(replmento);
	}

}
