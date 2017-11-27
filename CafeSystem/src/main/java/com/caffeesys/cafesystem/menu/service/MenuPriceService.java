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
	
	// 메뉴 가격 등록 폼
	public void menuPriceInsert(Model model) {
		
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
		System.out.println("-----------------------------------------" +list);
		model.addAttribute("menuPriceList", list);
		System.out.println("[MenuPriceService.java / menuPriceList.method] Complete");
		//session.setAttribute("top", "menuPrice");
	}
}
