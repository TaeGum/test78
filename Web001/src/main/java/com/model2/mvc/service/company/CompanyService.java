package com.model2.mvc.service.company;

import java.util.Map;

import com.model2.mvc.service.domain.Company;

public interface CompanyService {
	
	public void addCompany(Company company) throws Exception;
	
	public Map<String, Object> getCompanyList() throws Exception; 
	
	public Company getCompany(int number) throws Exception;

	public void updateCompany(Company company) throws Exception;
	
	public void deleteCompany(String companyNumber) throws Exception;

	

	

	
}
