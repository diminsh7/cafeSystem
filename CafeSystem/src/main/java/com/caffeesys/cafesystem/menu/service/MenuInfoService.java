package com.caffeesys.cafesystem.menu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.shop.service.AllJustService;

@Service
public class MenuInfoService {
	
	@Autowired
	AllJustService allJustService; // 페이징 및 검색(shop.controller폴더에)
	@Autowired
	private MenuInfoDao menuInfoDao;
	
	// 메뉴리스트 및 조회 상세전(지점도 포함)
	public void selectMenuInfoList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("MenuInfoService.java / selectMenuInfoList method 확인");
		System.out.println("MenuInfoService.java / selectMenuInfoList Param model :" + model);
		System.out.println("MenuInfoService.java / selectMenuInfoList Param searchOption :" + searchOption);
		System.out.println("MenuInfoService.java / selectMenuInfoList Param keyword :" + keyword);
		System.out.println("MenuInfoService.java / selectMenuInfoList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("MenuInfoService.java"+map);
		map = allJustService.paging(model, currentPage, 10, menuInfoDao.selectMenuInfoCount(map), map);
		model.addAttribute("menuInfoList", menuInfoDao.selectMenuInfoList(map));
		model.addAttribute("menuInfoCount", menuInfoDao.selectMenuInfoCount(map));
	}
	// 메뉴등록 과정
	public int insertMenuInfo(MenuInfoVO menuInfo) {
		System.out.println("MenuInfoService.java / insertMenuInfo method 확인");
		System.out.println("MenuInfoService.java / insertMenuInfo Param menuInfo :" + menuInfo);
		int menuInfomaxnum = menuInfoDao.selectMenuInfoMax();
		System.out.println("MenuInfoService.java / insertMenuInfo의 리턴값 menuInfomaxnum :" + menuInfomaxnum);		
		String menu_code_temp = "menu_";
		String menucode = "menu_001";
		String result_no = null;
		int result = 0;
		if(menuInfomaxnum != 0) {
			result = menuInfomaxnum;
			System.out.println("MenuInfoService.java / insertMenuInfo result1 :"+result);
			result = result + 1;
			System.out.println("MenuInfoService.java / insertMenuInfo result2 :"+result);
			result_no = String.format("%03d", result); // 자리수 맞추기
			System.out.println("MenuInfoService.java / insertMenuInfo result3 :"+result_no);
		}
		menucode = menu_code_temp+ result_no;
		System.out.println("menucode : "+ menucode);
		menuInfo.setMenuCode(menucode);
		System.out.println("MenuInfoService.java / menuInfo:"+menuInfo);
		return menuInfoDao.insertMenuInfo(menuInfo);
	}
}
