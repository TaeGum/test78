package com.model2.mvc.service.replcoach.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.replcoach.ReplCoachDao;
import com.model2.mvc.service.replcoach.ReplCoachService;

@Service("replCoachServiceImpl")
public class ReplCoachServiceImpl implements ReplCoachService {

	//Field
	@Autowired
	@Qualifier("replCoachDaoImpl")
	private ReplCoachDao replcoachDao;
	public void setReplCoachDao(ReplCoachDao replcoachDao) {
		this.replcoachDao=replcoachDao;
	}
	
	//Constructor
	public ReplCoachServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addCoachRepl(ReplCoach replcoach) throws Exception {
		replcoachDao.addCoachRepl(replcoach);
	}

	@Override
	public Map<String, Object> getCoachReplList() throws Exception {
	
		List<ReplCoach> list = replcoachDao.getCoachReplList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public void updateCoachRepl(ReplCoach replcoach) throws Exception {
		replcoachDao.updateCoachRepl(replcoach);
		
	}

}
