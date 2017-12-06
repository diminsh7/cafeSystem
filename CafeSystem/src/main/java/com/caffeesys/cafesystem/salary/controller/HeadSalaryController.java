package com.caffeesys.cafesystem.salary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.salary.service.HeadSalaryService;

@Controller
public class HeadSalaryController {
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryController.class);
	
	@Autowired 
	private HeadSalaryService headSalaryService;
	
	//본사직원 급여명세서 목록
	@RequestMapping(value="/headSalaryList")
	public String headhSalaryList(Model model
			, @RequestParam(value="keyword1", required=false, defaultValue="")String keyword1
			, @RequestParam(value="keyword2", required=false)String keyword2
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {
		logger.debug("headhSalaryList메소드 확인");
		headSalaryService.headSalaryList(model, keyword1, keyword2, currentPage);
		return "salary/headSalaryList";
	}
}
