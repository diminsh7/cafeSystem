package com.caffeesys.cafesystem.order.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BranchOrderRequestDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BranchOrderRequestDao.class);
	private final static String NS = "com.caffeesys.cafesystem.order.service.BranchOrderRequestMapper.";

	//리스트(1) 지역매장코드 확인
	public BranchOrderRequestVO selectLocalShopCode(String branchEmployeeCode) {
		logger.debug("[seleteLocalShopCode] 지역코드 매장코드 구하기 실행");	
		return sqlSessionTemplate.selectOne(NS + "seleteLocalShopCode",branchEmployeeCode);
	}
	
	//리스트(2) 리스트 가져오기
	public List<BranchOrderRequestVO> selectOderRequestList(BranchOrderRequestVO localShopCode) {
		logger.debug("[seleteOderRequestList] 매장에 따른 발주리스트 가져오기");	
		return  sqlSessionTemplate.selectList(NS + "selectOderRequestList",localShopCode);
	}
	
	//선택전표번호 상세조회
	public BranchOrderRequestVO selectOrderRequestDetail(int orderCode) {
		logger.debug("[selectOrderRequestDetail] 선택 전표번호 상세내용 가져오기 실행");
		
		return sqlSessionTemplate.selectOne(NS + "selectOrderRequestDetail",orderCode);		
	}

}
