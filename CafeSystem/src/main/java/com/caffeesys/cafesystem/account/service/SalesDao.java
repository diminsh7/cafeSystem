package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDao implements SalesDaoInter {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private final String NS = "com.caffeesys.cafesystem.account.service.SalesMapper.";
	
	//본사의 지점 일매출 조회
	@Override
	public List<DailySalesVO> selectDailySalesList() {
		List<DailySalesVO> result = sqlSession.selectList(NS+"selectDailySalesList");
		return result;
	}
	//본사의 지점 월매출 조회
	@Override
	public List<MonthlySalesVO> selectMonthlySalesList() {
		List<MonthlySalesVO> result = sqlSession.selectList(NS+"selectMonthlySalesList");
		return result;
	}
	//본사의 지점 일매출 top5
	@Override
	public List<HashMap<String, Object>> selectDailyTop() {
		List<HashMap<String, Object>> result = sqlSession.selectList(NS+"selectDailyTop");
		return result;
	}
	//본사의 지점 월매출 top5
	@Override
	public List<HashMap<String, Object>> selectMonthlyTop() {
		List<HashMap<String, Object>> result = sqlSession.selectList(NS+"selectMonthlyTop");
		return result;
	}
	//지점의 일매출 조회
	@Override
	public List<DailySalesVO> selectDailySalesListByShop(Map<String, Object> param) {
		List<DailySalesVO> result = sqlSession.selectList(NS+"selectDailySalesListByShop", param);
		return result;
	}
	//지점의 월매출 조회
	@Override
	public List<MonthlySalesVO> selectMonthlySalesListByShop(Map<String, Object> param) {
		List<MonthlySalesVO> result = sqlSession.selectList(NS+"selectMonthlySalesListByShop", param);
		return result;
	}
	//지점의 월매출 그래프
	@Override
	public List<HashMap<String, Object>> selectMonthlyGraph(Map<String, Object> param) {
		List<HashMap<String, Object>> result = sqlSession.selectList(NS+"selectMonthlyGraph", param);
		return result;
	}
	//본사의 가맹수수료 조회
	@Override
	public List<FeeVO> selectFeeList() {
		List<FeeVO> result = sqlSession.selectList(NS+"selectFeeList");
		return result;
	}
	//지점의 가맹수수료 조회
	@Override
	public List<FeeVO> selectFeeListByShop(Map<String, Object> param) {
		List<FeeVO> result = sqlSession.selectList(NS+"selectFeeListByShop", param);
		return result;
	}
}
