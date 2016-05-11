package com.model2.mvc.web.replcoach;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.replcoach.ReplCoachService;

@Controller
public class ReplCoachController {
	
	//Field
	@Autowired
	@Qualifier("replCoachServiceImpl")
	private ReplCoachService replCoachService;

	//Constructor
	public ReplCoachController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="/addcoachrepl", method=RequestMethod.POST)
	public void addCoachRepl(@RequestBody ReplCoach replcoach) throws Exception {
		
		System.out.println("/addcoachrepl");
		
		//입력한 정보 DB에 저장
		replCoachService.addCoachRepl(replcoach);
		System.out.println("INSERT된 자료 : " + replcoach);
				
	}
	
	@RequestMapping(value="/getcoachreplList")
	public void getCoachReplList(Model model) throws Exception {
		
		System.out.println("/getcoachreplList");
		
		Map<String, Object> map = replCoachService.getCoachReplList();
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));
	}
	
	@RequestMapping(value="/updatecoachrepl", method=RequestMethod.POST)
	public void updateReplCoach(@RequestBody ReplCoach replcoach) throws Exception {
		
		System.out.println("/updatecoachrepl");
		//입력한 수정된 정보를 DB에 넣기
		replCoachService.updateCoachRepl(replcoach);
	}
	
} //end of class
