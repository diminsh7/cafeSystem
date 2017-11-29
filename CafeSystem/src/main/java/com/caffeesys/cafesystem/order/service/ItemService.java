package com.caffeesys.cafesystem.order.service;

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
}
