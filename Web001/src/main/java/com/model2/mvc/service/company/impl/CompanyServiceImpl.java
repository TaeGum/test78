package com.model2.mvc.service.company.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.Company;
import com.model2.mvc.service.company.CompanyService;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.company.CompanyDao;

@Service("companyServiceImpl")
public class CompanyServiceImpl implements CompanyService {

	//Field
	@Autowired
	@Qualifier("companyDaoImpl")
	private CompanyDao companyDao;
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	//Constructor
	public CompanyServiceImpl() {
		System.out.println(this.getClass());
	}

	//Method
	@Override
	public void addCompany(Company company) throws Exception {
		companyDao.addCompany(company);		
	}
	
	@Override
	public Map<String, Object> getCompanyList() throws Exception {
		List<Company> list = companyDao.getCompanyList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	/*@Override
	public Map<String, List<Company>> getCompanyList() throws Exception {
		List<Company> list = companyDao.getCompanyList();
		
		Map<String, List<Company>> map = new HashMap<String, List<Company>>();
		map.put("list", list);
		
		return map;	
	}*/
	
	@Override
	public Company getCompany(int number) throws Exception {
		return companyDao.getCompany(number);
	}

	@Override
	public void updateCompany(Company company) throws Exception {
		companyDao.updateCompany(company);
	}
}