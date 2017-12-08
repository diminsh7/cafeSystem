package com.caffeesys.cafesystem.salary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
	@RequestMapping(value="branchSalaryInsert")
	public String branchSalaryInsert(Model model) {
		branchSalaryService.branchCodeList(model);
		return "salary/branchSalaryInsertForm";	
	}
	
	//지점 직원 급여명세서 등록 처리
	@RequestMapping(value="branchSalaryInsert" , method = RequestMethod.POST)
	public String branchSalaryInsert(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryInsert메소드의  branchSalary :{}",branchSalary);
		branchSalaryService.branchSalaryInsert(branchSalary);
		return "redirect:/branchSalaryList";
	}
	
	//지점직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 직원코드를 눌렀을때 자동으로 입력
	@ResponseBody
	@RequestMapping(value="branchEmployeeSalaryInsert")
	public String branchEmployeeSalaryInsert(@RequestParam(value = "branchCodeList") String branchCodeList) {
		logger.debug("branchEmployeeSalaryInsert 메소드 확인 branchCodeList :{}", branchCodeList);
		return branchSalaryService.branchEmployeeSalaryInsert(branchCodeList);
	}	
	
	//지점직원 급여명세서 상세정보 보여주기 form
	@RequestMapping(value="branchSalaryDetail")
	public String branchSalaryDetail(Model model
			,@RequestParam(value="branchSalaryCode", required=true) String branchSalaryCode) {
		logger.debug("branchSalaryDetail메소드의 branchSalaryCode 확인 :{}",branchSalaryCode);
		branchSalaryService.selectBranchSalaryDetail(model, branchSalaryCode);
		return "/salary/branchSalaryDetailForm";
	}
	
	//지점직원 급여명세서 수정 폼
	@RequestMapping(value="branchSalaryUpdate")
	public String selectbranchSalaryUpdate(Model model
			,@RequestParam(value="branchSalaryCode", required=true) String branchSalaryCode) {
		logger.debug("branchSalaryUpdate메소드의 branchSalaryCode 확인 :{}",branchSalaryCode);
		branchSalaryService.selectbranchSalaryUpdate(model, branchSalaryCode);
		return "/salary/branchSalaryUpdateForm";
	}
	//지점직원 급여명세서 수정 처리
	@RequestMapping(value="branchSalaryUpdate", method = RequestMethod.POST )
	public String branchSalaryUpdate(BranchSalaryVO branchSalary) {
		logger.debug("branchSalaryUpdate 메소드의 branchSalary :{}",branchSalary);
		branchSalaryService.branchSalaryUpdate(branchSalary);
		return "redirect:/branchSalaryList";	
	}	
	//지점직원 급여명세서 삭제
}
