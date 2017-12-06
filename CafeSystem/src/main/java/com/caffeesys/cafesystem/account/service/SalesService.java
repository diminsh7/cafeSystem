package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class SalesService implements SalesServiceInter {
	@Autowired
	private SalesDao salesDao;
	
	//본사의 지점 일매출 조회
	@Override
	public String selectDailySalesList() {
		List<DailySalesVO> list = salesDao.selectDailySalesList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//본사의 지점 월매출 조회
	@Override
	public String selectMonthlySalesList() {
		List<MonthlySalesVO> list = salesDao.selectMonthlySalesList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//본사의 지점 일매출 top5
	@Override
	public String selectDailyTop() {
		List<HashMap<String, Object>> list = salesDao.selectDailyTop();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//본사의 지점 월매출 top5
	@Override
	public String selectMonthlyTop() {
		List<HashMap<String, Object>> list = salesDao.selectMonthlyTop();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//지점의 일매출 조회
	@Override
	public String selectDailySalesListByShop(Map<String, Object> param) {
		List<DailySalesVO> list = salesDao.selectDailySalesListByShop(param);
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//지점의 월매출 조회
	@Override
	public String selectMonthlySalesListByShop(Map<String, Object> param) {
		List<MonthlySalesVO> list = salesDao.selectMonthlySalesListByShop(param);
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//본사의 가맹수수료 조회
	@Override
	public String selectFeeList() {
		List<FeeVO> list = salesDao.selectFeeList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	//지점의 가맹수수료 조회
	@Override
	public String selectFeeListByShop(Map<String, Object> param) {
		List<FeeVO> list = salesDao.selectFeeListByShop(param);
		Gson gson = new Gson();
		return gson.toJson(list);
	}
}