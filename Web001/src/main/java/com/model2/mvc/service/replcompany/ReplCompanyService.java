package com.model2.mvc.service.replcompany;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.ReplCompany;

public interface ReplCompanyService {

	public void addCompanyRepl(ReplCompany replcompany) throws Exception;

	public Map<String, Object> getCompanyReplList() throws Exception;

	public void updateCompanyRepl(ReplCompany replcompany) throws Exception;


}
