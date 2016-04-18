package com.model2.mvc.web.member;

import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.member.*;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	public MemberController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="/login.do", method = RequestMethod.POST)
	public void login(@RequestBody Member member,
						HttpSession session,
						Model model) throws Exception{
		
		System.out.println("/member/login :- POST");
				
		System.out.println("::"+member);
		
		System.out.println("멤버 비번 :"+member.getPassword());
		System.out.println("유저 아이디 : "+member.getUserId());
		
		Member dbmember = memberService.getMember(member.getUserId());
		
		//memberService.getMember(member);
		
		System.out.println("dbmember : " + dbmember);
	
		if( dbmember != null && ( member.getPassword().equals(dbmember.getPassword()) ) ){
			session.setAttribute("member", dbmember);
			model.addAttribute("member", dbmember);
		}else{
			model.addAttribute("member", null);
		}
	}
	
	//로그인 유무 확인
	@RequestMapping(value="/logincheck.do")
	public void afterlogin(HttpSession session, Model model){
		Member m = (Member) session.getAttribute("member");
		
		System.out.println("afterlogin :: "+m);
		
		model.addAttribute("member", m);
	}
	

}
