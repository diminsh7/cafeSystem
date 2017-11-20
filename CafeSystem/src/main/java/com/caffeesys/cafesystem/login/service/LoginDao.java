package com.caffeesys.cafesystem.login.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private final String NS = "com.caffeesys.cafesystem.login.service.LoginMapper.";
	
	public LoginVO headLogin(LoginVO login) {
		return sqlSession.selectOne(NS+"headLogin", login);
	}
	public LoginVO branchLogin(LoginVO login) {
		return sqlSession.selectOne(NS+"branchLogin", login);
	}
}
