package com.caffeesys.cafesystem.account.service;

import java.util.List;

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
		System.out.println("AccountTitleDao.java / insertAccountTitle Param accountTitle: "+accountTitle);
		return sqlSessionTemplate.insert(NS+"insertAccountTitle", accountTitle);
	}
	
	//account_title_code의 최대값 갖고오기
	public int selectAccountMax() {
		System.out.println("AccountTitleDao.java / selectAccountMax method 확인");
		
		return sqlSessionTemplate.selectOne(NS+"selectAccountMax");
	}
	
	//계정과목 list select
	public List<AccountTitle> selectAccountTitleList(){
		System.out.println("AccountTitleDao.java / selectAccountTitleList method 확인");
		System.out.println("AccountTitleDao.java / selectAccountTitleList 잘받아왔나 확인"
				+sqlSessionTemplate.selectList(NS+"selectAccountTitleList"));
		return sqlSessionTemplate.selectList(NS+"selectAccountTitleList");
	}
}
