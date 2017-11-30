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
}
