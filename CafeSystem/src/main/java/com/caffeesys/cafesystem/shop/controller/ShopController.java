package com.caffeesys.cafesystem.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.shop.controller.ShopController;
import com.caffeesys.cafesystem.shop.service.ShopDao;
import com.caffeesys.cafesystem.shop.service.ShopVO;

public class ShopController {
	@Autowired
	private ShopDao shopDao;

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	// 매장등록 페이지요청
	@RequestMapping(value = "/shopInsert", method = RequestMethod.GET)
	public String shopInsert(Model model) throws Exception {
		logger.debug("ContractController.java / shopInsert method GET방식 ");
		return "/shop/shopInsertForm";
	}
	// 매장등록(액션)요청
	@RequestMapping(value = "/shopInsert", method = RequestMethod.POST)
	public String shopInsert(ShopVO shop) throws Exception {
		logger.debug("[ContractController.java / shopInsert method POST방식 " + shop);
		shopDao.insertShop(shop);
		/*return "redirect:/shopList";*/
		return "redirect:/shopInsertForm";
	}
}
