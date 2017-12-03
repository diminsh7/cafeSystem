package com.caffeesys.cafesystem.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadEmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(HeadEmployeeService.class);
	
	@Autowired
	private HeadEmployeeDao headDao;

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
	};

}
