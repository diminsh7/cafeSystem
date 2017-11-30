package com.caffeesys.cafesystem.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.item.service.ItemDao;
import com.caffeesys.cafesystem.item.service.ItemService;
import com.caffeesys.cafesystem.item.service.ItemVO;

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
		return "/item/itemList";
	}
	// 발주품목등록 페이지요청
	@RequestMapping(value="/insertItem", method = RequestMethod.GET)
	public String insertItem(Model model) {
		System.out.println("ItemController.java / insertItem method GET방식 ");
		List<ItemVO> CategoryItemList = itemDao.selectItemCategorySmall();
		model.addAttribute("CategoryItemList",CategoryItemList);
		return "/item/itemInsertForm";
	}
	// 발주품목등록(액션)요청
	@RequestMapping(value="/insertItem", method = RequestMethod.POST)
	public String insertItem(ItemVO item) {
		System.out.println("ItemController.java / insertItem method POST방식 " + item);
		itemService.insertItem(item);
		return "redirect:/itemList";
	}
}
