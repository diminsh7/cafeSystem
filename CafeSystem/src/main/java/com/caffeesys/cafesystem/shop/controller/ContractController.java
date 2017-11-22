package com.caffeesys.cafesystem.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caffeesys.cafesystem.shop.service.ContractVo;
import com.caffeesys.cafesystem.shop.service.ContractDao;
import com.caffeesys.cafesystem.shop.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private ContractDao contractDao;
	
	// 계약서등록 페이지요청
	@RequestMapping(value="/insertContract", method = RequestMethod.GET)
	public String insertContract() {
		System.out.println("ContractController.java / insertContract method get방식 ");
		return "/shop/contractInsertForm";
	}
	// 계약서등록(액션)요청
	@RequestMapping(value="/insertContract", method = RequestMethod.POST)
	public String insertContract(ContractVo contract) {
		System.out.println("ContractController.java / insertContract method : insert proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contract);
		contractService.insertContract(contract);
		return "redirect:/contractList";
	}
	// 전체계약서조회 상세전
	@RequestMapping(value = { "/contractList" }, method = RequestMethod.GET)
	public String listContract(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		System.out.println("ContractController.java / contractList method get방식 ");
		int contractCount = contractDao.selectContractCount();
		int pagePerRow = 10;
		int lastPage = (int) (Math.ceil(contractCount / pagePerRow));
		List<ContractVo> list = contractDao.selectContractList(currentPage, pagePerRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("contractCount", contractCount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		return "/shop/contractList";
	}
	// 계약서상세조회
	@RequestMapping(value = "/contractDetail", method = RequestMethod.GET)
	public String detailContract(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / detailContract method get방식 ");
		ContractVo contract = contractDao.selectContract(contractCode);
		model.addAttribute("contract", contract);
		return "/shop/contractDetail";
	}
	// 계약서수정 페이지요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.GET)
	public String updateContract(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / updateContract method get방식 ");
		ContractVo contract = contractDao.selectContract(contractCode);
		model.addAttribute("contract", contract);
		return "/shop/contractUpdateForm";
	}
	// 계약서수정(액션)요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.POST)
	public String updateContract(ContractVo contract) {
		System.out.println("ContractController.java / updateContract method : update proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contract);
		contractDao.updateContract(contract);
		return "redirect:/contractDetail?contractCode=" + contract.getContractCode();
	}
	// 계약서삭제 페이지요청(소유자명 입력)
	@RequestMapping(value = "/deleteContract", method = RequestMethod.GET)
	public String deleteContract(@RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / deleteContract method get방식 ");
		return "/shop/contractDeleteForm";
	}
	// 계약서삭제(액션)요청
	@RequestMapping(value = "/deleteContract", method = RequestMethod.POST)
	public String deleteContract(@RequestParam(value = "contractCode", required = true) String contractCode,
			@RequestParam(value = "contractOwnerName", required = true) String contractOwnerName) {
		System.out.println("ContractController.java / deleteContract method : delete proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contractCode);
		contractDao.deleteContract(contractCode, contractOwnerName);
		return "redirect:/contractList";
	}
	// 계약서검색조회목록갯수
	@RequestMapping(value = "/contractList", method = RequestMethod.POST)
	public ModelAndView searchContract(@RequestParam(defaultValue="contractOwnerName") String searchOption, 
										@RequestParam(defaultValue="") String keyword) {
		List<ContractVo> list = contractService.searchContract(searchOption, keyword);
		int count = contractService.searchContractCount(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("shop/contractList");
		return mav;
	}
}
