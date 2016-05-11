package com.model2.mvc.service.reservationcoach;

import java.util.Map;

import com.model2.mvc.service.domain.ReservationCoach;

public interface ReservationCoachService {

	public void addReservation(ReservationCoach reservationcoach) throws Exception;

	public Map<String, Object> getReservationList() throws Exception;

	public ReservationCoach getReservation(int rvNumber) throws Exception ;

	public void updateReservation(ReservationCoach reservationcoach) throws Exception;

}
