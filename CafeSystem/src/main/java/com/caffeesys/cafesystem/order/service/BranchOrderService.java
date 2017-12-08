package com.caffeesys.cafesystem.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.CommonService;
import com.google.gson.Gson;

@Service
public class BranchOrderService {
	
	@Autowired
	BranchOrderDao branchOrderDao;
	
	@Autowired
	CommonService commonservice;
	
	@Autowired
	BranchOrderRequestDao requestDao;
	
	@Autowired
	HttpSession session;
	
	Gson gson = new Gson();
	
	Map<String, String> map = new HashMap<String, String>();
	
	//지점 발주 화면 요청 (첫화면 원두/티)
	public void branchOrderForm(Model model, String itemCate){
		//System.out.println("[BranchOrderService.java / branchOrderForm.method] Access");
		//불러올 리스트 조건 map에 담아서 dao 호출	
		map.put("itemAble", "Y");
		map.put("cateMiddle", "Item");
		map.put("itemCate", itemCate);
		List<BranchOrderVO> branchOrderList = branchOrderDao.branchOrderForm(map);
		//결과값(리스트) model에 추가
		model.addAttribute("branchOrderList", branchOrderList);
	}
	
	//지점 발주 처리
	public void branchOrderInsert(BranchOrderCommand branchOrderCommand) {	
		//전표번호 규칙: 101205-001001-C-01 (연월일-지역매장코드-분류-숫자) *같은 날의 발주는 하나로 묶이기 때문에 마지막 숫자는 무조건 01이 된다. 
		//전표번호의 날짜에 해당하는 부분 생성
		String currentDate = commonservice.dateSelect();
		//전표번호의 지역매장 코드에 해당하는 부분 생성
		List<HashMap<String, Object>> localShopCode = commonservice.localShopCodeSelect();		
		System.out.println("localShopCode : " + localShopCode);
		String localCode = (String) localShopCode.get(0).get("local_category_code"); //지역코드
		System.out.println("localCode : " + localCode);
		String shopCode = (String) localShopCode.get(0).get("shop_code"); //매장코드
		System.out.println("shopCode : " + shopCode);
		//전표번호 생성
		String satatementNumber = currentDate + "-" + localCode + shopCode + "-C" + "-01";
		
		//발주 품목별로 가져와서 Insert
		List<String> itemCodeList = branchOrderCommand.getItemCode();
		List<Integer> orderAmountList = branchOrderCommand.getOrderAmount();
		List<Integer> orderPriceList = branchOrderCommand.getOrderPrice();
		for(int i=0; i<itemCodeList.size(); i++) {
			BranchOrderAddVO branchOrderAdd = new BranchOrderAddVO();
			branchOrderAdd.setStatementNumber(satatementNumber);
			branchOrderAdd.setOrderFaultyDivide("C");
			branchOrderAdd.setLocalCategoryCode(localCode);
			branchOrderAdd.setShopCode(shopCode);
			branchOrderAdd.setItemCode(itemCodeList.get(i));
			branchOrderAdd.setOrderAmount(orderAmountList.get(i));
			branchOrderAdd.setOrderPrice(orderPriceList.get(i));
			branchOrderAdd.setReceiptCategoryCode("702");
			branchOrderAdd.setOrderCategoryCode("709");
			branchOrderAdd.setOrderFaultyAble('N');
			branchOrderDao.branchOrderInsert(branchOrderAdd);		
		}
	}
	
	//카테고리별 품목 요청
	public String branchOrderForm(String itemCate){
		//불러올 리스트 조건 map에 담아서 dao 호출
		map.put("itemAble", "Y");
		map.put("cateMiddle", "Item");
		map.put("itemCate", itemCate);

		return gson.toJson(branchOrderDao.branchOrderForm(map));
	}
	
	//수량에 따른 가격 계산
	public String itemPriceCal(int itemCount, String itemCodeSelect) {
		int itemPrice = branchOrderDao.itemPriceCal(itemCodeSelect);
		int itemPriceResult = itemCount*itemPrice;
		return gson.toJson(itemPriceResult);
	}
	
	//발주 취소 신청
	public void branchOrderCancel(String statementNumber, String receiptCategoryCode, String orderCategoryCode) {
		/*receiptCategoryCode 접수상태코드: 702발주신청완료, 703발주승인/결제완료, 704발주취소신청, 705발주취소승인
		orderCategoryCode 배송상태코드: 709배송준비중, 710배송중, 711배송완료*/
		
		////발주 승인 전  발주 바로 취소 시킴
		if(receiptCategoryCode.equals("702")) {
			////취소테이블(order_cancel)로 들어가게 함 관리코드,전표번호,요청상태,취소신청일
			
			System.out.println("바로 발주 취소 시키는 상황");
			receiptCategoryCode = "705"; //바로 발주취소승인
			map.put("statementNumber", statementNumber);
			map.put("receiptCategoryCode", receiptCategoryCode);
			branchOrderDao.branchOrderCancel(map);
			branchOrderDao.insertBranchOrderDirectCancel(map);
			
		////발주승인이 되었고 배송준비중이 아니거나 배송준비중인 경우에는 본사담당직원의 승인 후 취소 처리
		} else if(receiptCategoryCode.equals("703")
				||(receiptCategoryCode.equals("703") && orderCategoryCode.equals("709"))) {
			
			System.out.println("발주취소신청으로 상태만 변경(취소신청이 들어간 상태)");
			receiptCategoryCode = "704"; //발주취소신청
			map.put("statementNumber", statementNumber);
			map.put("receiptCategoryCode", receiptCategoryCode);
			////버튼을 누르면 본사가 보는 발주 취소 테이블에 들어감
			branchOrderDao.insertBranchOrderCancel(map);
			branchOrderDao.branchOrderCancel(map);
		} 
	}
}
