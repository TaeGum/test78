package com.model2.mvc.web.record;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.service.domain.Member;
import com.model2.mvc.service.domain.Record;
import com.model2.mvc.service.domain.ReservationCoach;
import com.model2.mvc.service.record.RecordService;

@Controller
public class RecordController {

	//Field
	@Autowired
	@Qualifier("recordServiceImpl")
	private RecordService recordService;

	//Constructor
	public RecordController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/addrecord", method=RequestMethod.POST)
	public void addRecord(@RequestBody Record record) throws Exception {
		System.out.println("/addrecord");

		//입력한 정보 DB에 저장
		recordService.addRecord(record);
		System.out.println("INSERT된 자료 : " + record);
	}
	
	@RequestMapping(value="/getrecordinfoList")
	public void getRecordList(HttpSession session, Model model) throws Exception {
		
		System.out.println("/getrecordinfoList");
		Map<String, Object> map = recordService.getRecordList();
		
		Member m = (Member) session.getAttribute("member");
		String Id = (String) m.getUserId();
		
		System.out.println("#### : " + Id);
		System.out.println("리스트 : " + map);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("Id", Id);
	}
	
	@RequestMapping(value="/getrecord") 
	public void getRecord(Record record, Model model) throws Exception {
		
		System.out.println("/getrecord");
		
		int recNumber = record.getRecordNo();
		System.out.println("예약일련번호 : " + recNumber);
		
		//예약자 아이디를 기준으로 DB에서 Select 하기 
		Record recordInfo = recordService.getRecord(recNumber);
		System.out.println("자료들 : " + recordInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", recordInfo);	
	
	} 
	
}
