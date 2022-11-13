package com.bus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.bean.Reservation;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Integer>{
	
	
	
}
