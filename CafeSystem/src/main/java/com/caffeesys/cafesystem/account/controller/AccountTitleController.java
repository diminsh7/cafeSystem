package com.caffeesys.cafesystem.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.account.service.AccountTitle;
import com.caffeesys.cafesystem.account.service.AccountTitleService;

@Controller
public class AccountTitleController {
	@Autowired
	private AccountTitleService accountTitleService;
	
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.GET)
	public String insertAccountTitle() {
		System.out.println("AccountTitleController.java / insertAccountTitle method get방식 ");
		return "/account/accountTitleInsertForm";
	}
	
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitle accountTitle) {
		System.out.println("[AccountTitleController.java / insertAccountTitle method] : insert proccess");
		System.out.println("AccountTitleController.java / AccountTitle Param accountTitle : " + accountTitle);
		accountTitleService.insertAccountTitle(accountTitle);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
}
