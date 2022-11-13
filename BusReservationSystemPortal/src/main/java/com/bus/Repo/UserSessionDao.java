package com.bus.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.bean.CurrentUserSession;


public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer> {
	
	
	public CurrentUserSession findByUuid(String uuid);
	
}
