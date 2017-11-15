package com.caffeesys.cafesystem.account.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTitleDao {

	private final String NS = "com.caffeesys.cafesystem.account.service.AccountTitleMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//계정과목 등록
	public int insertAccountTitle(AccountTitle accountTitle) {
		return sqlSessionTemplate.insert(NS+"insertAccountTitle", accountTitle);
	}
}
