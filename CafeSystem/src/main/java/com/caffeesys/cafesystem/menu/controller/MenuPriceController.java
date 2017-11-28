package com.caffeesys.cafesystem.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.menu.service.MenuPriceService;
import com.caffeesys.cafesystem.menu.service.MenuPriceVO;

@Controller
public class MenuPriceController {
	
	@Autowired
	MenuPriceService menuPriceService;
	
	//메뉴 가격 리스트/검색/카테고리 세션 SET
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
	public String menuPriceInsert() {
		return "menu/menuPriceInsertForm";
	}
	
	//메뉴 가격 입력 처리
	@RequestMapping(value = "menuPriceInsert", method = RequestMethod.POST)
	public String menuPriceInsert(MenuPriceVO menuPrice) {
		return "redirect:/menuPriceList";
	}
	
	// 메뉴 코드 자동 입력
	@ResponseBody
	@RequestMapping(value = "menuCodeInsert")
	public String menuCodeInsert(@RequestParam(value = "menuName") String menuName) {
		System.out.println("[MenuPriceController.java / menuCodeInsert.method] Ajax success");
		//System.out.println("[MenuPriceController.java / menuCodeInsert.method] menuName param : " + menuName);
		return menuPriceService.menuCodeInsert(menuName);
	}
}
