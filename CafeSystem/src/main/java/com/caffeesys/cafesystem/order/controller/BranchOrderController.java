package com.caffeesys.cafesystem.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchOrderController {
	
	@RequestMapping("branchOrderForm")
	public String branchOrderForm() {
		System.out.println("");
		return "order/BranchOrderForm";
	}
}
