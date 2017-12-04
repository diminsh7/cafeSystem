package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
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
	@Override
	public List<MonthlySalesVO> selectMonthlySalesList() {
		List<MonthlySalesVO> result = sqlSession.selectList(NS+"selectMonthlySalesList");
		return result;
	}
	@Override
	public List<HashMap<String, Object>> selectDailyTop() {
		List<HashMap<String, Object>> result = sqlSession.selectList(NS+"selectDailyTop");
		return result;
	}
	@Override
	public List<HashMap<String, Object>> selectMonthlyTop() {
		List<HashMap<String, Object>> result = sqlSession.selectList(NS+"selectMonthlyTop");
		return result;
	}
	@Override
	public List<FeeVO> selectFeeList() {
		List<FeeVO> result = sqlSession.selectList(NS+"selectFeeList");
		return result;
	}
}
