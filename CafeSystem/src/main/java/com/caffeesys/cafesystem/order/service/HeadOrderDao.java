package com.caffeesys.cafesystem.order.service;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeadOrderDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NS = "com.caffeesys.cafesystem.order.service.HeadOrderMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(HeadOrderDao.class);
	
	//본사 입장에서의 발주 리스트 페이지 요청 (취소신청, 취소승인 건 제외)
	public List<HeadOrderVO> headOrderList(){
		return sqlSessionTemplate.selectList(NS + "headOrderList");
	}
	
	//본사 입장의 발주 내용 상세보기 페이지 요청
	public List<HeadOrderVO> headOrderDetail(String statementNumber){
		return sqlSessionTemplate.selectList(NS + "headOrderDetail", statementNumber);
	}
	
	//headOrderList 페이징을 위한 글 갯수
	public int headOrderCount(Map<String, String> map) {
		return sqlSessionTemplate.selectOne(NS + "headOrderCount", map);
	}
	
	//발주승인
	public void headOrderPro(Map<String, String> map) {
		logger.debug("[HeadOrderDao.class / headOrderPro.method] map param: " + map);
		sqlSessionTemplate.update(NS + "headOrderPro");
	}
	
	//취소승인
	public void headOrderCancelPro(Map<String, String> map) {
		logger.debug("[HeadOrderDao.class / headOrderCancelPro.method] map param: " + map);
		sqlSessionTemplate.update(NS + "headOrderCancelPro");
	}
	
	//환불승인
	public void headOrderRefundPro(Map<String, String> map) {
		logger.debug("[HeadOrderDao.class / headOrderRefundPro.method] map param: " + map);
		sqlSessionTemplate.update(NS + "headOrderRefundPro");
	}
	
	//배송상태 변경
	public void headOrderDelivery(Map<String, String> map) {
		logger.debug("[HeadOrderDao.class / headOrderDelivery.method] map param: " + map);
		sqlSessionTemplate.update(NS + "headOrderDelivery");
	}
}
