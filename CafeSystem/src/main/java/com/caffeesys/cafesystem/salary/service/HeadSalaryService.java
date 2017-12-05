package com.caffeesys.cafesystem.salary.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.account.controller.PasingService;
import com.google.gson.Gson;

@Service
public class HeadSalaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryService.class);
	
	@Autowired
	private PasingService pasingService;
	
	@Autowired
	private HeadSalaryDao headSalaryDao;
	
	
	public String headSalaryList(String keyword1, String keyword2) {
		logger.debug("headSalaryList메소드 확인");
		
		Map<String, String> map;
		if(keyword1 != "") {
			map = new HashMap<String, String>();
			map.put("keyword1", keyword1);
			map.put("keyword2", keyword2);			
		}else {
			map = null;
		}
		logger.debug("headSalaryList 메소드의  map :{}",map);
		//map = pasingService.paging(model, currentPage, 10, headSalaryDao.headSalaryCount(map), map);
		List<HeadSalaryVO> headSalaryList = headSalaryDao.headSalaryList(map);
		Gson gson = new Gson();
		return gson.toJson(headSalaryList);
		//model.addAttribute("headSalaryCount",headSalaryDao.headSalaryCount(map));
		//model.addAttribute("headSalaryList",headSalaryDao.headSalaryList(map));
	}

}
