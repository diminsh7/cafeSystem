package com.caffeesys.cafesystem.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.account.service.DailySalesVO;
import com.caffeesys.cafesystem.account.service.SalesService;

@Controller
public class SalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	private SalesService salesService;
	
	@RequestMapping(value="/dailySalesInsertForm", method=RequestMethod.GET)
	public String insertDailySales() {
		logger.debug("insertDailySales method");
		return "/account/dailySalesInsertForm";
	}
	@RequestMapping(value="/dailySalesList", method=RequestMethod.GET)
	public String listDailySales() {
		logger.debug("listDailySales method");
		return "/account/salesList";
		/*return "/account/dailySalesList";*/
	}
	@ResponseBody
	@RequestMapping(value="/dailySalesListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailySalesList() {
		String list = salesService.selectDailySalesList();
		logger.debug("jsonDailySalesList method list : " + list);
		return list;
	}
}
