package com.model2.mvc.service.member.impl;

import com.model2.mvc.service.domain.*;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.member.MemberService;
import com.model2.mvc.service.member.MemberDao;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Autowired
	@Qualifier("memberDaoImpl")
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public Member getMember(String userId) throws Exception {
	//public void getMember(Member member) throws Exception{
		// TODO Auto-generated method stub
		//memberDao.getMember(member);
		return memberDao.getMember(userId);
	}

	@Override
	public Map<String, Object> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		List<Member> list = memberDao.getMemberList();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

}
