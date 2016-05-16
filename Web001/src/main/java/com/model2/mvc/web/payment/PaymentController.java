package com.model2.mvc.web.payment;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.model2.mvc.service.domain.PayRec;
import com.model2.mvc.service.domain.Payment;
import com.model2.mvc.service.payment.PaymentService;
import com.model2.mvc.service.payrec.PayRecService;

@Controller
public class PaymentController {

	//Field
	@Autowired
	@Qualifier("paymentServiceImpl")
	private PaymentService paymentService;

	public PaymentController() {
		System.out.println(this.getClass());
	}
	
	@RequestMapping(value="/addpayment", method=RequestMethod.POST)
	public void addPayment(@RequestBody Payment payment) throws Exception {
		
		System.out.println("/addpayment");
		System.out.println("&&& : " + payment);
		
		//입력한 정보 DB에 저장
		paymentService.addPayment(payment);
		System.out.println("INSERT된 자료 : " + payment);
	}
	
	@RequestMapping(value="/getpaymentList")
	public void getPaymentList(HttpSession session, Model model) throws Exception  {
		
		System.out.println("/getpaymentList");
		
		Member m = (Member) session.getAttribute("member");
		String Id = (String) m.getUserId();
		
		Map<String, Object> map = paymentService.getPaymentList();
				
		System.out.println("리스트 : " + map);
		model.addAttribute("list", map.get("list"));	
		model.addAttribute("Id", Id);
	
	}
	
	@RequestMapping(value="/PaymentGet")
	public void getPayment(Payment payment, Model model) throws Exception {
		
		System.out.println("/PaymentGet");
		
		int payNumber = payment.getPaymentNumber();
		System.out.println("결제일련번호 : " + payNumber);
		
		//결제일련번호를 기준으로 Select 하기
		Payment paymentInfo = paymentService.getPayment(payNumber);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", paymentInfo);
		
	}
}
