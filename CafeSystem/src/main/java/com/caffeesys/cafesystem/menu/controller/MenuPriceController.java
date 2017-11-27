package com.caffeesys.cafesystem.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.menu.service.MenuPriceService;

@Controller
public class MenuPriceController {
	
	@Autowired
	MenuPriceService menuPriceService;
	
	@RequestMapping("/menuPriceList")
	public String menuPriceList(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		System.out.println("[MenuPriceController.java / menuPriceList.method] Loading");
		menuPriceService.menuPriceList(model, currentPage, cate, input);
		return "menu/menuPriceList";
	}
	
	//메뉴 가격 입력 폼 요청
	@RequestMapping("menuPriceInsert")
	public String menuPriceInsert(Model model) {
		return "menu/menuPriceInsertForm";
	}
	
}
