package com.caffeesys.cafesystem.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.menu.service.MenuInfoDao;
import com.caffeesys.cafesystem.menu.service.MenuInfoService;
import com.caffeesys.cafesystem.menu.service.MenuInfoVO;

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
	// 메뉴등록 페이지요청
	@RequestMapping(value="/insertMenuInfo", method = RequestMethod.GET)
	public String insertMenuInfo(Model model) {
		System.out.println("MenuInfoController.java / insertMenuInfo method GET방식 ");
		List<MenuInfoVO> CategoryMenuList = menuInfoDao.selectMenuInfoCategorySmall();
		model.addAttribute("CategoryMenuList",CategoryMenuList);
		return "/menu/menuInfoInsertForm";
	}
	// 메뉴등록(액션)요청
	@RequestMapping(value="/insertMenuInfo", method = RequestMethod.POST)
	public String insertMenuInfo(MenuInfoVO menuInfo) {
		System.out.println("MenuInfoController.java / insertMenuInfo method POST방식 " + menuInfo);
		menuInfoService.insertMenuInfo(menuInfo);
		return "redirect:/menuInfoList";
	}
}
