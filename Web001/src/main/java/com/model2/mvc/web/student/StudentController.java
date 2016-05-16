package com.model2.mvc.web.student;

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
import com.model2.mvc.service.domain.Student;
import com.model2.mvc.service.domain.StyleCoach;
import com.model2.mvc.service.member.MemberService;
import com.model2.mvc.service.student.StudentService;

@Controller
public class StudentController {

	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	public StudentController() {		
		System.out.println(this.getClass());
	
	}
		
	@RequestMapping(value="/addstudent", method=RequestMethod.POST )
	public void addStudent(@RequestBody Student student, Model model) throws Exception {
		System.out.println("/addStudent");
		
		//입력한 정보 DB에 저장
		studentService.addStudent(student);
		System.out.println("INSERT된 자료 : " + student);
	}
	
	@RequestMapping(value="/getstudent")
	public void getStudent(Model model, HttpSession session) throws Exception {
		
		Member m = (Member) session.getAttribute("member");
		String StudentId = m.getUserId();
		
		//아이디를 기준으로 DB에서 Select 하기
		Student studentInfo = studentService.getStudent(StudentId);
		System.out.println("자료들 : " + studentInfo);
		
		//Select를 통해 뽑아낸 정보를 info에 담아서 View로 보내기
		model.addAttribute("info", studentInfo);
	
	}
	
	@RequestMapping(value="/updatestudent", method=RequestMethod.POST )
	public void updateStudent(@RequestBody Student student, Model model) throws Exception {
		
		System.out.println("***" + student);
		System.out.println("/updatestudent");
		//입력한 수정된 정보를 DB에 넣기
		studentService.updateStudent(student);	
	}

}
