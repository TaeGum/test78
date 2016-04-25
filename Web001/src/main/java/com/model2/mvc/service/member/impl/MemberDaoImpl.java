package com.model2.mvc.service.member.impl;

import com.model2.mvc.service.domain.*;
import com.model2.mvc.service.member.*;

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
		//System.out.println("Dao Id : "+userId);
		
		/*Member member = sqlSession.selectOne("MemberMapper.getMember",userId);
		
		System.out.println(member);*/
		
		return (Member) sqlSession.selectOne("MemberMapper.getMember",userId);
		
		//sqlSession.insert("MemberMapper.getMember", member);
		
	}

	@Override
	public List<Member> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("MemberMapper.getMemberList");
	}

}
