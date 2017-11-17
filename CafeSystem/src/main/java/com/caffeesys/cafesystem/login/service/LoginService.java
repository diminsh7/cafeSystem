package com.caffeesys.cafesystem.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	
	public Login headLogin(Login login) {
		return loginDao.headLogin(login);
	}
	public Login branchLogin(Login login) {
		return loginDao.branchLogin(login);
	}
}
