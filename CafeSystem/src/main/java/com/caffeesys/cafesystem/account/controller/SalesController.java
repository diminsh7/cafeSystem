package com.caffeesys.cafesystem.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caffeesys.cafesystem.CommonService;
import com.caffeesys.cafesystem.account.service.SalesService;

@Controller
public class SalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	private SalesService salesService;
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/dailySalesInsertForm", method=RequestMethod.GET)
	public String insertDailySales() {
		logger.debug("insertDailySales method");
		return "/account/dailySalesInsertForm";
	}
	@RequestMapping(value="/salesList", method=RequestMethod.GET)
	public String listSales() {
		logger.debug("listSales method");
		return "/account/salesList";
	}
	@ResponseBody
	@RequestMapping(value="/dailySalesListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailySalesList() {
		String list = salesService.selectDailySalesList();
		logger.debug("jsonDailySalesList method list : " + list);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/monthlySalesListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlySalesList() {
		String list = salesService.selectMonthlySalesList();
		logger.debug("jsonMonthlySalesList method list : " + list);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/dailyTopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailyTop() {
		String list = salesService.selectDailyTop();
		logger.debug("jsonDailyTop method list : " + list);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/monthlyTopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlyTop() {
		String list = salesService.selectMonthlyTop();
		logger.debug("jsonMonthlyTop method list : " + list);
		return list;
	}
	@RequestMapping(value="/feeList", method=RequestMethod.GET)
	public String listFee() {
		logger.debug("listFee method");
		return "/account/feeList";
	}
	@ResponseBody
	@RequestMapping(value="/feeListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonFeeList() {
		String list = salesService.selectFeeList();
		logger.debug("jsonFeeList method list : " + list);
		return list;
	}
	@RequestMapping(value="/feeListByShop", method=RequestMethod.GET)
	public String listFeeByShop() {
		logger.debug("listFeeByShop method");
		return "/account/feeListByShop";
	}
	@ResponseBody
	@RequestMapping(value="/feeListByShopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonFeeListByShop() {
		logger.debug("jsonFeeListByShop method");
		//session 정보 이용해서 매장가져오고 그걸로 수수료 select하기
		List<HashMap<String, Object>> localshopCode = commonService.localShopCodeSelect();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("local", localshopCode.get(0).get("local_category_code"));
		param.put("shop", localshopCode.get(0).get("shop_code"));
		logger.debug("jsonFeeListByShop method param : " + param);
		String list = salesService.selectFeeListByShop(param);
		logger.debug("jsonFeeListByShop method list : " + list);
		return list;
	}
}
