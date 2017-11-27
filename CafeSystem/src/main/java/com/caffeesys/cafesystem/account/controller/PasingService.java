package com.caffeesys.cafesystem.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public class PasingService {
	public Map<String, String> paging(Model model, int currentPage, int pagePerRow, int count, Map<String, String> map) {
		if(map != null) {
			model.addAttribute("searchOption",map.get("searchOption"));
			model.addAttribute("keyword",map.get("keyword"));
		}else {
			map = new HashMap<String, String>();
		}
		
		int lastPage = count / pagePerRow;
		if((count % pagePerRow) !=0) {
			lastPage +=1;
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		map.put("beginRow", Integer.toString((currentPage-1)*pagePerRow));
		map.put("pagePerRow", Integer.toString(pagePerRow));
		return map;
	}
}
