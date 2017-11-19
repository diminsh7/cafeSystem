package com.caffeesys.cafesystem.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.HomeController;
import com.caffeesys.cafesystem.account.service.AccountTitle;
import com.caffeesys.cafesystem.account.service.AccountTitleService;

@Controller
public class AccountTitleController {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleController.class);
	@Autowired
	private AccountTitleService accountTitleService;
	
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.GET)
	public String insertAccountTitle() {
		logger.debug("Welcome home! The client locale is {}.");
		System.out.println("AccountTitleController.java / insertAccountTitle method get방식 ");
		return "/account/accountTitleInsertForm";
	}
	
	//폼에서 입력한것을 받아오면 accountTitleCode는 null값이고, 나머지는 입력한 값이 넘어온다. 
	//계정과목 insert 작업
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitle accountTitle) {
		logger.debug("Welcome home! The client locale is {}.", accountTitle);
		System.out.println("[AccountTitleController.java / insertAccountTitle method] : insert proccess");
		System.out.println("AccountTitleController.java / AccountTitle Param accountTitle : " + accountTitle);
		accountTitleService.insertAccountTitle(accountTitle);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
	
	@RequestMapping(value="accountTitleList")
	public String listAccountTitle(Model model) {
		System.out.println("AccountTitleController.java / listAccountTitle method 확인");
		accountTitleService.listAccountTitle(model);
		return "/account/accountTitleList";
	}
}
