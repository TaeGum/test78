package com.model2.mvc.web.replcompany;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.domain.ReplCompany;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.replcompany.ReplCompanyService;


@Controller
public class ReplCompanyController {

	//Field
	@Autowired
	@Qualifier("replCompanyServiceImpl")
	private ReplCompanyService replCompanyService;
	
	//Constructor
	public ReplCompanyController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="/addcompanyrepl", method=RequestMethod.POST)
	public void addReplCompany(@RequestBody ReplCompany replcompany) throws Exception {
		
		System.out.println("/addcomapnyrepl");
		
		//입력한정보 DB에 저장
		replCompanyService.addCompanyRepl(replcompany);
		System.out.println("INSERT된 자료 : " + replcompany);
	
	}

	@RequestMapping(value="/getcompanyreplList")
	public void getCompanyReplList(Model model) throws Exception {
			
		System.out.println("/getcompanyreplList");
		
		Map<String, Object> map = replCompanyService.getCompanyReplList();
		
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));
	}
	
	@RequestMapping(value = "/updatecompanyrepl", method=RequestMethod.POST)
	public void updateReplCompany(@RequestBody ReplCompany replcompany) throws Exception {

		System.out.println("/updatecompanyrepl");
		//입력한 수정된 정보를 DB에 넣기
		replCompanyService.updateCompanyRepl(replcompany);		
	}
	 
} 
//end of class
