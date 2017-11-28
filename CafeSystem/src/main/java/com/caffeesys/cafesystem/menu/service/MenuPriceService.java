package com.caffeesys.cafesystem.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.CommonService;
import com.caffeesys.cafesystem.category.service.CategoryService;
import com.google.gson.Gson;

@Service
public class MenuPriceService {
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	MenuPriceDao menuPriceDao;
	
	@Autowired
	HttpSession session;
	
	//메뉴 가격 등록 처리 (로그인 처리?)
	public void menuPriceInsert(MenuPriceVO menuPrice) {
		menuPriceDao.menuPriceInsert(menuPrice);
	}
	
	// 메뉴 가격 리스트
	public void menuPriceList(Model model, int currentPage, String cate, String input) {
		cateService.categorySelect(session, "temp", "size"); //http세션에 필요한 카테고리 set
		System.out.println("[MenuPriceService.java / menuPriceList.method] Category Session 등록 완료");
		Map<String, String> map;
		if(cate != "") {
			map = new HashMap<String, String>();
			map.put("cate", cate);
			map.put("input", input);
		} else {
			map = null;
		}
		
		map = commonService.paging(model, currentPage, 2, menuPriceDao.menuPriceCount(map), map);
		System.out.println("[MenuPriceService.java / menuPriceList.method] Paging 완료");
		List<MenuPriceVO> list = menuPriceDao.menuPriceList(map);
		model.addAttribute("menuPriceList", list);
		System.out.println("[MenuPriceService.java / menuPriceList.method] Complete");
		//session.setAttribute("top", "menuPrice");
	}
	
	//메뉴 코드 자동 등록
	public String menuCodeInsert(String menuName) {
		System.out.println("[MenuPriceService.java / menuCodeInsert.method] Access");
		//System.out.println("[MenuPriceService.java / menuCodeInsert.method] menuName param : " + menuName);
		Gson gson = new Gson();
		return gson.toJson(menuPriceDao.menuCodeInsert(menuName));
	}
	
	//메뉴 원가 자동 등록
	public String materialInsert(String tempCate, String sizeCate) {
		System.out.println("[MenuPriceService.java / materialInsert.method] Access");
		Map<String, String> map = new HashMap<String, String>();
		map.put("tempCate", tempCate);
		map.put("sizeCate", sizeCate);
		
		return "";
	}
}
