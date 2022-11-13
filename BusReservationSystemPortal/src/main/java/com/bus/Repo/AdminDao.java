package com.bus.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.bean.Admin;


public interface AdminDao extends JpaRepository<Admin, Integer> {

	
	public Admin findByMobileNumber(String mobileNumber);
	
}
