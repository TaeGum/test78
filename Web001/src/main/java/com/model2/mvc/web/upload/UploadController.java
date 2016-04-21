package com.model2.mvc.web.upload;

import java.io.*;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.util.FileCopyUtils;

import com.model2.mvc.common.StatusResponse;
import com.model2.mvc.common.Message;
import com.model2.mvc.common.UploadFile;


@Controller
//@RequestMapping("/upload")
public class UploadController {
	UploadFile ufile;
	  public UploadController(){
	    System.out.println("init RestController");
	    ufile = new UploadFile();
	  }
	 
	  @RequestMapping(value = "/get/{value}.do", method = RequestMethod.GET)
	  public void get(HttpServletResponse response,@PathVariable String value, HttpSession session){
	        try {
	        	//업로드를 위한 경로 받아오기
	        	String uploadpath = session.getServletContext().getRealPath("/images/");
	        	
	        	System.out.println("path ::" + uploadpath);
	        	
	            response.setContentType(ufile.type);
	            response.setContentLength(ufile.length);
	            //화면에 뿌리기 위한것
	            FileCopyUtils.copy(ufile.bytes, response.getOutputStream());
	            
	            //서버에 저장..(업로드)
	            FileCopyUtils.copy(ufile.bytes, new FileOutputStream(uploadpath+"/"+value));
	            System.out.println("업로드 성공!");
	            
	 
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	  }
	 
	   @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	   public @ResponseBody String upload(MultipartHttpServletRequest request, HttpServletResponse response) {                 
	 
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
	     
	 
	     //2. send it back to the client as <img> that calls get method
	     //we are using getTimeInMillis to avoid server cached image 
	 
	     return "<img src='./get/"+Calendar.getInstance().getTimeInMillis()+"up"+ext+".do' />";
	 
	  }
}
