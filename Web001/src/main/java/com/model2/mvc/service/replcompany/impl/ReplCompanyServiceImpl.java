package com.model2.mvc.service.replcompany.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.ReplCompany;
import com.model2.mvc.service.replcompany.ReplCompanyDao;
import com.model2.mvc.service.replcompany.ReplCompanyService;

@Service("replCompanyServiceImpl")
public class ReplCompanyServiceImpl implements ReplCompanyService {

	//Field
	@Autowired
	@Qualifier("replCompanyDaoImpl")
	private ReplCompanyDao replcompanyDao;
	public void setReplCompanyDao(ReplCompanyDao replcompanyDao) {
		this.replcompanyDao=replcompanyDao;
	}
	
	//Constructor
	public ReplCompanyServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addCompanyRepl(ReplCompany replcompany) throws Exception {
		replcompanyDao.addCompanyRepl(replcompany);
	}

	@Override
	public Map<String, Object> getCompanyReplList() throws Exception {
		
		List<ReplCompany> list = replcompanyDao.getCompanyReplList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public void updateCompanyRepl(ReplCompany replcompany) throws Exception {
		replcompanyDao.updateCompanyRepl(replcompany);
	}
	
}
