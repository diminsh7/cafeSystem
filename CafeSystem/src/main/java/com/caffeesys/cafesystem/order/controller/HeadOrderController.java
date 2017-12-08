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
	
	//본사 입장에서의 발주 리스트 페이지 요청 (취소신청, 취소승인 건 제외)
	@RequestMapping("headOrderList")
	public String headOrderList(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		logger.debug("[HeadOrderController.java / headOrderList.method] Access");
		headOrderService.headOrderList(model, currentPage, cate, input);
		return "order/headOrderList";
	}
	
	//본사 입장의 발주 내용 상세보기 페이지 요청
	@RequestMapping("headOrderDetail")
	public String headOrderDetail(Model model
			, @RequestParam(value="statementNumber", required = true) String statementNumber) {
		logger.debug("[HeadOrderController.java / headOrderDetail.method] Access");
		headOrderService.headOrderDetail(model, statementNumber);
		return "order/headOrderDetail";
	}
	
	//본사 입장에서의 발주 취소 신청 리스트 페이지 요청 (취소건을 따로 관리하기 위함) -> Service부터 작업해야함 Controller만 있는 상태
	@RequestMapping("headOrderCancelList")
	public String headOrderCancelList(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		logger.debug("[HeadOrderController.java / headOrderList.method] Access");
		//headOrderService.headOrderList(model, currentPage, cate, input);
		return "order/headOrderCancelList";
	}
	
	//발주승인
	@RequestMapping("headOrder")
	public String headOrderPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / headOrderPro.method] Access");
		headOrderService.headOrderPro(statementNumber);
		return "redirect:/headOrderList";
		//return "redirect:/headOrderList";
	}
	
	//취소승인(order_cancel 테이블로 입력)
	@RequestMapping("headOrderCancel")
	public String orderCancelPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / orderCancelPro.method] Access");
		headOrderService.headOrderCancelPro(statementNumber);
		return "redirect:/headOrderList";
	}
	
	//환불승인
	@RequestMapping("headOrderRefund")
	public String orderRefundPro(@RequestParam(value="statementNumber", required=true) String statementNumber) {
		logger.debug("[HeadOrderController.class / orderRefundPro.method] Access");
		headOrderService.headOrderRefundPro(statementNumber);
		return "redirect:/headOrderList";
	}
	
	//배송상태 변경 || orderDeliveryCode 변수명 주의 !! DB에는 order_category_code로 되어있음!
	@RequestMapping("headOrderDelivery")
	public String orderDelivery(@RequestParam(value="statementNumber", required=true) String statementNumber
			,@RequestParam(value="orderDeliveryCode", required=true) String orderDeliveryCode) {
		logger.debug("[HeadOrderController.class / orderDelivery.method] Access");
		headOrderService.orderDelivery(statementNumber, orderDeliveryCode);
		return "redirect:/headOrderList";
	}
	
	//불량처리(Order 테이블에 새로운 전표번호가 발급되면서 Insert 되는 형식?)
}
