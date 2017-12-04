package com.caffeesys.cafesystem.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.order.service.BranchOrderService;

@Controller
public class BranchOrderController {
	@Autowired
	BranchOrderService branchOrderService;
	
	//지점 발주 화면 요청 (첫화면 원두/티)
	@RequestMapping("branchOrderForm")
	public String branchOrderForm(Model model
			, @RequestParam(value="itemCate", required=false, defaultValue="601") String itemCate) {
		//System.out.println("[BranchOrderController.java / branchOrderForm.method] Access");
		branchOrderService.branchOrderForm(model, itemCate);
		return "order/BranchOrderForm";
	}
	
	//카테고리별 품목 요청
	@ResponseBody
	@RequestMapping(value = "branchOrder/itemSelect", produces = "application/text; charset=utf8")
	public String branchOrderForm(@RequestParam(value="itemCate", required=true) String itemCate) {
		System.out.println("카테고리 품목별로 가져오기");
		return branchOrderService.branchOrderForm(itemCate);
	}
}
