package com.model2.mvc.web.stylecoach;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.service.company.CompanyService;
import com.model2.mvc.service.member.MemberService;
import com.model2.mvc.service.stylecoach.StyleCoachService;

import com.model2.mvc.service.domain.*;

@Controller
public class StyleCoachController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	@Autowired
	@Qualifier("stylecoachServiceImpl")
	private StyleCoachService styleCoachService;
	
	@Autowired
	@Qualifier("companyServiceImpl")
	private CompanyService companyService;
	
	public StyleCoachController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/addstylecoach", method=RequestMethod.POST)
	public void addStyleCoach(@RequestBody StyleCoach styleCoach, Model model) throws Exception {
		
		//입력한 정보 DB에 저장
		styleCoachService.addStyleCoach(styleCoach);
		System.out.println("INSERT된 자료 : " + styleCoach);
		
	}
	@RequestMapping(value="/getstylecoachList")
	public void getStyleCoachList(Model model)throws Exception {
		
		System.out.println("/getstylecoachList");
		
		Map<String, Object> map = styleCoachService.getStyleCoachList();
		
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));
	}
	
} //end of class
