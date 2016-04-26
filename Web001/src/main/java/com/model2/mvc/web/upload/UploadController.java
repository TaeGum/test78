package com.model2.mvc.web.upload;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.model2.mvc.common.StatusResponse;
import com.model2.mvc.common.Message;
import com.model2.mvc.common.UploadFile;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.student.*;


@Controller
//@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	@Qualifier("studentServiceImpl")
	private StudentService studentService;
	
	UploadFile ufile;
	  public UploadController(){
	    System.out.println("init RestController");
	    ufile = new UploadFile();
	  }
	 
	  @RequestMapping(value = "/uploads/{value}", method = RequestMethod.GET)
	  public String get(HttpServletResponse response,@PathVariable String value, HttpSession session) throws Exception{
	        try {
	        	//업로드를 위한 경로 받아오기
	        	String uploadpath = session.getServletContext().getRealPath("/upfile/");
	        	
	        	//System.out.println("여기까지나오니");
	        	
	        	String duploadpath = "./upfile/";
	        	
	        	//DB에 업로드 하기 위한 객체 생성
	        	Member m = (Member) session.getAttribute("member");
	        	
	        	//System.out.println("멤버나오니 ::"+m);
	        	
	        	Student s = studentService.getStudent(m.getUserId());
	        	
	        	System.out.println("path ::" + uploadpath);
	        	
	            //response.setContentType(ufile.type);
	            //response.setContentLength(ufile.length);
	            //화면에 뿌리기 위한것
	            //FileCopyUtils.copy(ufile.bytes, response.getOutputStream());
	            	                        
	            String dbuploadpath = duploadpath+value+ufile.name.substring(ufile.name.indexOf("."));
	            
	            s.setUploadpath(dbuploadpath);
	            
	            System.out.println("db 업로드 경로 ::"+dbuploadpath);
	            
	            //서버에 저장..(업로드)
	            FileCopyUtils.copy(ufile.bytes, new FileOutputStream(uploadpath+"/"+value+ufile.name.substring(ufile.name.indexOf("."))));
	            
	            studentService.uploadStudent(s);
	            
	            System.out.println("업로드 성공!");
	            
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        return "forward:/index.html";
	  }
	 
	   @RequestMapping(value = "/upload", method = RequestMethod.POST)
	   public String upload(MultipartHttpServletRequest request, HttpServletResponse response) {                 
	 
	     //0. notice, we have used MultipartHttpServletRequest
	 
	     //1. get the files from the request object
	     Iterator<String> itr =  request.getFileNames();
	 
	     MultipartFile mpf = request.getFile(itr.next());
	     System.out.println(mpf.getOriginalFilename() +" uploaded!");
	 
	     try {
	                //just temporary save file info into ufile
	        ufile.length = mpf.getBytes().length;
	        ufile.bytes= mpf.getBytes();
	        ufile.type = mpf.getContentType();
	        ufile.name = mpf.getOriginalFilename();
	 
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	     
	     String ext = ufile.name.substring(ufile.name.indexOf("."));
	     System.out.println("확장자 ::"+ext);
	     System.out.println("파일이름 ::"+ufile.name);
	     
	     return "redirect:/uploads/"+Calendar.getInstance().getTimeInMillis()+"up"+ext;
	 
	  }
}
