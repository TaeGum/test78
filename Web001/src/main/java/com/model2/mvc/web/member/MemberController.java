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
import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.member.*;
import com.model2.mvc.service.student.*;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	public MemberController(){
		System.out.println(this.getClass());
	}
	
	//로그인
	@RequestMapping( value="/login", method = RequestMethod.POST)
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
	@RequestMapping(value="/logincheck")
	public void afterlogin(HttpSession session, Model model) throws Exception{
		Member m = (Member) session.getAttribute("member");
		
		System.out.println("afterlogin :: "+m);
		
		Student s = studentService.getStudent(m.getUserId());
		
		System.out.println("afterlogin :: "+s);
		
		model.addAttribute("member", m);
		model.addAttribute("student",s);
		
	}
	
	//로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session ) throws Exception{
		
		System.out.println("/logout");
		
		session.invalidate();
		
		return "redirect:/index.html";
		
	}
	
	//리스트 가져오기
	@RequestMapping(value="/getlist")
	public void getlist(Model model) throws Exception{
		System.out.println("/getlist");
		
		Map<String, Object> map = memberService.getMemberList();
		
		model.addAttribute("list",map.get("list"));
	}
	

}
