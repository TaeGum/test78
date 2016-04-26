package com.model2.mvc.service.stylecoach.impl;

import com.model2.mvc.service.stylecoach.StyleCoachService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.stylecoach.StyleCoachService;
import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.member.MemberDao;
import com.model2.mvc.service.member.MemberService;
import com.model2.mvc.service.stylecoach.StyleCoachDao;

@Service("stylecoachServiceImpl")
public class StyleCoachServiceImpl implements StyleCoachService{

	//Field
	@Autowired
	@Qualifier("stylecoachDaoImpl")
	private StyleCoachDao stylecoachDao;
	public void setStylecoachDao(StyleCoachDao stylecoachDao) {
		this.stylecoachDao = stylecoachDao;
	}
	
	//Constructor
	public StyleCoachServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addStyleCoach(StyleCoach styleCoach) throws Exception {
		stylecoachDao.addStyleCoach(styleCoach);
	}

	@Override
	public Map<String, Object> getStyleCoachList() throws Exception {
		// TODO Auto-generated method stub
		List<StyleCoach> list = stylecoachDao.getStyleCoachList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	
	
}
	

