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

@Controller
public class HeadSalaryController {
	private static final Logger logger = LoggerFactory.getLogger(HeadSalaryController.class);
	
	@Autowired 
	private HeadSalaryService headSalaryService;
	
	//본사직원 급여명세서 목록
	@RequestMapping(value="/headSalaryList")
	public String headhSalaryList() {
		logger.debug("headhSalaryList메소드 확인");
		return "salary/headSalaryList";
	}
	
	@ResponseBody
	@RequestMapping(value="/headSalaryListJson")
	public String JsonHeadSalaryList(@RequestParam(value="keyword1", required=false, defaultValue="")String keyword1
									,@RequestParam(value="keyword2", required=false)String keyword2) {
		logger.debug("JsonHeadSalaryList 메소드의 확인");
		String headSalaryList = headSalaryService.headSalaryList(keyword1, keyword2);
		logger.debug("JsonHeadSalaryList 메소드의 headSalaryList :{}",headSalaryList);
		return headSalaryList;
	}
}
