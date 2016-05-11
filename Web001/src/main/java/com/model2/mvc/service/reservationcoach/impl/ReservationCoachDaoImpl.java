package com.model2.mvc.service.reservationcoach.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.ReservationCoach;
import com.model2.mvc.service.reservationcoach.ReservationCoachDao;

@Repository("reservationCoachDaoImpl")
public class ReservationCoachDaoImpl implements ReservationCoachDao{

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public ReservationCoachDaoImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addReservation(ReservationCoach reservationcoach) throws Exception {
		sqlSession.insert("ReservationCoachMapper.addReservation", reservationcoach);
	}

	@Override
	public List<ReservationCoach> getReservationList() throws Exception {
		return sqlSession.selectList("ReservationCoachMapper.getReservationList");
	}

	@Override
	public ReservationCoach getReservation(int rvNumber) throws Exception {
		return sqlSession.selectOne("ReservationCoachMapper.getReservation", rvNumber);
	}

	@Override
	public void updateReservation(ReservationCoach reservationcoach) throws Exception {
		sqlSession.update("ReservationCoachMapper.updateReservation", reservationcoach);
	}

}
