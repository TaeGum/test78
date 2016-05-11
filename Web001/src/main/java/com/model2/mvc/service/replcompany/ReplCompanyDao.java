package com.model2.mvc.service.replcompany;

import java.util.List;

import com.model2.mvc.service.domain.ReplCompany;

public interface ReplCompanyDao {

	public void addCompanyRepl(ReplCompany replcompany) throws Exception;

	public List<ReplCompany> getCompanyReplList() throws Exception;

	public void updateCompanyRepl(ReplCompany replcompany) throws Exception;


}
