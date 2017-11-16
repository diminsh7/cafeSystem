package com.caffeesys.cafesystem.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.shop.service.*;

@Controller
public class ContractController {
        
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private ContractService contractService;
	
	// 등록페이지 요청
	@RequestMapping(value = "/insertContract", method = RequestMethod.GET)
	public String insertContract() {
		System.out.println("ContractController.java / insertContract 폼 요청");
		return "/shop/contractInsertForm";
	}
	// 등록(액션) 요청
	@RequestMapping(value = "/insertContract", method = RequestMethod.POST)
	public String insertContract(Contract contract) {
		System.out.println("ContractController.java / insertContract 액션 요청");
		System.out.println(contract);
		contractService.insertContract(contract);
		/*contractService.insertContract(contract);
		return "redirect:/insertContract";*/
		return "";
	}
	// 전체계약서조회
	@RequestMapping(value = "/listContract")
	public String listContract(Model model) {
		System.out.println("ContractController.java / listContract Method");
		List<Contract> clist = contractDao.listContract();
		model.addAttribute("clist", clist);
		return "listContract";
	}
}
