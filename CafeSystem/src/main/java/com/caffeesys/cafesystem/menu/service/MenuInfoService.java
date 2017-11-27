package com.caffeesys.cafesystem.menu.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.account.controller.PasingService;

@Service
public class MenuInfoService {
	
	@Autowired
	PasingService pasingService;
	@Autowired
	private MenuInfoDao menuInfoDao;
	
	// 메뉴리스트 및 조회 상세전
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
		map = pasingService.paging(model, currentPage, 10, menuInfoDao.selectMenuInfoCount(map), map);
		model.addAttribute("menuInfoList", menuInfoDao.selectMenuInfoList(map));
		model.addAttribute("menuInfoCount", menuInfoDao.selectMenuInfoCount(map));
	}
}
