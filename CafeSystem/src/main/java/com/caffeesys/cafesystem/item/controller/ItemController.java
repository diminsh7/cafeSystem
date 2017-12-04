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
	// 발주품목상세조회
	@RequestMapping(value = "/itemDetail", method = RequestMethod.GET)
	public String detailItem(Model model, @RequestParam(value = "itemCode", required = true) String itemCode) {
		System.out.println("ItemController.java / detailItem method GET방식 " + itemCode);
		ItemVO item = itemDao.selectItem(itemCode);
		model.addAttribute("item", item);
		return "/item/itemDetail";
	}
	// 발주품목수정 페이지요청
	@RequestMapping(value = "/updateItem", method = RequestMethod.GET)
	public String updateItem(Model model, @RequestParam(value = "itemCode", required = true) String itemCode) {
		System.out.println("ItemController.java / updateItem method GET방식 " + itemCode);
		ItemVO item = itemDao.selectItem(itemCode);
		model.addAttribute("item", item);
		return "/item/itemUpdateForm";
	}
	// 발주품목수정(액션)요청
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public String updateItem(ItemVO item) {
		System.out.println("ItemController.java / updateItem method POST방식 " + item);
		itemDao.updateItem(item);
		return "redirect:/itemDetail?itemCode=" + item.getItemCode();
	}
	// 발주품목삭제 페이지요청(메뉴명 입력)
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public String deleteItem(@RequestParam(value = "itemCode", required = true) String itemCode) {
		System.out.println("ItemController.java / deleteItem method GET방식 " + itemCode);
		return "/item/itemDeleteForm";
	}
	// 발주품목삭제(액션)요청
	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@RequestParam(value = "itemCode", required = true) String itemCode,
			@RequestParam(value = "itemName", required = true) String itemName) {
		System.out.println("ItemController.java / deleteItem method POST방식 " + itemCode);
		System.out.println("ItemController.java / deleteItem method POST방식 " + itemName);
		itemDao.deleteItem(itemCode, itemName);
		return "redirect:/itemList";
	}
	
	// 발주품목금지리스트 및 조회 상세전
	@RequestMapping(value = "/itemListX")
	public String listItemX(Model model
			,@RequestParam(value="searchOption", required=false, defaultValue="category_small")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		System.out.println("ItemController.java / listItemX method");
		System.out.println("ItemController.java"+model);
		System.out.println("ItemController.java"+searchOption);
		System.out.println("ItemController.java"+keyword);
		System.out.println("ItemController.java"+currentPage);
		itemService.selectItemListX(model, searchOption, keyword, currentPage);
		return "/item/itemListX";
	}
}
