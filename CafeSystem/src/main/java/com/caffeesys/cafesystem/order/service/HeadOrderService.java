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
	
	//본사 입장에서의 발주 리스트 요청
	public void headOrderList(Model model) {
		//아직 Mapper에 쿼리 없음
		List<HeadOrderCancelVO> headOrderList =  headOrderdao.headOrderList();
		logger.debug("[HeadOrderService.class / headOrderList.method] headOrderList param: " + headOrderList);
		model.addAttribute("headOrderList", headOrderList);
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
		List<HashMap<String, Object>> localShopCode = commonService.localShopCodeSelect();		
		String localCode = (String) localShopCode.get(0).get("local_category_code"); //지역코드
		String shopCode = (String) localShopCode.get(0).get("shop_code"); //매장코드
		
		//전표번호 생성
		String refundStatementNumber = currentDate + "-" + localCode + shopCode + "-D" + "-01";
		
		String orderRefundAble = "Y"; //환불완료 혹시 안들어가면 DB에 Char로 되어있는거 VarChar로 변경하기!!!!!!!!!!!!!!!!!!
		map.put("orderRefundAble", orderRefundAble);
		map.put("refundStatementNumber", refundStatementNumber);
		map.put("statementNumber", statementNumber);
		map.put("orderRefundAdmin", headEmployeeCode);
		headOrderdao.headOrderRefundPro(map);
	}
	
	//배송상태 변경
	public void orderDelivery(String statementNumber, String orderDeliveryCode) {
		logger.debug("[HeadOrderService.class / orderDelivery.method] statementNumber param: " + statementNumber);
		logger.debug("[HeadOrderService.class / orderDelivery.method] orderDeliveryCode param: " + orderDeliveryCode);
		map.put("statementNumber", statementNumber);
		map.put("orderDeliveryCode", orderDeliveryCode);
		headOrderdao.headOrderDelivery(map);
	}
		
}
