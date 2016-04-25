package com.model2.mvc.service.member;

import java.util.*;

import com.model2.mvc.service.domain.*;

public interface MemberDao {
	
	public Member getMember(String userId) throws Exception;
	
	//public void getMember(Member member) throws Exception;

	public List<Member> getMemberList() throws Exception;
}
