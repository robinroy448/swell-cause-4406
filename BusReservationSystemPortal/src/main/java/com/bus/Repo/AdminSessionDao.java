package com.bus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.bean.CurrentAdminSession;


public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {

	public  CurrentAdminSession findByUuid(String uuid);

}
