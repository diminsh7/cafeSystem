package com.caffeesys.cafesystem.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.shop.service.*;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	// 계약서등록 페이지요청
	@RequestMapping(value = "/selectContractMax", method = RequestMethod.GET)
	public String insertContract() {
		System.out.println("ContractController.java / insertContract method get방식 ");
		return "/shop/contractInsertForm";
	}
	// 계약서등록(액션) 요청
	@RequestMapping(value = "/selectContractMax", method = RequestMethod.POST)
	public String insertContract(Contract contract) {
		System.out.println("ContractController.java / insertContract method] : insert proccess");
		System.out.println("ContractController.java / Contract Param contract : " + contract);
		contractService.insertContract(contract);
		return "redirect:/contractList";	// = response.sendRedirect("/contractList");
	}
}
