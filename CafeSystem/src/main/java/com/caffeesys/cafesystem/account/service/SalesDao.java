package com.caffeesys.cafesystem.account.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDao implements SalesDaoInter {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private final String NS = "com.caffeesys.cafesystem.account.service.SalesMapper.";
	
	@Override
	public List<DailySalesVO> selectDailySalesList() {
		List<DailySalesVO> result = sqlSession.selectList(NS+"selectDailySalesList");
		return result;
	}

}
