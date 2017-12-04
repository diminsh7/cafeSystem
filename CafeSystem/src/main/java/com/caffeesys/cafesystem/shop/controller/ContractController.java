package com.caffeesys.cafesystem.shop.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.shop.service.ContractVo;
import com.caffeesys.cafesystem.shop.service.ContractDao;
import com.caffeesys.cafesystem.shop.service.ContractService;

@Controller
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	@Autowired
	private ContractDao contractDao;
	
	// 계약서리스트 및 조회 상세전
	@RequestMapping(value = "/contractList")
	public String listContract(Model model
			,@RequestParam(value="searchOption", required=false, defaultValue="all")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		System.out.println("ContractController.java / listContract method");
		System.out.println("ContractController.java"+model);
		System.out.println("ContractController.java"+searchOption);
		System.out.println("ContractController.java"+keyword);
		System.out.println("ContractController.java"+currentPage);
		contractService.selectContractList(model, searchOption, keyword, currentPage);
		return "/shop/contractList";
	}
	// 계약서등록 페이지요청
	@RequestMapping(value="/insertContract", method = RequestMethod.GET)
	public String insertContract() {
		System.out.println("ContractController.java / insertContract method GET방식 ");
		return "/shop/contractInsertForm";
	}
	// 계약서등록(액션)요청
	@RequestMapping(value="/insertContract", method = RequestMethod.POST)
	public String insertContract(ContractVo contract) {
		System.out.println("ContractController.java / insertContract method POST방식 " + contract);
		contractService.insertContract(contract);
		return "redirect:/contractList";
	}
	// 계약서상세조회
	@RequestMapping(value = "/contractDetail", method = RequestMethod.GET)
	public String detailContract(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / detailContract method GET방식 " + contractCode);
		ContractVo contract = contractDao.selectContract(contractCode);
		model.addAttribute("contract", contract);
		return "/shop/contractDetail";
	}
	// 계약서수정 페이지요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.GET)
	public String updateContract(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / updateContract method GET방식 " + contractCode);
		ContractVo contract = contractDao.selectContract(contractCode);
		model.addAttribute("contract", contract);
		return "/shop/contractUpdateForm";
	}
	// 계약서수정(액션)요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.POST)
	public String updateContract(ContractVo contract) {
		System.out.println("ContractController.java / updateContract method POST방식 " + contract);
		contractDao.updateContract(contract);
		return "redirect:/contractDetail?contractCode=" + contract.getContractCode();
	}
	// 계약서삭제 페이지요청(소유자명 입력)
	@RequestMapping(value = "/deleteContract", method = RequestMethod.GET)
	public String deleteContract(@RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / deleteContract method GET방식 " + contractCode);
		return "/shop/contractDeleteForm";
	}
	// 계약서삭제(액션)요청
	@RequestMapping(value = "/deleteContract", method = RequestMethod.POST)
	public String deleteContract(@RequestParam(value = "contractCode", required = true) String contractCode,
			@RequestParam(value = "contractOwnerName", required = true) String contractOwnerName) {
		System.out.println("ContractController.java / deleteContract method POST방식 " + contractCode);
		System.out.println("ContractController.java / deleteContract method POST방식 " + contractOwnerName);
		contractDao.deleteContract(contractCode, contractOwnerName);
		return "redirect:/contractList";
	}
	
	// 계약서상세조회(지점)
	@RequestMapping(value = "/branchContractList", method = RequestMethod.GET)
	public String branchContractList(Model model,HttpSession session) throws IOException{
		System.out.println("ContractController.java / branchContractList method GET방식 ");
		contractService.branchContractList(model, session);
		return "/shop/branchContractList";
	}
}
