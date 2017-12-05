package com.caffeesys.cafesystem.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.order.service.BranchOrderCommand;
import com.caffeesys.cafesystem.order.service.BranchOrderService;

@Controller
public class BranchOrderController {
	@Autowired
	BranchOrderService branchOrderService;
	
	//지점 발주 화면 요청 (첫화면 원두/티)
	@RequestMapping(value = "branchOrderForm", method = RequestMethod.GET)
	public String branchOrderForm(Model model
			, @RequestParam(value="itemCate", required=false, defaultValue="601") String itemCate) {
		//System.out.println("[BranchOrderController.java / branchOrderForm.method] Access");
		branchOrderService.branchOrderForm(model, itemCate);
		return "order/branchOrderForm";
	}
	
	//지점 발주 처리
	@RequestMapping(value = "branchOrderForm", method = RequestMethod.POST)
	public String branchOrderForm(BranchOrderCommand branchOrderCommand) {
		//System.out.println(branchOrderCommand);
		branchOrderService.branchOrderInsert(branchOrderCommand);
		return "order/BranchOrderRequestList";
	}
	
	//카테고리별 품목 요청
	@ResponseBody
	@RequestMapping(value = "branchOrder/itemSelect", produces = "application/text; charset=utf8")
	public String branchOrderForm(@RequestParam(value="itemCate", required=true) String itemCate) {
		//System.out.println("카테고리 품목별로 가져오기");
		return branchOrderService.branchOrderForm(itemCate);
	}
	
	//수량에 따른 가격 계산
	@ResponseBody
	@RequestMapping(value = "branchOrder/itemPriceCal")
	public String itemPriceCal(@RequestParam(value="itemCount", required=true) int itemCount
			, @RequestParam(value="itemCodeSelect", required=true) String itemCodeSelect) {	
		return branchOrderService.itemPriceCal(itemCount, itemCodeSelect);
	}
}
