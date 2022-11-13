package com.bus.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
	
}
