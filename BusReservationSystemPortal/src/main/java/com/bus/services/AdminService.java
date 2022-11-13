package com.bus.services;

import com.bus.bean.Admin;
import com.bus.exceptions.AdminException;

public interface AdminService {
	
	public Admin createAdmin(Admin admin)throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key)throws AdminException;
}
