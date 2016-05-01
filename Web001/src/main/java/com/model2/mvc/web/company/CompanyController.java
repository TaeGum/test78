package com.model2.mvc.web.company;

import java.util.Map;

import javax.servlet.http.*;

import org.aspectj.bridge.CountingMessageHandler;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.service.company.CompanyService;
import com.model2.mvc.service.company.impl.CompanyServiceImpl;

import com.model2.mvc.service.domain.Company;
import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.company.*;

@Controller
public class CompanyController {

	//Field
	@Autowired
	@Qualifier("companyServiceImpl")
	private CompanyService companyService;

	public CompanyController() {
		System.out.println(this.getClass());	
	}

	@RequestMapping(value="/addcompany", method=RequestMethod.POST)
	public void addCompany(@RequestBody Company company, HttpServletRequest request, HttpSession session) throws Exception {

		//입력한 정보 DB에 저장
		companyService.addCompany(company);
		System.out.println("INSERT된 자료 : " +company);

	}

	@RequestMapping(value="/getcompanyList") 
	public void getCompanyList(Model model)throws Exception {

		System.out.println("/getcompanyList");

		Map<String, Object> map = companyService.getCompanyList();

		System.out.println("리스트 : " + map);

		model.addAttribute("list", map.get("list"));			
	}

	@RequestMapping(value="/getcompany")
	public void getCompany(Company company, Model model) throws Exception {
		System.out.println("/getcompany");

		int number = company.getCompanyNumber();
		System.out.println("회사번호 : " + number);	

		//업체번호를 기준으로 DB에서 Select 하기
		Company companyInfo = companyService.getCompany(number);
		System.out.println("자료들 : " + companyInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", companyInfo);

	}

	@RequestMapping(value="/updatecompany", method=RequestMethod.POST)
	public void updateCompany(@RequestBody Company company , Model model) throws Exception {

		System.out.println("/updatecompany");
		//입력한 수정된 정보를 DB에 넣기
		companyService.updateCompany(company);		
	}
}
