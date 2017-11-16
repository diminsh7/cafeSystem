package com.caffeesys.cafesystem.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountTitleService {
	@Autowired
	private AccountTitleDao accountTitleDao;
	//계정과목 등록 과정 
	public int insertAccountTitle(AccountTitle accountTitle) {
			System.out.println("AccountTitleService.java/ insertAccountTitle method 확인");
			System.out.println("AccountTitleService.java / insertAccountTitle Param accountTitle :" + accountTitle);
			int accountmaxnum = accountTitleDao.selectAccountMax();
			System.out.println("AccountTitleService.java/ insertAccountTitle의 리턴값 accountmaxnum :" + accountmaxnum);		
			String account_title_code_temp = "ACNT_";
			String accountcode = "ACNT_001";
			String result_no = null;
			int result = 0;
			if(accountmaxnum != 0) {
				result = accountmaxnum;
				System.out.println("AccountTitleService.java/ insertAccountTitle result1 :"+result); //12
				result = result + 1;
				System.out.println("AccountTitleService.java/ insertAccountTitle result2 :"+result); //13
				result_no = String.format("%03d", result);//자리수 맞추기
				System.out.println("AccountTitleService.java/ insertAccountTitle result3 :"+result_no); //013
			}
			accountcode = account_title_code_temp+ result_no; //ACNT_ + 013
			System.out.println("accountcode : "+ accountcode); //ACNT_013
			accountTitle.setAccountTitleCode(accountcode);			
			System.out.println("AccountTitleService.java/ accountTitle:"+accountTitle);
			
			return accountTitleDao.insertAccountTitle(accountTitle);
		}
}
