package com.model2.mvc.service.member;

import java.util.Map;

import com.model2.mvc.common.Search;

import java.util.*;

import com.model2.mvc.service.domain.*;

public interface MemberService {
	
	public Member getMember(String userId) throws Exception;
	public void addMember(Member member) throws Exception;
	public Member getMember2(Member member) throws Exception;
	public Member getMember3(Member member) throws Exception;
	public Member getMember4(Member member) throws Exception;
	public Member getMember5(Member member) throws Exception;
	public void updateMember(Member member) throws Exception;
	public void updateMemberPW(Member member) throws Exception;	
	public Map<String, Object> getMemberList() throws Exception;
	
}
