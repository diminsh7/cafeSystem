package com.caffeesys.cafesystem.account.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountTitleDao {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleDao.class);

	private final String NS = "com.caffeesys.cafesystem.account.service.AccountTitleMapper.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//계정과목 수정한 값 update
	public int updateAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("updateAccountTitle 메소드의 입력값 accountTitleVo :{}",accountTitleVo);
		return sqlSessionTemplate.update(NS+"updateAccountTitle", accountTitleVo);
	}
	
	//계정과목 하나의 code넘겨서  계정과목코드에 대한 정보 select
	public AccountTitleVO selectAccountTitle(String accountTitleCode) {
		logger.debug("selectAccountTitle메소드의 입력값 accountTitleCode 잘받아왔나 확인 : {}",accountTitleCode);
		logger.debug("selectAccountTitle메소드의 mapper리턴:{}",sqlSessionTemplate.selectOne(NS+"selectAccountTitle", accountTitleCode));
		return sqlSessionTemplate.selectOne(NS+"selectAccountTitle", accountTitleCode);
	}
	
	//계정과목 list select
	public List<AccountTitleVO> selectAccountTitleList(){
		logger.debug("selectAccountTitleList메소드의 리턴값 잘받아왔나 확인{}",
				sqlSessionTemplate.selectList(NS+"selectAccountTitleList"));
		return sqlSessionTemplate.selectList(NS+"selectAccountTitleList");
	}
	
	//계정과목 등록
	public int insertAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("insertAccountTitle메소드의 accountTitle 잘받아왔나 확인 :{}"+accountTitleVo);
		return sqlSessionTemplate.insert(NS+"insertAccountTitle", accountTitleVo);
	}
	
	//account_title_code의 최대값 갖고오기
	public int selectAccountMax() {
		logger.debug("selectAccountMax 메도스 확인");
		
		return sqlSessionTemplate.selectOne(NS+"selectAccountMax");
	}
}
