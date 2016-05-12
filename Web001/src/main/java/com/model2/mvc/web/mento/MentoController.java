package com.model2.mvc.web.mento;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.domain.Mento;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.member.MemberService;
import com.model2.mvc.service.mento.MentoService;

@Controller
public class MentoController {

	@Autowired
	@Qualifier("mentoServiceImpl")
	private MentoService mentoService;
	
	public MentoController() {
		System.out.println(this.getClass());
	}
		
	@RequestMapping(value="/addmento", method=RequestMethod.POST )
	public void addMento(@RequestBody Mento mento, HttpSession session) throws Exception {
				
		mentoService.addMento(mento);
		System.out.println("INSERT 된 자료 : " + mento);
		
	}

	@RequestMapping(value="/getmentoList")
	public void getMentoList(Model model)throws Exception {
		
		System.out.println("/getmentoList");
				
		Map<String, Object> map = mentoService.getMentoList();
		System.out.println("리스트 : " + map);
						
		model.addAttribute("list", map.get("list"));
	}
	
	@RequestMapping(value="/getmento")
	public void getMento(Mento mento, Model model) throws Exception {
		System.out.println("/getmento");
		
		String userId = mento.getMentoId();
		System.out.println("유저아이디 : " + userId);
		
		//아이디를 기준으로 DB에서 Select 하기
		Mento mentoInfo = mentoService.getMento(userId);
		System.out.println("자료들 : " + mentoInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", mentoInfo);
		
	}
	@RequestMapping(value = "/updatemento", method=RequestMethod.POST)
	public void updateMento(@RequestBody Mento mento, Model model) throws Exception {
		
		System.out.println("/updatemento");
		System.out.println("&&& : " + mento);
		//입력한 수정된 정보를 DB에 넣기
		mentoService.updateMento(mento);		
	}



}
