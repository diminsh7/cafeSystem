package com.caffeesys.cafesystem.order.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchOrderDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	final String NS = "com.caffeesys.cafesystem.order.service.BranchOrderMapper.";
	
	//지점 발주 화면 요청 & 카테고리별 품목 요청
	public List<BranchOrderVO> branchOrderForm(Map<String, String> map) {
		//System.out.print("[BranchOrderDao.java / branchOrderForm.method] Access");
		return sqlSessionTemplate.selectList(NS + "branchOrderForm", map);
	}
	
	//지점 발주 처리
	public int branchOrderInsert(BranchOrderAddVO branchOrderAdd) {
		System.out.println("branchOrderAdd: " + branchOrderAdd);
		return sqlSessionTemplate.insert(NS + "branchOrderAdd", branchOrderAdd);
	}
	
	//수량에 따른 가격 계산
	public int itemPriceCal(String itemCodeSelect) {
		return sqlSessionTemplate.selectOne(NS + "itemPriceCal", itemCodeSelect);
	}
}
