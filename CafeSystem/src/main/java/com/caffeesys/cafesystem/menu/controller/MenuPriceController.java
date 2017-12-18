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
	
	//메뉴 가격 리스트, 검색, 카테고리 세션 SET
	@RequestMapping("/menuPriceList")
	public String menuPriceList(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		System.out.println("[MenuPriceController.java / menuPriceList.method] Loading");
		menuPriceService.menuPriceList(model, currentPage, cate, input);
		return "menu/menuPriceList";
	}
	
	//메뉴 가격 리스트, 검색, 카테고리 세션 SET (지정용)
	@RequestMapping("/branchMenuPriceList")
	public String branchMenuPriceList(Model model
			, @RequestParam(value="cate", required=false) String cate
			, @RequestParam(value="input", required=false) String input
			, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
		System.out.println("[MenuPriceController.java / branchMenuPriceList.method] Loading");
		menuPriceService.menuPriceList(model, currentPage, cate, input);
		return "menu/branchMenuPriceList";
	}
	
	//메뉴 가격 입력 폼 요청
	@RequestMapping("menuPriceInsert")
	public String menuPriceInsert(Model model) {
		menuPriceService.menuNameSelect(model);
		return "menu/menuPriceInsertForm";
	}
	
	//메뉴 가격 입력 처리
	@RequestMapping(value = "menuPriceInsert", method = RequestMethod.POST)
	public String menuPriceInsert(MenuPriceVO menuPrice) {
		System.out.println("[MenuPriceController.java / menuPriceInsert.method] Access");
		menuPriceService.menuPriceInsert(menuPrice);
		return "redirect:/menuPriceList";
	}
	
	//메뉴 코드 자동 등록
	@ResponseBody
	@RequestMapping(value = "menuCodeInsert")
	public String menuCodeInsert(@RequestParam(value = "menuName") String menuName) { //여기서 메뉴명 미입력을 막을 수는 없을까
		System.out.println("[MenuPriceController.java / menuCodeInsert.method] Ajax success");
		//System.out.println("[MenuPriceController.java / menuCodeInsert.method] menuName param : " + menuName);
		return menuPriceService.menuCodeInsert(menuName);
	}
	
	//메뉴 원가 자동 등록
	@ResponseBody
	@RequestMapping(value = "materialInsert")
	public String materialInsert(@RequestParam(value = "tempCate") String tempCate
			,@RequestParam(value = "sizeCate") String sizeCate
			,@RequestParam(value = "menuName") String menuName) {
		System.out.println("[MenuPriceController.java / materialInsert.method] Ajax success");
		//System.out.println("[MenuPriceController.java / materialInsert.method] tempCate param : " + tempCate);
		//System.out.println("[MenuPriceController.java / materialInsert.method] sizeCate param : " + sizeCate);
		return menuPriceService.materialInsert(tempCate, sizeCate, menuName);
	}
	
	//메뉴 가격 삭제 처리
	@RequestMapping(value = "menuPriceDelete")
	public String menuPriceDelete(@RequestParam(value = "menuPriceCode", required=true) int menuPriceCode) {
		menuPriceService.menuPriceDelete(menuPriceCode);
		return "redirect:/menuPriceList";
	}
	//메뉴 가격 수정 폼 요청
	@RequestMapping(value = "menuPriceUpdate", method = RequestMethod.GET)
	public String menuPriceUpdate(Model model
			, @RequestParam(value = "menuPriceCode", required=true) int menuPriceCode) {
		menuPriceService.menuPriceUpdateForm(model, menuPriceCode);
		return "menu/menuPriceUpdateForm";
	}
	
	//메뉴 가격 수정 처리
	@RequestMapping(value = "menuPriceUpdate", method = RequestMethod.POST)
	public String menuPriceUpdate(MenuPriceVO menuPrice) {
		menuPriceService.menuPriceUpdate(menuPrice);
		return "redirect:/menuPriceList";
	}
}
