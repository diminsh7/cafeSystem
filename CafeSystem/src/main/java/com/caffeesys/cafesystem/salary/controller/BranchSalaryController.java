package com.caffeesys.cafesystem.salary.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.account.service.AccountTitleService;
import com.caffeesys.cafesystem.salary.service.BranchSalaryService;
import com.caffeesys.cafesystem.salary.service.BranchSalaryVO;

@Controller
public class BranchSalaryController {
	private static final Logger logger = LoggerFactory.getLogger(BranchSalaryController.class);
	@Autowired
	private BranchSalaryService branchSalaryService;
	//지점직원 급여명세서 목록
	@RequestMapping(value="/branchSalaryList")
	public String branchSalaryList(Model model
			, @RequestParam(value="keyword1", required=false, defaultValue="")String keyword1
			, @RequestParam(value="keyword2", required=false ) String keyword2
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {	
		logger.debug("BranchSalaryList메소드 확인");
		branchSalaryService.branchSalaryList(model, keyword1, keyword2, currentPage);
		/*logger.debug("branchSalaryList메소드 model :{}",model);
		logger.debug("branchSalaryList메소드 searchOption :{}",searchOption);
		logger.debug("branchSalaryList메소드 searchOption :{}",searchOption);
		logger.debug("branchSalaryList메소드 currentPage :{}",currentPage);*/
		return "salary/branchSalaryList";
	}
	
	//지점 직원 급여명세서 등록 폼 요청
	@RequestMapping(value="/branchSalaryInsert")
	public String branchSalaryInsert(Model model) {
		branchSalaryService.branchCodeList(model);
		return "salary/branchSalaryInsertForm";	
	}
	
	//
	@ResponseBody
	@RequestMapping(value="branchEmployeeSalaryInsert")
	public String branchEmployeeSalaryInsert(@RequestParam(value = "branchCodeList") String branchCodeList) {
		logger.debug("branchEmployeeSalaryInsert 메소드 확인 branchCodeList :{}", branchCodeList);
		return branchSalaryService.branchEmployeeSalaryInsert(branchCodeList);
	}
	
	//지점직원 급여명세서 등록 처리
	
	
	
	//지점직원 급여명세서 상세정보
	
	//지점직원 급여명세서 수정 폼
	
	//지점직원 급여명세서 수정처리
	
	//지점직원 급여명세서 삭제
	
	
	

}
