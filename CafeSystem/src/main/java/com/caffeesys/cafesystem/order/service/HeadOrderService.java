package com.caffeesys.cafesystem.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.caffeesys.cafesystem.CommonService;

import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class HeadOrderService {
	@Autowired
	HeadOrderDao headOrderdao;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	HttpSession session;
	
	private static final Logger logger = LoggerFactory.getLogger(HeadOrderService.class);
	
	//공통으로 사용되는 변수들 전역변수로 미리 정의
	Map<String, String> map = new HashMap<String, String>();
	
	
	/* 상태코드
	receiptCategoryCode 접수상태코드: 702발주신청완료, 703발주승인/결제완료, 704발주취소신청, 705발주취소승인
	orderCategoryCode 배송상태코드: 709배송준비중, 710배송중, 711배송완료*/
	
	//본사 입장에서의 발주 리스트 페이지 요청 (취소신청, 취소승인 건 제외)
	public void headOrderList(Model model, int currentPage, String cate, String input) {
		Map<String, String> map;
		if(cate != "") {
			map = new HashMap<String, String>();
			map.put("cate", cate);
			map.put("input", input);
		} else {
			map = null;
		}
		
		map = commonService.paging(model, currentPage, 4, headOrderdao.headOrderCount(map), map);	
		List<HeadOrderVO> headOrderList =  headOrderdao.headOrderList(map);
		logger.debug("[HeadOrderService.class / headOrderList.method] headOrderList param: " + headOrderList);
		model.addAttribute("headOrderList", headOrderList);
	}
	
	//본사 입장의 발주 내용 상세보기 페이지 요청
	public void headOrderDetail(Model model, String statementNumber) {
		List<HeadOrderVO> headOrder = headOrderdao.headOrderDetail(statementNumber);
		//해당 발주의 총계를 구하기 위해 각 품목의 수량대비 가격을 산출해 전부 합산
		int orderPriceAdd = 0;
		for(int i=0; i<headOrder.size(); i++) {
			int itemPrice = headOrder.get(i).getOrderPrice(); //품목별 가격 itemPrice
			orderPriceAdd += itemPrice;
			headOrder.get(i).setOrderPriceComma(commonService.comma(itemPrice)); //
		}	
		//3자리수마다 ,
		String orderAllPrice = commonService.comma(orderPriceAdd);
		
		//발주취소 내용 정보를 함께 표시하기 위한 정보 요청
		HeadOrderCancelVO headOrderCancel = headOrderdao.headOrderCancelDetail(statementNumber);
		System.out.println("--------------------------------------------" + headOrderCancel);

		model.addAttribute("headOrder", headOrder);
		model.addAttribute("statementNumber", statementNumber);
		model.addAttribute("orderAllPrice", orderAllPrice);
		model.addAttribute("headOrderCancel", headOrderCancel);
	}
	
	//본사 입장에서의 발주 취소 신청 리스트 페이지 요청 (취소건을 따로 관리하기 위함)
	public void headOrderCancelList(Model model, int currentPage, String cate, String input) {
		Map<String, String> map;
		if(cate != "") {
			map = new HashMap<String, String>();
			map.put("cate", cate);
			map.put("input", input);
		} else {
			map = null;
		}
		
		map = commonService.paging(model, currentPage, 2, headOrderdao.headOrderCancelCount(map), map);	
		List<HeadOrderCancelVO> headOrderCancelList =  headOrderdao.headOrderCancelList(map);
		logger.debug("[HeadOrderService.class / headOrderList.method] headOrderList param: " + headOrderCancelList);
		model.addAttribute("headOrderCancelList", headOrderCancelList);
	}
	
	//발주승인
	public void headOrderPro(String statementNumber) {
		LoginVO loginSession = (LoginVO) session.getAttribute("loginInfo");
		String headEmployeeCode = loginSession.getEmpCode();
		logger.debug("[HeadOrderService.class / headOrderPro.method] statementNumber param: " + statementNumber);
		
		String receiptCategoryCode = "703"; //발주승인/결제완료
		map.put("receiptCategoryCode", receiptCategoryCode);
		map.put("statementNumber", statementNumber);
		map.put("headEmployeeCode", headEmployeeCode);
		headOrderdao.headOrderPro(map);
	}
	
	//취소승인
	public void headOrderCancelPro(String statementNumber) {
		LoginVO loginSession = (LoginVO) session.getAttribute("loginInfo");
		String headEmployeeCode = loginSession.getEmpCode();
		logger.debug("[HeadOrderService.class / headOrderCancelPro.method] statementNumber param: " + statementNumber);
		
		String receiptCategoryCode = "705"; //발주취소승인
		map.put("receiptCategoryCode", receiptCategoryCode);
		map.put("statementNumber", statementNumber);
		map.put("headEmployeeCode", headEmployeeCode);
		headOrderdao.headOrderCancelPro(map);
	}
	
	//환불승인
	public void headOrderRefundPro(String statementNumber) {
		LoginVO loginSession = (LoginVO) session.getAttribute("loginInfo");
		String headEmployeeCode = loginSession.getEmpCode();
		logger.debug("[HeadOrderService.class / headOrderRefundPro.method] statementNumber param: " + statementNumber);
		
		//새로운  환불전표번호 생성, 환불 전표 코드 D
		//전표번호의 날짜에 해당하는 부분 생성
		String currentDate = commonService.dateSelect();
		//전표번호의 지역매장 코드에 해당하는 부분 생성
		String localShopCode = headOrderdao.localShopCode(statementNumber);
		
		//전표번호 생성
		String refundStatementNumber = currentDate + "-" + localShopCode + "-D" + "-01";
		System.out.println("-----------------------------------" + refundStatementNumber);
		
		String orderRefundAble = "Y";
		map.put("orderRefundAble", orderRefundAble);
		map.put("refundStatementNumber", refundStatementNumber);
		map.put("statementNumber", statementNumber);
		map.put("orderRefundAdmin", headEmployeeCode);
		headOrderdao.headOrderRefundPro(map);
	}
	
	//배송상태 변경
	public void orderDelivery(String statementNumber) {
		String orderDeliveryCode = "710";
		map.put("statementNumber", statementNumber);
		map.put("orderDeliveryCode", orderDeliveryCode);
		headOrderdao.headOrderDelivery(map);
	}
		
}
