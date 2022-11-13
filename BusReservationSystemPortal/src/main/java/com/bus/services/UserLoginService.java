package com.bus.services;

import com.bus.DTO.UserLoginDTO;
import com.bus.bean.CurrentUserSession;
import com.bus.exceptions.LoginException;

public interface UserLoginService {
	
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;
}
