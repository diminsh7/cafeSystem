package com.caffeesys.cafesystem.salary.service;

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
import com.caffeesys.cafesystem.login.service.LoginVO;
import com.google.gson.Gson;


@Service
public class BranchSalaryService {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	PasingService pasingService;
	
	@Autowired
	BranchSalaryDao branchSalaryDao;
	
	Gson gson = new Gson();
	
	private static final Logger logger = LoggerFactory.getLogger(BranchSalaryService.class);
	
	//검색한 급여명세서 list 
	public void branchSalaryList(Model model,String keyword1, String keyword2, int currentPage) {
		logger.debug("branchSalaryList메소드 확인");
		Map<String, String> map;
		if(keyword1 != "") {
			map = new HashMap<String, String>();
			map.put("keyword1", keyword1);
			map.put("keyword2", keyword2);			
		}else {
			map = null;
		}
		logger.debug("branchSalaryList 메소드의  map :{}",map);//{keyword=2017-09, searchOption=branch_salary_workmonth}
		map = pasingService.paging(model, currentPage, 10, branchSalaryDao.branchSalaryCount(map), map);
		model.addAttribute("branchSalaryCount",branchSalaryDao.branchSalaryCount(map));
		model.addAttribute("branchSalaryList",branchSalaryDao.branchSalaryList(map));
	}
	
	//지점 직원 급여명세서 등록 폼에 쓸 직원 코드 가져오는 메소드
	public void branchCodeList(Model model){
		logger.debug("branchCodeList메소드 확인");
		LoginVO loginInfo = (LoginVO)session.getAttribute("loginInfo");
		logger.debug("branchCodeList 메소드의 loginInfo :{}",loginInfo); //로그인 정보 갖고오기
		String empCode = loginInfo.getEmpCode();
		//String position = loginInfo.getPosition();
		logger.debug("branchCodeList 메소드의 empCode :{}",empCode); //직원코드 갖고오기
		/*Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("empCode", empCode);
		map.put("position", position);*/
		List<LoginVO> branchCodeList = branchSalaryDao.branchCodeList(empCode);
		model.addAttribute("branchCodeList", branchCodeList);	//로그인한 매장의 직원코드 갖고오기
	}
	
	//지점직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 직원코드를 눌렀을때 자동으로 입력
	public String branchEmployeeSalaryInsert(String branchCodeList) {
		logger.debug("branchEmployeeSalaryInsert메소드 확인");
		logger.debug("branchEmployeeSalaryInsert메소드 확인 :{}",gson.toJson(branchSalaryDao.branchEmployeeSalaryInsert(branchCodeList)));
		return gson.toJson(branchSalaryDao.branchEmployeeSalaryInsert(branchCodeList));
	}
	
}
