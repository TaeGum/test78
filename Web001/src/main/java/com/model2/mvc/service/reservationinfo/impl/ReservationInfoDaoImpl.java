package com.model2.mvc.service.reservationinfo.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.ReservationInfo;
import com.model2.mvc.service.reservationinfo.ReservationInfoDao;

@Repository("reservationInfoDaoImpl")
public class ReservationInfoDaoImpl implements ReservationInfoDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public ReservationInfoDaoImpl() {
		System.out.println(this.getClass());
	}
	
	//Method
	@Override
	public void addReservation(ReservationInfo reservationinfo) throws Exception {
		sqlSession.insert("ReservationInfoMapper.addReservation", reservationinfo);
	}

	@Override
	public List<ReservationInfo> getReservationList() throws Exception {
		return sqlSession.selectList("ReservationInfoMapper.getReservationList");
	}

	@Override
	public ReservationInfo getReservation(int rvNumber) throws Exception {
		return sqlSession.selectOne("ReservationInfoMapper.getReservation", rvNumber);
	}

	@Override
	public void updateReservation(ReservationInfo reservationinfo) throws Exception {
		sqlSession.update("ReservationInfoMapper.updateReservation", reservationinfo);
	}
	
}
