package com.model2.mvc.service.member.impl;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.member.*;


import java.util.List;


import java.util.*;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("memberDaoImpl")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public MemberDaoImpl(){
		
		System.out.println(this.getClass());
		
	}
	
	@Override
	public Member getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		
		return (Member) sqlSession.selectOne("MemberMapper.getMember",userId);
		
	}

	@Override
	public void addMember(Member member) throws Exception {
		
		sqlSession.insert("MemberMapper.addMember",member);
				
	}

	@Override
	public Member getMember2(Member member) throws Exception {
		// TODO Auto-generated method stub
		return (Member) sqlSession.selectOne("MemberMapper.getMember2",member);
	}

	@Override
	public Member getMember3(Member member) throws Exception {
		// TODO Auto-generated method stub
		return (Member) sqlSession.selectOne("MemberMapper.getMember3",member);
	}

	@Override
	public Member getMember4(Member member) throws Exception {
		// TODO Auto-generated method stub
		return (Member) sqlSession.selectOne("MemberMapper.getMember4",member);
	}

	@Override
	public Member getMember5(Member member) throws Exception {
		// TODO Auto-generated method stub
		return (Member) sqlSession.selectOne("MemberMapper.getMember5",member);
	}

	@Override
	public void updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("MemberMapper.updateMember", member);
	}
	
	@Override
	public void updateMemberPW(Member member) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("MemberMapper.updateMemberPW", member);
	}
	
	/*@Override
	public List<Member> getMemberList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper.getMemberList", search);
	}	
	 */
	// �Խ��� Page ó���� ���� ��ü Row(totalCount)  return
	//public int getTotalCount(Search search) throws Exception {
	
	@Override
	public int getTotalCount() throws Exception {
		
		return sqlSession.selectOne("MemberMapper.getTotalCount");
		
	}
	
	@Override
	public List<Member> getMemberList() throws Exception {
		
		return sqlSession.selectList("MemberMapper.getMemberList");
		
	}

	//@Override
	//public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
	//	return sqlSession.selectList("MemberMapper.getMemberList")
	//}


}
