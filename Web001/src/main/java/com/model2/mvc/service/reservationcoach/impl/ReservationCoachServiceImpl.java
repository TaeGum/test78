package com.model2.mvc.service.reservationcoach.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.ReservationCoach;
import com.model2.mvc.service.domain.ReservationInfo;
import com.model2.mvc.service.reservationcoach.ReservationCoachDao;
import com.model2.mvc.service.reservationcoach.ReservationCoachService;

@Service("reservationCoachServiceImpl")
public class ReservationCoachServiceImpl implements ReservationCoachService{

	//Field
	@Autowired
	@Qualifier("reservationCoachDaoImpl")
	private ReservationCoachDao reservationCoachDao;
	public void setReservationCoachDao(ReservationCoachDao reservationCoachDao) {
		this.reservationCoachDao = reservationCoachDao;
	}
	
	//Constructor
	public ReservationCoachServiceImpl() {
	}

	@Override
	public void addReservation(ReservationCoach reservationcoach) throws Exception {
		reservationCoachDao.addReservation(reservationcoach);
	}

	@Override
	public Map<String, Object> getReservationList() throws Exception {

		List<ReservationCoach> list = reservationCoachDao.getReservationList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public ReservationCoach getReservation(int rvNumber) throws Exception {
		return reservationCoachDao.getReservation(rvNumber);
	}

	@Override
	public void updateReservation(ReservationCoach reservationcoach) throws Exception {
		reservationCoachDao.updateReservation(reservationcoach);
	}



}
