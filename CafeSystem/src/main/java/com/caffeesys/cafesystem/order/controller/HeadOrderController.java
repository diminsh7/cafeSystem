package com.caffeesys.cafesystem.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeadOrderController {
	//발주 승인
	@ResponseBody
	@RequestMapping("orderPro")
	public String orderPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		return "";
	}
	
	//취소승인
	@ResponseBody
	@RequestMapping("orderCancelPro")
	public String orderCancelPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		return "";
	}
	
	//환불승인
	@ResponseBody
	@RequestMapping("orderRefundPro")
	public String orderRefundPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		return "";
	}
	
	//불량처리(Order 테이블에 새로운 전표번호가 발급되면서 Insert 되는 형식?)
}
