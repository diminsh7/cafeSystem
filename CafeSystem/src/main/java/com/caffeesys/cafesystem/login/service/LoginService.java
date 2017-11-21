package com.caffeesys.cafesystem.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	@Autowired
	private LoginDao loginDao;
	
	public LoginVO headLogin(LoginVO login) {
		logger.debug("headLogin method");
		return loginDao.headLogin(login);
	}
	public LoginVO branchLogin(LoginVO login) {
		logger.debug("branchLogin method");
		return loginDao.branchLogin(login);
	}
}
