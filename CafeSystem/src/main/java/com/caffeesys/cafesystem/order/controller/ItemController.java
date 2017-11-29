package com.caffeesys.cafesystem.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.order.service.ItemDao;
import com.caffeesys.cafesystem.order.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemDao itemDao;
	
	// 발주품목리스트 및 조회 상세전
	@RequestMapping(value = "/itemList")
	public String listItem(Model model
			,@RequestParam(value="searchOption", required=false, defaultValue="category_small")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		System.out.println("ItemController.java / listItem method");
		System.out.println("ItemController.java"+model);
		System.out.println("ItemController.java"+searchOption);
		System.out.println("ItemController.java"+keyword);
		System.out.println("ItemController.java"+currentPage);
		itemService.selectItemList(model, searchOption, keyword, currentPage);
		return "/order/itemList";
	}
}
