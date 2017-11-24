package com.caffeesys.cafesystem.account.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AccountTitleService {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleService.class);
	
	@Autowired
	private AccountTitleDao accountTitleDao;
	//검색한 계정과목 전체 목록 
	public List<AccountTitleVO> listAll(String searchOption, String keyword){
		logger.debug("listAll메소드의 searchOption :{}",searchOption);	//all, account_title_code, account_title_name, account_title_content
		logger.debug("listAll메소드의 keyword :{}",keyword);	//검색어
		return accountTitleDao.listAll(searchOption,keyword);
	}
	
	//검섹힌 계정과목 레코드 개수 
	public int countArticle(String searchOption, String keyword) {
		logger.debug("countArticle메소드의 리턴값 :{}",accountTitleDao.countArticle(searchOption,keyword));
		return accountTitleDao.countArticle(searchOption,keyword);
	}
	
	//accountTitleList의 행의 개수
	public int getAccountTitleCount() {
		int accountTitleCount = 0;
		logger.debug("getAccountTitleCount메소드 확인");
		accountTitleCount = accountTitleDao.getAccountTitleCount();
		logger.debug("getAccountTitleCount메솓의 accountTitleCount :{}",accountTitleCount);
		return accountTitleCount;		
	}
	
	//현재페이지의 행의수를 리스트
	public List<AccountTitleVO> selectAccountTitleList(int currentPage,int pagePerRow) {
		List<AccountTitleVO> list = accountTitleDao.selectAccountTitleList(currentPage, pagePerRow);
		logger.debug("selectAccountTitleList메솓의 list :{}",list);
		return list;
	}
	//계정과목 삭제
	public void deleteAccountTitle(String accountTitleCode) {
		logger.debug("deleteAccountTitle메소드의 accountTitleCode :{}",accountTitleCode);
		accountTitleDao.deleteAccountTitle(accountTitleCode);
	}
	
	//계정과목 수정한값 update
	public void updateAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("updateAccountTitle메소드의 입력값 accountTitleVo :{}",accountTitleVo);
		accountTitleDao.updateAccountTitle(accountTitleVo);
	}
	
	//계정과목 update하기위해 select 
	public AccountTitleVO selectAccountTitle(String accountTitleCode) {
		logger.debug("selectAccountTitle메소드의 accountTitleCode 잘 받았나 확인 :{}", accountTitleCode);
		AccountTitleVO accountTitleVo = accountTitleDao.selectAccountTitle(accountTitleCode);		
		logger.debug("selectAccountTitle의 리턴값 : {}",accountTitleVo);
		return accountTitleVo;
	}

		
	//계정과목 등록 과정 
	public void insertAccountTitle(AccountTitleVO accountTitle) {
		logger.debug("insertAccountTitle 메소드의 accountTitle 확인 :{}",accountTitle);
		int accountmaxnum = accountTitleDao.selectAccountMax();
		logger.debug("insertAccountTitle 메소드의 리턴값 accountmaxnum 확인:{}",accountmaxnum);		
		String account_title_code_temp = "ACNT_";
		String accountcode = "ACNT_001";
		String result_no = null;
		int result = 0;
		int count = 0;
		if(accountmaxnum != 0) {
			result = accountmaxnum;
			logger.debug("insertAccountTitle 메소드 result1 :{}",result); //12
			result = result + 1;
			logger.debug("insertAccountTitle 메소드 result2 :{}",result); //13
			result_no = String.format("%03d", result);//자리수 맞추기
			logger.debug("insertAccountTitle 메소드 result3 :{}",result_no); //013
		}
		accountcode = account_title_code_temp+ result_no; //ACNT_ + 013
		logger.debug("insertAccountTitle 메소드 accountcode 확인 :{}"+ accountcode); //ACNT_013
		accountTitle.setAccountTitleCode(accountcode);			
		logger.debug("insertAccountTitle 메소드 accountTitle 확인 :{}"+accountTitle);
		count = accountTitleDao.insertAccountTitle(accountTitle);
	}
}
