package com.caffeesys.cafesystem.item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	// 불량품목리스트 및 조회 상세전(본사)
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
	
	// 불량품목등록 페이지요청(지점)
	@RequestMapping(value="/insertFaulty", method = RequestMethod.GET)
	public String insertFaulty(Model model, @RequestParam(value = "orderCode", required = true) int orderCode) {
		System.out.println("FaultyController.java / insertFaulty method GET방식 ");
		FaultyVO StatementNumber = faultyDao.selectFaultyStatementNumber(orderCode);
		FaultyVO ItemCode = faultyDao.selectFaultyItemCode(orderCode);
		List<FaultyVO> CategoryFaultyList = faultyDao.selectFaultyCategorySmall();
		model.addAttribute("StatementNumber",StatementNumber);
		model.addAttribute("ItemCode",ItemCode);
		model.addAttribute("CategoryFaultyList",CategoryFaultyList);
		return "/item/faultyInsertForm";
	}
	// 불량품목등록(액션)요청(지점)
	@RequestMapping(value="/insertFaulty", method = RequestMethod.POST)
	public String insertFaulty(FaultyVO faulty) {
		System.out.println("FaultyController.java / insertFaulty method POST방식 " + faulty);
		faultyService.insertFaulty(faulty);
		return "redirect:/branchFaultyList";
	}
	// 불량품목상세조회(본사)
	@RequestMapping(value = "/faultyDetail", method = RequestMethod.GET)
	public String detailFaulty(Model model, @RequestParam(value = "faultyCode", required = true) int faultyCode) {
		System.out.println("FaultyController.java / detailFaulty method GET방식 " + faultyCode);
		FaultyVO faulty = faultyDao.selectFaulty(faultyCode);
		model.addAttribute("faulty", faulty);
		return "/item/faultyDetail";
	}
	// 불량품목수정 페이지요청(지점)
	@RequestMapping(value = "/updateFaulty", method = RequestMethod.GET)
	public String updateFaulty(Model model, @RequestParam(value = "faultyCode", required = true) int faultyCode) {
		System.out.println("FaultyController.java / updateFaulty method GET방식 " + faultyCode);
		FaultyVO faulty = faultyDao.selectFaulty(faultyCode);
		model.addAttribute("faulty", faulty);
		return "/item/faultyUpdateForm";
	}
	// 불량품목수정(액션)요청(지점)
	@RequestMapping(value = "/updateFaulty", method = RequestMethod.POST)
	public String updateFaulty(FaultyVO faulty) {
		System.out.println("FaultyController.java / updateFaulty method POST방식 " + faulty);
		faultyDao.updateFaulty(faulty);
		return "redirect:/branchFaultyList";
	}
	// 불량품목삭제 페이지요청(불량수량 입력)(지점)
	@RequestMapping(value = "/deleteFaulty", method = RequestMethod.GET)
	public String deleteFaulty(@RequestParam(value = "faultyCode", required = true) int faultyCode) {
		System.out.println("FaultyController.java / deleteFaulty method GET방식 " + faultyCode);
		return "/item/faultyDeleteForm";
	}
	// 불량품목삭제(액션)요청(지점)
	@RequestMapping(value = "/deleteFaulty", method = RequestMethod.POST)
	public String deleteFaulty(@RequestParam(value = "faultyCode", required = true) int faultyCode,
			@RequestParam(value = "faultyAmount", required = true) int faultyAmount) {
		System.out.println("FaultyController.java / deleteFaulty method POST방식 " + faultyCode);
		System.out.println("FaultyController.java / deleteFaulty method POST방식 " + faultyAmount);
		faultyDao.deleteFaulty(faultyCode, faultyAmount);
		return "redirect:/branchFaultyList";
	}
	
	// 불량품목상세조회(지점)
	@RequestMapping(value = "/branchFaultyList", method = RequestMethod.GET)
	public String branchFaultyList(Model model,HttpSession session) throws IOException{
		System.out.println("FaultyController.java / branchFaultyList method GET방식 ");
		faultyService.branchFaultyList(model, session);
		return "/item/branchFaultyList";
	}
}
