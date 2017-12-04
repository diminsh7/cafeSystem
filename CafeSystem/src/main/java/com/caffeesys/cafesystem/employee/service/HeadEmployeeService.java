package com.caffeesys.cafesystem.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.employee.controller.AllService;

@Service
public class HeadEmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(HeadEmployeeService.class);
	
	@Autowired
	private HeadEmployeeDao headDao;
	
	@Autowired
	private AllService allService;
	

	//본사직원 등록(직원코드 자동증가)
	public int insertHeadEmployee(HeadEmployeeVO headEmployeeVo) {
		logger.debug("[insertHeadEmployee] 실행");
		
		System.out.println("========[HeadEmployeeService.insertHeadEmployee 코드 구하기 시작]==========");
		int headEmployeeCodeMax = headDao.selectheadEmployeeCodeMax();
		System.out.println("headEmployeeCodeMax :" + headEmployeeCodeMax);
		String headEmployeeCodeTemp = "head_"; 
		String headEmployeeCode = "head_0001";
		String result_no = null;
		int result = 0;
		
		if(headEmployeeCodeMax != 0) {
			result = headEmployeeCodeMax;//ex)41
			System.out.println(" result(1) : " + result);
			result ++; //ex)42
			System.out.println(" result(2) : " + result);
			result_no = String.format("%04d", result); //ex)00042
			System.out.println(" result_no : " + result_no);
		}
		headEmployeeCode = headEmployeeCodeTemp + result_no;
		System.out.println("headEmployeeCode : " + headEmployeeCode);
		headEmployeeVo.setHeadEmployeeCode(headEmployeeCode);
		
		return headDao.insertHeadEmployee(headEmployeeVo);
	}

	//본사직원 조회 검색
	public void selectHeadEmployeeCount(Model model, String cate, String input) {
		logger.debug("[selectHeadEmployeeCount] 실행");
		System.out.println("cate :" + cate);
		System.out.println("input :" + input);
		Map<String, String> map;
		if(cate != "") {
			map = new HashMap<String, String>();
			map.put("cate", cate);
			map.put("input", input);
		} else {
			map = null;
		}
		
		map = allService.paging(model,map);
		List<HeadEmployeeVO> headEmployeeList = headDao.selectHeadEmployeeList(map);
		model.addAttribute("headEmployeeList",headEmployeeList);
		int headEmployeeCount = headDao.selectHeadEmployeeCount(); //본사직원인원
		model.addAttribute("headEmployeeCount",headEmployeeCount);
		
	};

}
