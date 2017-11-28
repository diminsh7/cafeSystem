package com.caffeesys.cafesystem.category.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;
	
	//세션에 카테고리 set
	public void categorySelect(HttpSession session, String input, String input2) {
		System.out.println("[CategoryService.java / categorySelect.method] Loading");
		Map<String, String> cateMap = new HashMap<String, String>();
		cateMap.put("input", input);
		cateMap.put("input2", input2);
		System.out.println("[CategoryService.java / categorySelect.method] cateMap param : " + cateMap);
		session.setAttribute("cateList", categoryDao.cateList(cateMap));
	}
}
