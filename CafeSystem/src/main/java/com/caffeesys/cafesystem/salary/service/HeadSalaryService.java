package com.caffeesys.cafesystem.salary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.account.controller.PasingService;
import com.caffeesys.cafesystem.employee.service.HeadEmployeeVO;
import com.google.gson.Gson;

@Service
public class HeadSalaryService {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryService.class);
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private PasingService pasingService;
	
	@Autowired
	private HeadSalaryDao headSalaryDao;
	
	Gson gson = new Gson();
	
	//검색한 급여명세서 list 
	public void headSalaryList(Model model,String keyword1, String keyword2, int currentPage) {
		logger.debug("headSalaryList메소드 확인");
		Map<String, String> map;
		if(keyword1 != "") {
			map = new HashMap<String, String>();
			map.put("keyword1", keyword1);
			map.put("keyword2", keyword2);			
		}else {
			map = null;
		}
		logger.debug("headSalaryList 메소드의  map :{}",map);//{keyword=2017-09, searchOption=head_salary_workmonth}
		map = pasingService.paging(model, currentPage, 10, headSalaryDao.headSalaryCount(map), map);
		model.addAttribute("headSalaryCount",headSalaryDao.headSalaryCount(map));
		model.addAttribute("headSalaryList",headSalaryDao.headSalaryList(map));
	}
	
	//본사 직원 급여명세서 등록 폼에 쓸 직원 코드 가져오는 메소드
	public void headCodeList(Model model){
		logger.debug("headCodeList메소드 확인");
		List<HeadEmployeeVO>  headCodeList = headSalaryDao.headCodeList();
		logger.debug("headCodeList메소드의 headCodeList :{}",headCodeList); 
		model.addAttribute("headCodeList", headCodeList);
	}	
	
	//본사직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 직원코드를 눌렀을때 자동으로 입력
	public String headEmployeeSalaryInsert(String headEmployeeCode) {		
		logger.debug("headEmployeeSalaryInsert메소드 확인 headEmployeeCode :{}",headEmployeeCode);
		String salary = headSalaryDao.headEmployeeSalaryInsert(headEmployeeCode);
		String bonusPer = headSalaryDao.headEmployeeBonusSelect(headEmployeeCode);
		List<String> salaryList = new ArrayList<String>();
		salaryList.add(salary);
		salaryList.add(bonusPer);
		logger.debug("headEmployeeSalaryInsert메소드 확인 :{}",gson.toJson(salaryList));
		return gson.toJson(salaryList);
	}
	
	//본사직원 급여명세서 등록 처리
	public void headSalaryInsert(HeadSalaryVO headSalary) {
		logger.debug("headSalaryInsert 메소드의 headSalary :{}",headSalary);
		
		//headSalaryWorkmonth 월로 갖고왔으니 data타입으로 변경 후 등록과정
				String headSalaryWorkmonth = headSalary.getHeadSalaryWorkmonth(); //2017-10 
				headSalaryWorkmonth = headSalaryWorkmonth+"-01";	//2017-10-01
				headSalary.setHeadSalaryWorkmonth(headSalaryWorkmonth);
				
		//지점직원 급여명세서코드 등록 과정
		int headSalaryCodeMax;
		int headSalaryCodeMidMax;
		int result = 0;
		int result2 = 0;
		String result_no = null;
		String result_no2 = null;
		String headSalaryCode = null;
		String head_salary_code = "_";
		String head_salary_code2 = "bsalary_";
		
		headSalaryCodeMax = headSalaryDao.headSalaryCodeMax();
		logger.debug("headSalaryInsert메소드의 headSalaryCodeMax:{}",headSalaryCodeMax);
		headSalaryCodeMidMax = headSalaryDao.headSalaryCodeMidMax();
		logger.debug("headSalaryInsert메소드의 headSalaryCodeMidMax:{}",headSalaryCodeMidMax);

		
		if(headSalaryCodeMax != 0 && headSalaryCodeMax < 9999) {
			result = headSalaryCodeMax;
			logger.debug("headSalaryInsert 메소드 result1 :{}",result);//22
			result = result + 1;
			logger.debug("headSalaryInsert 메소드 result2 :{}",result);//23
			result_no = String.format("%04d", result);	//자리수 맞추기
			logger.debug("headSalaryInsert 메소드 result_no :{}",result_no);//0023		
			result2 = headSalaryCodeMidMax;
			logger.debug("headSalaryInsert 메소드 result2-1 :{}",result2);	//1
			result_no2 = String.format("%03d", result2);	//자리수 맞추기		
			logger.debug("headSalaryInsert 메소드 result_no2 :{}",result_no2);//001			
		}else if(headSalaryCodeMax == 9999) {
			result = headSalaryCodeMax;
			logger.debug("headSalaryInsert 메소드 result1 :{}",result);//9999
			result = result - 9998;
			logger.debug("headSalaryInsert 메소드 result2 :{}",result);//1
			result_no = String.format("%04d", result);	//자리수 맞추기
			logger.debug("headSalaryInsert 메소드 result_no :{}",result_no);//0001			
			result2 = headSalaryCodeMidMax;
			logger.debug("headSalaryInsert 메소드 result2-1 :{}",result2);	//1
			result2 = result2 + 1;
			logger.debug("headSalaryInsert 메소드 result2-2 :{}",result2);	//2
			result_no2 = String.format("%03d", result2);	//자리수 맞추기		
			logger.debug("headSalaryInsert 메소드 result_no2 :{}",result_no2);//002
		}		
		headSalaryCode =head_salary_code2 + result_no2 +head_salary_code+ result_no;	//bsalary_001_0023
		logger.debug("headSalaryInsert 메소드 bSalaryCode :{}",headSalaryCode);	//bsalary_001_0023
		headSalary.setHeadSalaryCode(headSalaryCode);	
		logger.debug("headSalaryInsert 메소드의 headSalary :{}",headSalary);
		headSalaryDao.headSalaryInsert(headSalary);
	}
}

