package com.model2.mvc.service.reservationcoach;

import java.util.List;

import com.model2.mvc.service.domain.ReservationCoach;

public interface ReservationCoachDao {

	public void addReservation(ReservationCoach reservationcoach) throws Exception;

	public List<ReservationCoach> getReservationList() throws Exception;

	public ReservationCoach getReservation(int rvNumber) throws Exception;

	public void updateReservation(ReservationCoach reservationcoach) throws Exception;

}
