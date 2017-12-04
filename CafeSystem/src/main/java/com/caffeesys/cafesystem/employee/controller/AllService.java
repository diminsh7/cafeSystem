package com.caffeesys.cafesystem.employee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class AllService { //검색
	public Map<String, String> paging(Model model, Map<String, String> map) {
		if(map != null) {
			model.addAttribute("searchOption",map.get("searchOption"));
			model.addAttribute("keyword",map.get("keyword"));
		}else {
			map = new HashMap<String, String>();
		}
		return map;
	}
}

