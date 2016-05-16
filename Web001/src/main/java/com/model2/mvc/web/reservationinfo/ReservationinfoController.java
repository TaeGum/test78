package com.model2.mvc.web.reservationinfo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.model2.mvc.service.domain.ReservationInfo;
import com.model2.mvc.service.reservationinfo.ReservationInfoService;

@Controller
public class ReservationinfoController {

	//Field
	@Autowired
	@Qualifier("reservationInfoServiceImpl")
	private ReservationInfoService reservationInfoService;
	
	//Constructor
	public ReservationinfoController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/addreservationinfo", method=RequestMethod.POST)
	public void addReservation(@RequestBody ReservationInfo reservationinfo) throws Exception {
		System.out.println("/addreservationinfo");
		
		//입력한 정보 DB에 저장
		reservationInfoService.addReservation(reservationinfo);
		System.out.println("INSERT된 자료 : " + reservationinfo);
	}
	
	@RequestMapping(value="/getreservationinfoList")
	public void getReservationList(HttpSession session, Model model) throws Exception {
		
		System.out.println("/getreservationinfoList");
		
		Member m = (Member) session.getAttribute("member");
		String Id = (String) m.getUserId();
		
		Map<String, Object> map = reservationInfoService.getReservationList();
		
		System.out.println("리스트 : " + map);
		
		model.addAttribute("list", map.get("list"));		
		model.addAttribute("Id", Id);
	}
	
	@RequestMapping(value="/getreservationinfo") 
	public void getReservation(ReservationInfo reservationinfo, Model model) throws Exception {
		
		System.out.println("/getreservationinfo");
		
		int rvNumber = reservationinfo.getReservationNumber();
		System.out.println("예약일련번호 : " + rvNumber);
		
		//예약자 아이디를 기준으로 DB에서 Select 하기 
		ReservationInfo reservationInfo = reservationInfoService.getReservation(rvNumber);
		System.out.println("자료들 : " + reservationInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", reservationInfo);	
	}
	
	@RequestMapping(value="/updatereservationinfo")
	public void updateReservation(@RequestBody ReservationInfo reservationinfo, Model model) throws Exception {
		
		System.out.println("/updatereservationinfo");
		
		//입력한 수정된 정보를 DB에 넣기
		reservationInfoService.updateReservation(reservationinfo);
		
	}	
}
