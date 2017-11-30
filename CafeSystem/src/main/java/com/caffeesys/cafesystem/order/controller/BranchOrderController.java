package com.caffeesys.cafesystem.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caffeesys.cafesystem.order.service.BranchOrderService;

@Controller
public class BranchOrderController {
	@Autowired
	BranchOrderService branchOrderService;
	
	//지점 발주 화면 요청
	@RequestMapping("branchOrderForm")
	public String branchOrderForm() {
		System.out.println("[BranchOrderController.java / branchOrderForm.method] Access");
		branchOrderService.branchOrderForm();
		return "order/BranchOrderForm";
	}
}
