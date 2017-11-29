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
	
	Gson gson = new Gson();
	
	//메뉴 가격 등록 폼에 쓸 메뉴 이름 가져오는 메소드
	public void menuNameSelect(Model model) {
		List<String> menuNameList = menuPriceDao.menuNameSelect();
		model.addAttribute("menuNameList", menuNameList);
	}
	
	//메뉴 가격 등록 처리 (로그인 처리?)
	public void menuPriceInsert(MenuPriceVO menuPrice) {
		System.out.println("[MenuPriceService.java / menuPriceInsert.method] Access");
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
		return gson.toJson(menuPriceDao.menuCodeInsert(menuName));
	}
	
	//메뉴 원가 자동 등록
	public String materialInsert(String tempCate, String sizeCate, String menuName) {
		System.out.println("[MenuPriceService.java / materialInsert.method] Access");
		//검색 조건 입력
		Map<String, String> map = new HashMap<String, String>();
		map.put("tempCate", tempCate);
		map.put("sizeCate", sizeCate);		
		map.put("menuName", menuName);
		//리스트로 받은 값들 합산하여 원가 총액 계산
		List<MaterialVO> list = menuPriceDao.materialInsert(map);
		//System.out.println("[MenuPriceService.java / materialInsert.method] list param : " + list);
		int materialResult = 0 ;
		for(int i=0; i<list.size(); i++) {
			materialResult += list.get(i).getMaterialCost();
		}
		//System.out.println("[MenuPriceService.java / materialInsert.method] list param : " + materialResult);
		
		return gson.toJson(materialResult);
	}
}
