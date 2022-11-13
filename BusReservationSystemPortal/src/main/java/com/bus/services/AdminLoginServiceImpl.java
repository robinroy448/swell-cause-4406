package com.bus.services;

import java.time.LocalDateTime;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.DTO.AdminLoginDTO;
import com.bus.Repo.AdminDao;
import com.bus.Repo.AdminSessionDao;
import com.bus.bean.Admin;
import com.bus.bean.CurrentAdminSession;
import com.bus.exceptions.LoginException;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto) throws LoginException {

		Admin existingAdmin= adminDao.findByMobileNumber(dto.getMobileNumber());
		
		if(existingAdmin == null) throw new LoginException("Please Enter a valid mobile number!");
		
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  adminSessionDao.findById(existingAdmin.getAdminId());
		
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("Admin already Logged-In with this number");
		}
		
		if(existingAdmin.getAdminPassword().equals(dto.getAdminPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			adminSessionDao.save(currentAdminSession);

			return currentAdminSession;
		}
		else
			throw new LoginException("Please Enter a valid password!");
	}

	@Override
	public String logOutFromAdminAccount(String key) throws LoginException {

		CurrentAdminSession validAdminSession = adminSessionDao.findByUuid(key);
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this number");
			
		}
		
		adminSessionDao.delete(validAdminSession);
		
		return "Admin Logged Out !";
	}

}
