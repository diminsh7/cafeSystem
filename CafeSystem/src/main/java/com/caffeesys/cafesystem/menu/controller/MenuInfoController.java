package com.caffeesys.cafesystem.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.menu.service.MenuInfoDao;
import com.caffeesys.cafesystem.menu.service.MenuInfoService;

@Controller
public class MenuInfoController {
	
	@Autowired
	private MenuInfoService menuInfoService;
	@Autowired
	private MenuInfoDao	menuInfoDao;
	
	// 메뉴리스트 및 조회 상세전
	@RequestMapping(value = "/menuInfoList")
	public String listMenuInfo(Model model
			,@RequestParam(value="searchOption", required=false, defaultValue="category_small")String searchOption
			,@RequestParam(value="keyword", required=false, defaultValue="") String keyword
			,@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {
		System.out.println("MenuInfoController.java / listMenuInfo method");
		System.out.println("MenuInfoController.java"+model);
		System.out.println("MenuInfoController.java"+searchOption);
		System.out.println("MenuInfoController.java"+keyword);
		System.out.println("MenuInfoController.java"+currentPage);
		menuInfoService.selectMenuInfoList(model, searchOption, keyword, currentPage);
		return "/menu/menuInfoList";
	}
}
