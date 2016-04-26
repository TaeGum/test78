package com.model2.mvc.service.member;

import java.util.*;

import com.model2.mvc.service.domain.*;

public interface MemberService {
	
	public Member getMember(String userId) throws Exception;
	
	//public void getMember(Member member) throws Exception;
	
	public Map<String, Object> getMemberList() throws Exception;
	
	public boolean checkDuplication(String userId) throws Exception;
}
