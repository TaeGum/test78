package com.model2.mvc.service.reservationinfo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.Company;
import com.model2.mvc.service.domain.ReservationInfo;
import com.model2.mvc.service.reservationinfo.ReservationInfoDao;
import com.model2.mvc.service.reservationinfo.ReservationInfoService;

@Service("reservationInfoServiceImpl")
public class ReservationInfoServiceImpl implements ReservationInfoService {

	//Field
	@Autowired
	@Qualifier("reservationInfoDaoImpl")
	private ReservationInfoDao reservationInfoDao;
	public void setReservationInfoDao(ReservationInfoDao reservationInfoDao) {
		this.reservationInfoDao = reservationInfoDao;
	}
	
	//Constructor
	public ReservationInfoServiceImpl() {
		
	}

	@Override
	public void addReservation(ReservationInfo reservationinfo) throws Exception {
		reservationInfoDao.addReservation(reservationinfo);
	}

	@Override
	public Map<String, Object> getReservationList() throws Exception {
		
		List<ReservationInfo> list = reservationInfoDao.getReservationList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	@Override
	public ReservationInfo getReservation(int rvNumber) throws Exception {
		return reservationInfoDao.getReservation(rvNumber);
	}

	@Override
	public void updateReservation(ReservationInfo reservationinfo) throws Exception {
		reservationInfoDao.updateReservation(reservationinfo);
	}

}
