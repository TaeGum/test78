package com.model2.mvc.web.member;


import java.util.Map;
import javax.crypto.Cipher;
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
import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.member.*;
import com.model2.mvc.service.security.AES256Util;
import com.model2.mvc.service.security.CryptoUtil;
import com.model2.mvc.service.security.SecurityUtil;
import com.model2.mvc.service.security.SecurityUtil2;
import com.model2.mvc.service.student.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	private MemberService memberService;
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	public MemberController(){
		System.out.println(this.getClass());
	}
	

//	@RequestMapping( value="/login.do", method = RequestMethod.POST )
//	public void login(@RequestBody Member member ,

	//로그인
	@RequestMapping( value="/login", method = RequestMethod.POST )
	public void login( @RequestBody Member member,
						HttpSession session,
						Model model ) throws Exception{
		
		//String key = "aes256-test-key!!"; 
		System.out.println("/member/login :- POST");
		//String encrypt = en.encrypt("test1234");
		// System.out.println("origin str = "+"test1234");
		// System.out.println("encrypt str = "+encrypt);
        
		// String decrypt = en.decrypt(encrypt);
        //System.out.println("decrypt str = "+decrypt);
		//String key = "aes256-test-key!!";       // key는 16자 이상 
		//AES256Util aes256 = new AES256Util(key);
		//System.out.println("::"+member);
		
		//System.out.println("멤버 비번 :"+member.getPassword());
		//System.out.println("유저 아이디 : "+member.getUserId());
		
		Member dbmember = memberService.getMember( member.getUserId() );
		
		//String decrypt = AES.decrypt( dbmember.getPassword() );
		
		System.out.println( "dbmember : 1 " + dbmember );
				
		//byte[] decrypted = SecurityUtil.Decrypt( new BASE64Decoder().decodeBuffer( dbmember.getPassword() ) , SecurityUtil.keySpec, SecurityUtil.cipher );
		//String decrypt = new String(decrypted);
		//String decrypt = SecurityUtil2.decode(dbmember.getPassword());
		//AES256Util aes = null; 
		//String decText = aes.decrypt( dbmember.getPassword() );
		//memberService.getMember(member);
	
		String decText = CryptoUtil.decrypt( dbmember.getPassword() );
		
		System.out.println( "dbmember : " + dbmember );
		System.out.println( "decrypt "+ decText + " member.getPassword() : " + member.getPassword() );
		
		if( dbmember != null && ( ( member.getPassword() ).equals( decText )  ) )
		{
			session.setAttribute("member", dbmember);
			model.addAttribute("member", dbmember);
			System.out.println("성공");
		
		}else{
			
			model.addAttribute("member", null);
			System.out.println("실패");
			
		}
		
		/*
		if(dbmember != null){
			session.setAttribute("member", dbmember);
			model.addAttribute("member", dbmember);
		}
		
		else if(dbmember == null)
		{
			model.addAttribute("member", dbmember);
			System.out.println("실패");
		}
		*/
		
	}
	
	//로그인 유무 확인
	@RequestMapping( value= "/logincheck" )
	public void afterlogin( HttpSession session, Model model ) throws Exception{
		
		Member m = (Member) session.getAttribute("member");
		
		System.out.println("afterlogin m:: "+m);
		
		//Student s = studentService.getStudent(m.getUserId());
		
		//System.out.println("afterlogin s:: "+s);
		
		model.addAttribute("member", m);
		//model.addAttribute("student",s);
		
	}
	
	//로그아웃
	@RequestMapping( value="/logout" )
	public String logout( HttpSession session ) throws Exception{
		
		System.out.println("/logout");
		
		session.invalidate();
		
		return "redirect:/index.html";
		
	}
	
	//리스트 가져오기
	@RequestMapping( value = "/getMemberlist" )
	public void getMemberlist( Model model ) throws Exception{
		
		System.out.println("/getlist");
		
		Map<String, Object> map = memberService.getMemberList();
		System.out.println( "리스트 : " + map );
		model.addAttribute( "list", map.get("list") );
	
	}
	
	@RequestMapping( value = "/addMember", method =  RequestMethod.POST )
	public void addUser( @RequestBody Member member , HttpSession session ) throws Exception {
		
		//String key = "aes256-test-key!!"; 
		//String encrypt = AES.encrypt( member.getPassword() );
		//byte[] encrypted = SecurityUtil.Encrypt(member.getPassword(), SecurityUtil.skeySpec, SecurityUtil.cipher);
		//String encrypt =  new BASE64Encoder().encode(encrypted);
		//String encrypt = SecurityUtil2.encode(member.getPassword());
		//System.out.println("encrypt "+encrypt);
		//String key = "aes256-test-key!!";       // key는 16자 이상 
        //AES256Util aes256 = new AES256Util(key);
		//AES256Util aes = null; 
        System.out.println(member+"dddd");
        //String encText = aes.encrypt( member.getPassword() );
        //String decText = aes256.aesDecode(encText);
        String encrypt = CryptoUtil.encrypt( member.getPassword() );
        member.setPassword(encrypt);
		
		System.out.println("/user/addUser : POST");
		System.out.println("유저 : "+ member);
		session.setAttribute("member", member);
		memberService.addMember(member);
		
	}
	
	@RequestMapping( value="/updateMember", method =  RequestMethod.POST )
	public void updateUser( @RequestBody Member member, Model model ) throws Exception {

		System.out.println("/user/addUser : POST");
		System.out.println("유저 : "+member);
		
		memberService.updateMember(member);
		System.out.println("유저2 : "+member);
		
		model.addAttribute("member");
		
	}
		
	@RequestMapping( value="/getMember", method=RequestMethod.GET )
	public void getUser(  Model model, HttpSession session ) throws Exception {
		
		System.out.println( "/user/getUser : GET" );
		Member dbmember = ( Member ) session.getAttribute( "member" );
		Member member = memberService.getMember( dbmember.getUserId() );
		System.out.println("dbmember :: "+member);
		model.addAttribute("member", member);
						
	}
	
	@RequestMapping( value="/getJsonUserEmailID", method=RequestMethod.POST )
	public void getJsonUserEmailID( @RequestBody Member member , Model model ) throws Exception {
		
		//System.out.println("/user/getJsonUserEmail : POST");
		System.out.println("멤버!! "+member);
		Member dbmember = memberService.getMember2(member);
		
		System.out.println("디비멤버버" + dbmember);
		model.addAttribute("member", dbmember);
		
	}
	
	@RequestMapping( value="/getJsonUserEmailPASSWORD", method=RequestMethod.POST )
	public void getJsonUserEmailPASSWORD( @RequestBody Member member , Model model ) throws Exception {
		
		//System.out.println("/user/getJsonUserEmail : POST");
		System.out.println( "멤버!! "+ member );
		Member dbmember = memberService.getMember3( member );
		String decText = CryptoUtil.decrypt( dbmember.getPassword() );
		dbmember.setPassword( decText );
		System.out.println( "디비멤버버" + dbmember );
		model.addAttribute( "member", dbmember );
		
	}
			
	@RequestMapping( value="/getJsonUserCellPhoneID", method=RequestMethod.POST )
	public void getJsonUserCellPhoneID( @RequestBody Member member , Model model ) throws Exception {
		
		//System.out.println("/user/getJsonUserEmail : POST");
		System.out.println("멤버!! "+member);
		Member dbmember = memberService.getMember4(member);
		
		System.out.println("디비멤버버" + dbmember);
		model.addAttribute("member", dbmember);
		
	}
	
	@RequestMapping( value = "/getJsonUserCellPhonePASSWORD" , method=RequestMethod.POST )
	public void getJsonUserCellPhonePASSWORD( @RequestBody Member member , Model model ) throws Exception {
		
		//System.out.println("/user/getJsonUserEmail : POST");
		System.out.println( "멤버!! "+member );
		Member dbmember = memberService.getMember5( member );
		String decText = CryptoUtil.decrypt( dbmember.getPassword() );
		dbmember.setPassword( decText );
		System.out.println( "디비멤버버" + dbmember );
		model.addAttribute( "member", dbmember );
		
	}
	
	/*
	@RequestMapping( value="/listMember" )
	public void listUser( @ModelAttribute("search") Search search , Model model , HttpServletRequest request) 
	throws Exception{
		
		System.out.println("/user/listUser : GET / POST");
		
		if( search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		
		search.setPageSize(pageSize);
		
		Map<String , Object> map = memberService.getMemberList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize );
		System.out.println(resultPage);
		
		model.addAttribute("list", map.get("list"));
		
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		
	}
	*/
	
}
