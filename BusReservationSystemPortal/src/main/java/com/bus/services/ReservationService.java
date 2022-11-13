package com.bus.services;

import java.util.List;

import com.bus.DTO.ReservationDTO;
import com.bus.bean.Reservation;
import com.bus.exceptions.AdminException;
import com.bus.exceptions.BusException;
import com.bus.exceptions.ReservationException;
import com.bus.exceptions.UserException;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException , BusException,UserException ;
		
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, BusException, UserException;
	
	public Reservation viewReservation(Integer reservationId,String key) throws ReservationException, AdminException;
	
	public List<Reservation> viewAllReservation(String key)throws ReservationException;
	
	public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException;
	
}
