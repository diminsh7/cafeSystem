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
	//본사의 지점매출조회 page
	@RequestMapping(value="/salesList", method=RequestMethod.GET)
	public String listSales() {
		logger.debug("listSales method");
		return "/account/salesList";
	}
	//본사의 지점 일매출 json
	@ResponseBody
	@RequestMapping(value="/dailySalesListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailySalesList() {
		String list = salesService.selectDailySalesList();
		logger.debug("jsonDailySalesList method list : " + list);
		return list;
	}
	//본사의 지점 월매출 json
	@ResponseBody
	@RequestMapping(value="/monthlySalesListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlySalesList() {
		String list = salesService.selectMonthlySalesList();
		logger.debug("jsonMonthlySalesList method list : " + list);
		return list;
	}
	//본사의 지점 일매출 top5 json
	@ResponseBody
	@RequestMapping(value="/dailyTopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailyTop() {
		String list = salesService.selectDailyTop();
		logger.debug("jsonDailyTop method list : " + list);
		return list;
	}
	//본사의 지점 월매출 top5 json
	@ResponseBody
	@RequestMapping(value="/monthlyTopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlyTop() {
		String list = salesService.selectMonthlyTop();
		logger.debug("jsonMonthlyTop method list : " + list);
		return list;
	}
	//지점의 매출조회 page
	@RequestMapping(value="/salesListByShop", method=RequestMethod.GET)
	public String listSalesByShop() {
		logger.debug("listSalesByShop method");
		return "/account/salesListByShop";
	}
	//지점의 일매출 json
	@ResponseBody
	@RequestMapping(value="/dailySalesListByShopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailySalesListByShop() {
		logger.debug("jsonDailySalesListByShop method");
		Map<String, Object> param = getLocalShopCode();
		String list = salesService.selectDailySalesListByShop(param);
		logger.debug("jsonFeeListByShop method list : " + list);
		return list;
	}
	//지점의 월매출 json
	@ResponseBody
	@RequestMapping(value="/monthlySalesListByShopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlySalesListByShop() {
		logger.debug("jsonMonthlySalesListByShop method");
		Map<String, Object> param = getLocalShopCode();
		String list = salesService.selectMonthlySalesListByShop(param);
		logger.debug("jsonFeeListByShop method list : " + list);
		return list;
	}
	//지점의 일매출 그래프 json
	@ResponseBody
	@RequestMapping(value="/dailyGraphJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonDailyGraph() {
		logger.debug("jsonDailyGraph method");
		Map<String, Object> param = getLocalShopCode();
		String list = salesService.selectDailyGraph(param);
		logger.debug("jsonDailyGraph method list : " + list);
		return list;
	}
	//지점의 월매출 그래프 json
	@ResponseBody
	@RequestMapping(value="/monthlyGraphJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonMonthlyGraph() {
		logger.debug("jsonMonthlyGraph method");
		Map<String, Object> param = getLocalShopCode();
		String list = salesService.selectMonthlyGraph(param);
		logger.debug("jsonMonthlyGraph method list : " + list);
		return list;
	}
	//본사의 가맹수수료 조회 page
	@RequestMapping(value="/feeList", method=RequestMethod.GET)
	public String listFee() {
		logger.debug("listFee method");
		return "/account/feeList";
	}
	//본사의 가맹수수료 json
	@ResponseBody
	@RequestMapping(value="/feeListJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonFeeList() {
		String list = salesService.selectFeeList();
		logger.debug("jsonFeeList method list : " + list);
		return list;
	}
	//지점의 가맹수수료 조회 page
	@RequestMapping(value="/feeListByShop", method=RequestMethod.GET)
	public String listFeeByShop() {
		logger.debug("listFeeByShop method");
		return "/account/feeListByShop";
	}
	//지점의 가맹수수료 json
	@ResponseBody
	@RequestMapping(value="/feeListByShopJson", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String jsonFeeListByShop() {
		logger.debug("jsonFeeListByShop method");
		Map<String, Object> param = getLocalShopCode();
		String list = salesService.selectFeeListByShop(param);
		logger.debug("jsonFeeListByShop method list : " + list);
		return list;
	}
	//로그인한 사람 소속지점의 지역코드, 매장코드 가져오는 method
	public Map<String, Object> getLocalShopCode(){
		List<HashMap<String, Object>> localshopCode = commonService.localShopCodeSelect();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("local", localshopCode.get(0).get("local_category_code"));
		param.put("shop", localshopCode.get(0).get("shop_code"));
		logger.debug("getLocalShopCode method param : " + param);
		return param;
	}
}
