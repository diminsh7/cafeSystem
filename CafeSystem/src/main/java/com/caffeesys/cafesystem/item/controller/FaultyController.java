package com.caffeesys.cafesystem.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.item.service.FaultyDao;
import com.caffeesys.cafesystem.item.service.FaultyService;
import com.caffeesys.cafesystem.item.service.FaultyVO;

@Controller
public class FaultyController {
	
	@Autowired
	private FaultyService faultyService;
	@Autowired
	private FaultyDao faultyDao;
	
	// 불량품목리스트 및 조회 상세전
	@RequestMapping(value = "/faultyList")
	public String listFaulty(Model model
			,@RequestParam(value="searchOption", required=false, defaultValue="category_small")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		System.out.println("FaultyController.java / listFaulty method");
		System.out.println("FaultyController.java"+model);
		System.out.println("FaultyController.java"+searchOption);
		System.out.println("FaultyController.java"+keyword);
		System.out.println("FaultyController.java"+currentPage);
		faultyService.selectFaultyList(model, searchOption, keyword, currentPage);
		return "/item/faultyList";
	}
	// 불량품목등록 페이지요청
	@RequestMapping(value="/insertFaulty", method = RequestMethod.GET)
	public String insertFaulty(Model model) {
		System.out.println("FaultyController.java / insertFaulty method GET방식 ");
		List<FaultyVO> StatementNumberList = faultyDao.selectFaultyStatementNumber();
		List<FaultyVO> ItemNameList = faultyDao.selectFaultyItemName();
		List<FaultyVO> CategoryFaultyList = faultyDao.selectFaultyCategorySmall();
		model.addAttribute("StatementNumberList",StatementNumberList);
		model.addAttribute("ItemNameList",ItemNameList);
		model.addAttribute("CategoryFaultyList",CategoryFaultyList);
		return "/item/faultyInsertForm";
	}
	// 불량품목등록(액션)요청
	@RequestMapping(value="/insertFaulty", method = RequestMethod.POST)
	public String insertFaulty(FaultyVO faulty) {
		System.out.println("FaultyController.java / insertFaulty method POST방식 " + faulty);
		faultyService.insertFaulty(faulty);
		return "redirect:/faultyList";
	}
}
