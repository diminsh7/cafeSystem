package com.caffeesys.cafesystem.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.caffeesys.cafesystem.account.service.DailySalesVO;
import com.caffeesys.cafesystem.account.service.SalesService;

@Controller
public class SalesController {
	private static final Logger logger = LoggerFactory.getLogger(SalesController.class);
	
	@Autowired
	private SalesService salesService;
	
	@RequestMapping(value="/dailySalesInsertForm", method=RequestMethod.GET)
	public String insertDailySales() {
		logger.debug("insertDailySalesInsert()");
		return "/account/dailySalesInsertForm";
	}
	@RequestMapping(value="/dailySalesList", method=RequestMethod.GET)
	public ModelAndView ListDailySales(DailySalesVO dailySales) {
		ModelMap model = new ModelMap();
		List<DailySalesVO> list = salesService.selectDailySalesList(dailySales);
		logger.debug("ListDailySales method dailySalesList : " + list);
		model.addAttribute("dailySalesList", list);
		return new ModelAndView("/account/dailySalesList", model);
	}
}
