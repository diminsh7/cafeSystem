package com.caffeesys.cafesystem.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTitleService {
	@Autowired
	private AccountTitleDao accountTitleDao;
	public int insertAccountTitle(AccountTitle accountTitle) {
		System.out.println("AccountTitleService.java / AccountTitle Param accountTitle :" + accountTitle);
		return accountTitleDao.insertAccountTitle(accountTitle);
	}
}
