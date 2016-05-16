package com.model2.mvc.web.payrec;

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
import com.model2.mvc.service.domain.PayRec;
import com.model2.mvc.service.domain.Payment;
import com.model2.mvc.service.payment.PaymentService;
import com.model2.mvc.service.payrec.PayRecService;

@Controller
public class PayRecController {

	//Field
	@Autowired
	@Qualifier("payrecServiceImpl")
	private PayRecService payrecService;

	public PayRecController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/addpayRec", method=RequestMethod.POST)
	public void addPayRec(@RequestBody PayRec payrec) throws Exception {
		
		System.out.println("/addpayRec");
		System.out.println("&&& : " + payrec);
		
		//입력한 정보 DB에 저장
		payrecService.addPayRec(payrec);
		System.out.println("INSERT된 자료 : " + payrec);
	}
	
	@RequestMapping(value="/getpayRecList")
	public void getPayRecList(HttpSession session, Model model) throws Exception  {
		
		System.out.println("/getpayRecList");
		
		Member m = (Member) session.getAttribute("member");
		String Id = (String) m.getUserId();
		
		Map<String, Object> map = payrecService.getPayRecList();
				
		System.out.println("리스트 : " + map);
		model.addAttribute("list", map.get("list"));	
		model.addAttribute("Id", Id);
	
	}
	
	@RequestMapping(value="/PayRecGet")
	public void getPayRec(PayRec payrec, Model model) throws Exception {
		
		System.out.println("/PayRecGet");
		
		int payNumber = payrec.getPaymentNumber();
		System.out.println("결제번호 : " + payNumber);
		
		//결제일련번호를 기준으로 Select 하기
		PayRec payrecInfo = payrecService.getPayRec(payNumber);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", payrecInfo);
		
	}
	
}
