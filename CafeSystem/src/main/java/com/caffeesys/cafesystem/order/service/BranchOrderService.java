package com.caffeesys.cafesystem.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.google.gson.Gson;

@Service
public class BranchOrderService {
	
	@Autowired
	BranchOrderDao branchOrderDao;
	
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
	
	//카테고리별 품목 요청
	public String branchOrderForm(String itemCate){
		//불러올 리스트 조건 map에 담아서 dao 호출
		Map<String, String> map = new HashMap<String, String>();	
		map.put("itemAble", "Y");
		map.put("cateMiddle", "Item");
		map.put("itemCate", itemCate);

		return gson.toJson(branchOrderDao.branchOrderForm(map));
	}
}
