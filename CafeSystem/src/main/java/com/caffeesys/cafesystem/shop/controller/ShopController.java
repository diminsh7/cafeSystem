package com.caffeesys.cafesystem.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.shop.controller.ShopController;
import com.caffeesys.cafesystem.shop.service.ShopDao;
import com.caffeesys.cafesystem.shop.service.ShopVO;

@Controller
public class ShopController {
	
	@Autowired
	private ShopDao shopDao;
	
	// 매장등록 페이지요청
	@RequestMapping(value = "/shopInsert", method = RequestMethod.GET)
	public String shopInsert(Model model) {
		System.out.println("ShopController.java / shopInsert method GET방식 ");
		return "/shop/shopInsertForm";
	}
	// 매장등록(액션)요청
	@RequestMapping(value = "/shopInsert", method = RequestMethod.POST)
	public String shopInsert(ShopVO shop) {
		System.out.println("ShopController.java / shopInsert method POST방식 " + shop);
		shopService.insertShop(shop);
		return "redirect:/shopList";
	}
}
