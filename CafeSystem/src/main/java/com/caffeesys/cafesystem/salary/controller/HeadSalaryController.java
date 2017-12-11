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

import com.caffeesys.cafesystem.salary.service.HeadSalaryService;
import com.caffeesys.cafesystem.salary.service.HeadSalaryVO;

@Controller
public class HeadSalaryController {
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryController.class);
	
	@Autowired 
	private HeadSalaryService headSalaryService;
	
	//삭제하기위해 로그인정보 갖고오기
	@ResponseBody
	@RequestMapping(value="getLoginInfoForDelete")
	public String SelectLoginInfoForDelete() {
		logger.debug("SelectLoginInfoForDelete메소드 확인");
		return headSalaryService.SelectLoginInfoForDelete();
	}
	
	//삭제처리
	@RequestMapping(value="headSalaryDelete")
	public String headSalaryDelete(@RequestParam(value="headSalaryCode", required=true)String headSalaryCode) {
		logger.debug("headSalaryDelete 메소드 확인");
		logger.debug("headSalaryDelete 메소드 headSalaryCode :{}",headSalaryCode);
		headSalaryService.headSalaryDelete(headSalaryCode);
		return"redirect:/headSalaryList";
	}
	
	//본사직원 급여명세서 목록
	@RequestMapping(value="/headSalaryList")
	public String headSalaryList(Model model
			, @RequestParam(value="keyword1", required=false, defaultValue="")String keyword1
			, @RequestParam(value="keyword2", required=false ) String keyword2
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {	
		logger.debug("headSalaryList메소드 확인");
		headSalaryService.headSalaryList(model, keyword1, keyword2, currentPage);
		/*logger.debug("headSalaryList메소드 model :{}",model);
		logger.debug("headSalaryList메소드 searchOption :{}",searchOption);
		logger.debug("headSalaryList메소드 searchOption :{}",searchOption);
		logger.debug("headSalaryList메소드 currentPage :{}",currentPage);*/
		return "salary/headSalaryList";
	}
	
	//본사 직원 급여명세서 등록 폼 요청
	@RequestMapping(value="headSalaryInsert")
	public String headSalaryInsert(Model model) {
		logger.debug("headSalaryInsert 메소드 확인");
		headSalaryService.headCodeList(model);
		return "/salary/headSalaryInsertForm";	
	}
	
	//본사 직원 급여명세서 등록 처리
	@RequestMapping(value="headSalaryInsert" , method = RequestMethod.POST)
	public String headSalaryInsert(HeadSalaryVO headSalary) {
		logger.debug("headSalaryInsert메소드의  headSalary :{}",headSalary);
		headSalaryService.headSalaryInsert(headSalary);
		return "redirect:/headSalaryList";
	}
	
	//본사직원 급여명세서 등록 폼에 쓸 직원 급여 가져오는 메소드 직원코드를 눌렀을때 자동으로 입력
	@ResponseBody
	@RequestMapping(value="headEmployeeSalaryInsert")
	public String headEmployeeSalaryInsert(@RequestParam(value = "headCodeList") String headCodeList) {
		logger.debug("headEmployeeSalaryInsert 메소드 확인 headCodeList :{}", headCodeList);
		return headSalaryService.headEmployeeSalaryInsert(headCodeList);
	}
	
	//본사직원 급여명세서 상세정보 보여주기 form
	@RequestMapping(value="headSalaryDetail")
	public String headSalaryDetail(Model model
			,@RequestParam(value="headSalaryCode", required=true)String headSalaryCode) {
		logger.debug("headSalaryDetail메소드 확인 headSalaryCode :{}",headSalaryCode);
		headSalaryService.selectHeadSalaryDetail(model,headSalaryCode);
		return "/salary/headSalaryDetailForm";
	}
	
	//본사직원 급여명세서 수정 폼
	@RequestMapping(value="headSalaryUpdate")
	public String selectHeadSalaryUpdate(Model model
			,@RequestParam(value="headSalaryCode", required=true) String headSalaryCode) {
		logger.debug("selectHeadSalaryUpdate메소드의 headSalaryCode 확인 :{}",headSalaryCode);
		headSalaryService.selectHeadSalaryUpdate(model, headSalaryCode);
		return "/salary/headSalaryUpdateForm";
	}
	//본사직원 급여명세서 수정 처리
	@RequestMapping(value="headSalaryUpdate", method = RequestMethod.POST )
	public String headSalaryUpdate(HeadSalaryVO headSalary) {
		logger.debug("headSalaryUpdate 메소드의 headSalary :{}",headSalary);
		headSalaryService.headSalaryUpdate(headSalary);
		return "redirect:/headSalaryList";	
	}

}
