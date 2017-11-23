package com.caffeesys.cafesystem.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.shop.service.ContractVo;
import com.caffeesys.cafesystem.shop.service.ShopDao;
import com.caffeesys.cafesystem.shop.service.ShopService;
import com.caffeesys.cafesystem.shop.service.ShopVO;

public class ShopController {
	
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopDao shopDao;
	
	// 매장조회 상세전
	@RequestMapping(value = { "/shopList" }, method = RequestMethod.GET)
	public String listShop(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		System.out.println("ShopController.java / listShop method GET방식 ");
		int shopCount = shopDao.selectShopCount();
		int pagePerRow = 10;
		int lastPage = (int) (Math.ceil(shopCount / pagePerRow));
		List<ShopVO> list = shopDao.selectShopList(currentPage, pagePerRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("shopCount", shopCount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		return "/shop/shopList";
	}
	// 매장등록 페이지요청
	@RequestMapping(value="/insertShop", method = RequestMethod.GET)
	public String insertShop() {
		System.out.println("ShopController.java / insertShop method GET방식 ");
		return "/shop/shopInsertForm";
	}
	// 매장등록(액션)요청
	@RequestMapping(value="/insertShop", method = RequestMethod.POST)
	public String insertShop(ShopVO shop) {
		System.out.println("ShopController.java / insertShop method POST방식 " + shop);
		shopService.insertShop(shop);
		return "redirect:/contractList";
	}
}
