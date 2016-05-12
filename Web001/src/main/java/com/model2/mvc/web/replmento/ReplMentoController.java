package com.model2.mvc.web.replmento;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.domain.ReplMento;
import com.model2.mvc.service.replcoach.ReplCoachService;
import com.model2.mvc.service.replmento.ReplMentoService;

@Controller
public class ReplMentoController {
	
	//Field
	@Autowired
	@Qualifier("replMentoServiceImpl")
	private ReplMentoService replMentoService;

	//Constructor
	public ReplMentoController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	@RequestMapping(value="/addmentorepl", method=RequestMethod.POST)
	public void addMentoRepl(@RequestBody ReplMento replmento) throws Exception {
		
		System.out.println("/addmentorepl");
		
		//입력한 정보 DB에 저장
		replMentoService.addMentoRepl(replmento);
		System.out.println("INSERT된 자료 : " + replmento);
				
	}
	
	@RequestMapping(value="/getmentoreplList")
	public void getMentoReplList(Model model) throws Exception {
		
		System.out.println("/getmentoreplList");
		
		Map<String, Object> map = replMentoService.getMentoReplList();
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));
	}
	
	@RequestMapping(value="/updatementorepl", method=RequestMethod.POST)
	public void updateReplCoach(@RequestBody ReplMento replmento) throws Exception {
		
		System.out.println("/updatementorepl");
		//입력한 수정된 정보를 DB에 넣기
		replMentoService.updateMentoRepl(replmento);
	}   

}
