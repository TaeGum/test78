package com.model2.mvc.web.stylecoach;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.service.stylecoach.StyleCoachService;

import com.model2.mvc.service.domain.*;

@Controller
public class StyleCoachController {
	
	@Autowired
	@Qualifier("stylecoachServiceImpl")
	private StyleCoachService styleCoachService;
	
	public StyleCoachController(){
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
		
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
		
	@RequestMapping(value="/addstylecoach", method=RequestMethod.POST)
	public void addStyleCoach(@RequestBody StyleCoach styleCoach) throws Exception {
						
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
	
	@RequestMapping(value="/getstylecoach")
	public void getStyleCoach(StyleCoach styleCoach, Model model) throws Exception {
		System.out.println("/getstylecoach");
		
		String userId = styleCoach.getUserId();
		System.out.println("유저아이디 : " + userId);
		
		//아이디를 기준으로 DB에서 Select 하기
		StyleCoach stylecoachInfo = styleCoachService.getStyleCoach(userId);
		System.out.println("자료들 : " + stylecoachInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", stylecoachInfo);
		
	}
	@RequestMapping(value = "/updatestylecoach", method=RequestMethod.POST)
	public void updateStyleCoach(@RequestBody StyleCoach styleCoach, Model model) throws Exception {

		System.out.println("/updatestylecoach");
		//입력한 수정된 정보를 DB에 넣기
		styleCoachService.updateStyleCoach(styleCoach);		
	}
} //end of class
