package com.caffeesys.cafesystem.account.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class SalesService implements SalesServiceInter {
	@Autowired
	private SalesDao salesDao;
	
	@Override
	public String selectDailySalesList() {
		List<DailySalesVO> list = salesDao.selectDailySalesList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	@Override
	public String selectMonthlySalesList() {
		List<MonthlySalesVO> list = salesDao.selectMonthlySalesList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	@Override
	public String selectDailyTop() {
		List<HashMap<String, Object>> list = salesDao.selectDailyTop();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	@Override
	public String selectMonthlyTop() {
		List<HashMap<String, Object>> list = salesDao.selectMonthlyTop();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
	@Override
	public String selectFeeList() {
		List<FeeVO> list = salesDao.selectFeeList();
		Gson gson = new Gson();
		return gson.toJson(list);
	}
}