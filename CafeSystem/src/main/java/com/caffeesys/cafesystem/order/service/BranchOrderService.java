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
	
	//지점 발주 화면 요청 (첫화면 원두/티)
	public void branchOrderForm(Model model, String itemCate){
		//System.out.println("[BranchOrderService.java / branchOrderForm.method] Access");
		//불러올 리스트 조건 map에 담아서 dao 호출
		Map<String, String> map = new HashMap<String, String>();	
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
		String localCode = (String) localShopCode.get(0).get("local_category_code"); //지역코드
		String shopCode = (String) localShopCode.get(0).get("shop_code"); //매장코드
		
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
		Map<String, String> map = new HashMap<String, String>();	
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
	
}
