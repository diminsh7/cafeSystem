package com.caffeesys.cafesystem.item.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.shop.service.AllJustService;

@Service
public class ItemService {
	
	@Autowired
	AllJustService allJustService; // 페이징 및 검색(shop.controller폴더에)
	@Autowired
	private ItemDao itemDao;
	
	// 발주품목리스트 및 조회 상세전
	public void selectItemList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("ItemService.java / selectItemList method 확인");
		System.out.println("ItemService.java / selectItemList Param model :" + model);
		System.out.println("ItemService.java / selectItemList Param searchOption :" + searchOption);
		System.out.println("ItemService.java / selectItemList Param keyword :" + keyword);
		System.out.println("ItemService.java / selectItemList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("ItemService.java"+map);
		map = allJustService.paging(model, currentPage, 10, itemDao.selectItemCount(map), map);
		model.addAttribute("itemList", itemDao.selectItemList(map));
		model.addAttribute("itemCount", itemDao.selectItemCount(map));
	}
	// 발주품목등록 과정
	public int insertItem(ItemVO item) {
		System.out.println("ItemService.java / insertItem method 확인");
		System.out.println("ItemService.java / insertItem Param item :" + item);
		int itemmaxnum = itemDao.selectItemMax();
		System.out.println("ItemService.java / insertItem의 리턴값 itemmaxnum :" + itemmaxnum);		
		String item_code_temp = "item_";
		String itemcode = "item_001";
		String result_no = null;
		int result = 0;
		if(itemmaxnum != 0) {
			result = itemmaxnum;
			System.out.println("ItemService.java / insertItem result1 :"+result);
			result = result + 1;
			System.out.println("ItemService.java / insertItem result2 :"+result);
			result_no = String.format("%03d", result); // 자리수 맞추기
			System.out.println("ItemService.java / insertItem result3 :"+result_no);
		}
		itemcode = item_code_temp+ result_no;
		System.out.println("itemcode : "+ itemcode);
		item.setItemCode(itemcode);
		System.out.println("ItemService.java / item:"+item);
		return itemDao.insertItem(item);
	}
	
	// 발주품목금지리스트 및 조회 상세전
	public void selectItemListX(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("ItemService.java / selectItemListX method 확인");
		System.out.println("ItemService.java / selectItemListX Param model :" + model);
		System.out.println("ItemService.java / selectItemListX Param searchOption :" + searchOption);
		System.out.println("ItemService.java / selectItemListX Param keyword :" + keyword);
		System.out.println("ItemService.java / selectItemListX Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("ItemService.java"+map);
		map = allJustService.paging(model, currentPage, 10, itemDao.selectItemCountX(map), map);
		model.addAttribute("itemListX", itemDao.selectItemListX(map));
		model.addAttribute("itemCountX", itemDao.selectItemCountX(map));
	}
}
