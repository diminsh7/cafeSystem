package com.caffeesys.cafesystem.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.order.service.HeadOrderService;

@Controller
public class HeadOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadOrderController.class);
	
	@Autowired
	HeadOrderService headOrderService;
	
	//본사 입장에서의 발주 리스트 요청
	@RequestMapping("headOrderList")
	public String headOrderList(Model model) {
		logger.debug("[HeadOrderController.java / headOrderList.method] Access");
		headOrderService.headOrderList(model);
		return "order/headOrderList";
	}
	
	//발주승인
	@RequestMapping("headOrder")
	public String headOrderPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / headOrderPro.method] Access");
		headOrderService.headOrderPro(statementNumber);
		return "redirect:order/headOrderList";
	}
	
	//취소승인(order_cancel 테이블로 입력)
	@RequestMapping("headOrderCancel")
	public String orderCancelPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / orderCancelPro.method] Access");
		headOrderService.headOrderCancelPro(statementNumber);
		return "redirect:order/headOrderList";
	}
	
	//환불승인
	@RequestMapping("headOrderRefund")
	public String orderRefundPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / orderRefundPro.method] Access");
		headOrderService.headOrderRefundPro(statementNumber);
		return "redirect:order/headOrderList";
	}
	
	//배송상태 변경 || orderDeliveryCode 변수명 주의 !! DB에는 order_category_code로 되어있음!
	@RequestMapping("headOrderDelivery")
	public String orderDelivery(@RequestParam(value="statementNumber", required=true) String statementNumber
			,@RequestParam(value="orderDeliveryCode", required=true) String orderDeliveryCode) {
		logger.debug("[HeadOrderController.class / orderDelivery.method] Access");
		headOrderService.orderDelivery(statementNumber, orderDeliveryCode);
		return "redirect:order/headOrderList";
	}
	
	//불량처리(Order 테이블에 새로운 전표번호가 발급되면서 Insert 되는 형식?)
}
