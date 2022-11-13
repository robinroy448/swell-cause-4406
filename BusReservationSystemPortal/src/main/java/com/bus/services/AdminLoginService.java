package com.bus.services;

import com.bus.DTO.AdminLoginDTO;
import com.bus.bean.CurrentAdminSession;
import com.bus.exceptions.LoginException;

public interface AdminLoginService {
	
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException;
}
