package com.caffeesys.cafesystem.account.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.account.service.AccountTitleVO;
import com.caffeesys.cafesystem.account.service.AccountTitleService;

@Controller
public class AccountTitleController {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleController.class);
	@Autowired
	private AccountTitleService accountTitleService;
	
	//get방식으로 accountTitleUpdateForm 보여주기
	@RequestMapping(value="/accountTitleUpdateForm", method = RequestMethod.GET)
	public String updateAccountTitle(Model model, 
									@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) {
		logger.debug("updateAccountTitle 메소드의 accountTitleCode 잘 넘어 왔나 확인:{}",accountTitleCode);
		AccountTitleVO accountTitleVo= accountTitleService.selectAccountTitle(accountTitleCode);
		model.addAttribute("accountTitle",accountTitleVo);
		return "/account/accountTitleUpdateForm"; 		
	}
	
	@RequestMapping(value="/accountTitleUpdateForm", method = RequestMethod.POST)
	public String updateAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("updateAccountTitle 메소드의 입력값 : {}",accountTitleVo);
		accountTitleService.updateAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";
	}
	
	//list 보여주기
	@RequestMapping(value="accountTitleList")
	public String listAccountTitle(Model model) {
		logger.debug("listAccountTitle 메소드 확인");
		List<AccountTitleVO> list = accountTitleService.listAccountTitle();
		model.addAttribute("accountlist", list);
		return "/account/accountTitleList";
	}
	
	//get방식으로 accountTitleInsertForm 보여주기
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.GET)
	public String insertAccountTitle() {
		logger.debug("insertAccountTitle 메소드 확인");
		return "/account/accountTitleInsertForm";
	}
	
	//폼에서 입력한것을 받아오면 accountTitleCode는 null값이고, 나머지는 입력한 값이 넘어온다. 
	//계정과목 insert 작업
	@RequestMapping(value="/insertAccountTitle", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitleVO accountTitleVo) {
		logger.debug("insertAccountTitle메소드의 accountTitleVo 잘받아왔나확인 : {}",accountTitleVo);
		accountTitleService.insertAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
	
	
}
