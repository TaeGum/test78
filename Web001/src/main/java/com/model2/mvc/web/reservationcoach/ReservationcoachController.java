package com.model2.mvc.web.reservationcoach;

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

import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.domain.ReservationCoach;
import com.model2.mvc.service.domain.ReservationInfo;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.reservationcoach.ReservationCoachService;

@Controller
public class ReservationcoachController {
	
	//Field
	@Autowired
	@Qualifier("reservationCoachServiceImpl")
	private ReservationCoachService reservationCoachService;
	
	public ReservationcoachController() {
		System.out.println(this.getClass());
	}
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
		
	@Value("#{commonProperties['pageSize']}")
	int pageSize;

	@RequestMapping(value="/addreservationcoach", method=RequestMethod.POST)
	public void addReservation(@RequestBody ReservationCoach reservationcoach, HttpSession session) throws Exception {
		System.out.println("/addreservationcoach");
				
		reservationCoachService.addReservation(reservationcoach);
		System.out.println("INSERT된 자료 : " + reservationcoach);
		
	}
	
	@RequestMapping(value="/getreservationcoachList")
	public void getReservationList(HttpSession session, Model model) throws Exception {
		
		System.out.println("/getreservationcoachList");
		
		Member m = (Member) session.getAttribute("member");
		String Id = (String) m.getUserId();
		
		Map<String, Object> map = reservationCoachService.getReservationList();
		
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));	
		model.addAttribute("Id", Id);
		
	}
	
	@RequestMapping(value="/getreservationcoach") 
	public void getReservation(ReservationCoach reservationcoach, Model model) throws Exception {
		
		System.out.println("/getreservationcoach");
		
		int rvNumber = reservationcoach.getReservationNumber();
		System.out.println("예약일련번호 : " + rvNumber);
		
		//예약자 아이디를 기준으로 DB에서 Select 하기 
		ReservationCoach reservationCoach = reservationCoachService.getReservation(rvNumber);
		System.out.println("자료들 : " + reservationCoach);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", reservationCoach);	
	}
	
	@RequestMapping(value="/updatereservationcoach")
	public void updateReservation(@RequestBody ReservationCoach reservationcoach, Model model) throws Exception {
		
		System.out.println("/updatereservationcoach");
		
		//입력한 수정된 정보를 DB에 넣기
		reservationCoachService.updateReservation(reservationcoach);
	
	}	
	
}
