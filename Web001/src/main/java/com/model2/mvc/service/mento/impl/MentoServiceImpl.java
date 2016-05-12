package com.model2.mvc.service.mento.impl;

import com.model2.mvc.service.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.mento.MentoDao;
import com.model2.mvc.service.mento.MentoService;

@Service("mentoServiceImpl")
public class MentoServiceImpl implements MentoService {
	
	//Field
	@Autowired
	@Qualifier("mentoDaoImpl")
	private MentoDao mentoDao;
	public void setMentoDao(MentoDao mentoDao) {
		this.mentoDao = mentoDao;
	}
	
	//Constructor
	public MentoServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addMento(Mento mento) throws Exception {
		mentoDao.addMento(mento);
	}

	@Override
	public Map<String, Object> getMentoList() throws Exception {
		List<Mento> list = mentoDao.getMentoList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public Mento getMento(String userId) throws Exception {
		return mentoDao.getMento(userId);
	}

	@Override
	public void updateMento(Mento mento) throws Exception {
		mentoDao.updateMento(mento);
	}
		
}
