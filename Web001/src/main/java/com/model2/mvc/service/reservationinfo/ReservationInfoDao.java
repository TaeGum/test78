package com.model2.mvc.service.reservationinfo;

import java.util.List;

import com.model2.mvc.service.domain.ReservationInfo;

public interface ReservationInfoDao {

	public void addReservation(ReservationInfo reservationinfo) throws Exception;

	public List<ReservationInfo> getReservationList() throws Exception;

	public ReservationInfo getReservation(int rvNumber) throws Exception;

	public void updateReservation(ReservationInfo reservationinfo) throws Exception;

}
