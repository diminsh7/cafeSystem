package com.caffeesys.cafesystem.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.shop.service.Contract;
import com.caffeesys.cafesystem.shop.service.ContractDao;
import com.caffeesys.cafesystem.shop.service.ContractService;

@Controller
public class ContractController {
	@Autowired
	private ContractService contractService;
	private ContractDao contractDao;
	
	// 계약서등록 페이지요청
	@RequestMapping(value="/insertContract", method = RequestMethod.GET)
	public String insertContract() {
		System.out.println("ContractController.java / insertContract method get방식 ");
		return "/shop/contractInsertForm";
	}
	// 계약서등록 (액션)요청
	@RequestMapping(value="/insertContract", method = RequestMethod.POST)
	public String insertContract(Contract contract) {
		System.out.println("ContractController.java / insertContract method : insert proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contract);
		contractService.insertContract(contract);
		return "redirect:/contractList";
	}
	// 전체계약서조회 상세전
	@RequestMapping(value="/contractList")
	public String listContract(Model model) {
		System.out.println("ContractController.java / listContract method 확인");
		contractService.listContract(model);
		return "/shop/contractList";
	}
	/*// 전체계약서조회 상세전
	@RequestMapping(value = { "/contractList" }, method = RequestMethod.GET)
	public String listContract(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		int contractCount = contractDao.selectContractCount();
		int pagePerRow = 10;
		int lastPage = (int) (Math.ceil(contractCount / pagePerRow));
		List<Contract> list = contractDao.selectContractList(currentPage, pagePerRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("contractCount", contractCount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		return "/shop/contractList";
	}*/
	// 계약서수정 페이지요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.GET)
	public String updateContract(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ContractController.java / updateContract method get방식 ");
		Contract contract = contractDao.selectContractUpdate(contractCode);
		model.addAttribute("contract", contract);
		return "/shop/updateContract";
	}
	// 계약서수정 (액션)요청
	@RequestMapping(value = "/updateContract", method = RequestMethod.POST)
	public String updateContract(Contract contract) {
		System.out.println("ContractController.java / updateContract method : insert proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contract);
		contractDao.updateContract(contract);
		return "redirect:/contractDetail?contractCode=" + contract.getContractCode();
	}
}
