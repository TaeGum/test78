package com.model2.mvc.service.reservationinfo;

import java.util.Map;

import com.model2.mvc.service.domain.ReservationInfo;

public interface ReservationInfoService {

	public void addReservation(ReservationInfo reservationinfo) throws Exception;

	public Map<String, Object> getReservationList() throws Exception;

	public ReservationInfo getReservation(int rvNumber) throws Exception;

	public void updateReservation(ReservationInfo reservationinfo) throws Exception;

}
