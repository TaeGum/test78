package com.model2.mvc.service.company;


import java.util.List;

import com.model2.mvc.service.domain.Company;

public interface CompanyDao {
	
	public void addCompany(Company company) throws Exception;
	
	public List<Company> getCompanyList() throws Exception;
	
	public Company getCompany(int number) throws Exception;
	
	public void updateCompany(Company company) throws Exception;
	
	public void deleteCompany(String companyNumber) throws Exception;

	



	

	

	


}
