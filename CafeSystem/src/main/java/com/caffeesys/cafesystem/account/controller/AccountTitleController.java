package com.caffeesys.cafesystem.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caffeesys.cafesystem.account.service.AccountTitleVO;
import com.caffeesys.cafesystem.account.service.AccountTitleService;

@Controller
public class AccountTitleController {
	private static final Logger logger = LoggerFactory.getLogger(AccountTitleController.class);
	@Autowired
	private AccountTitleService accountTitleService;
	
	//검색시 list
	@RequestMapping(value="/accountTitleList", method=RequestMethod.POST)
	public ModelAndView list(@RequestParam(defaultValue="account_title_name") String searchOption,
								@RequestParam(defaultValue="") String keyword) throws Exception {
		logger.debug("list메소드 확인 post방식");
		logger.debug("list메소드 searchOption:{}",searchOption);
		logger.debug("list메소드 keyword:{}",keyword);
		List<AccountTitleVO> list = accountTitleService.listAll(searchOption,keyword);
		//레코드의 개수
		int count = accountTitleService.countArticle(searchOption,keyword);
		//ModelAndView - 모델과 뷰
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist",list);//데이터 저장
		mav.addObject("count",count);
		mav.addObject("searchOption",searchOption);
		mav.addObject("keyword",keyword);
		//데이터를 맵에 저장
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list); //list
		map.put("count", count); //레코드개수
		map.put("searchOption", searchOption); //검색옵션
		map.put("keyword", keyword); //검색키워드
		mav.addObject("map",map);*/ //맵에 저장된 데이터를 mav에 저장
		mav.setViewName("account/accountTitleList");	//어떤 페이지를 보여줄 것인지
		logger.debug("list:{}",list);
		
		return mav;
	}
	
	//계정과목 list 보여주기
	@RequestMapping(value= "/accountTitleList", method = RequestMethod.GET)
	public String listAccountTitle(Model model		
									,@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) throws Exception {
		
		logger.debug("listAccountTitle 메소드 get방식");
		int pagePerRow = 10;	//한페이지당 10개
		int accountTitleCount = accountTitleService.getAccountTitleCount(); //accountTitleList의 행의 개수
		List<AccountTitleVO> list = accountTitleService.selectAccountTitleList(currentPage, pagePerRow); //현재페이지의 행의수를 리스트
		int lastPage = (int)(Math.ceil(accountTitleCount/pagePerRow));
		logger.debug("listAccountTitle 메소드 currentPage :{}",currentPage);
		logger.debug("listAccountTitle 메소드 accountTitleCount :{}",accountTitleCount);
		logger.debug("listAccountTitle 메소드 list :{}",list);
		
		model.addAttribute("totalRowCount",accountTitleCount);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("accountlist",list);

		return "account/accountTitleList";
	}
	
	//계정과목 delete 
	@RequestMapping(value="/accountTitleDelete", method = RequestMethod.GET)
	public String deleteAccountTitle(@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) throws Exception {
		logger.debug("deleteAccountTitle메소드의 accountTitleCode :{}",accountTitleCode);
		accountTitleService.deleteAccountTitle(accountTitleCode);
		
		return "redirect:/accountTitleList";
	}	
	
	//계정과목 updateForm 보여주기 get방식으로 accountTitleUpdateForm 보여주기
	@RequestMapping(value="/accountTitleUpdateForm", method = RequestMethod.GET)
	public String updateAccountTitle(Model model, 
									@RequestParam(value="accountTitleCode", required=true) String accountTitleCode) throws Exception {
		logger.debug("updateAccountTitle 메소드의 accountTitleCode 잘 넘어 왔나 확인:{}",accountTitleCode);
		AccountTitleVO accountTitleVo= accountTitleService.selectAccountTitle(accountTitleCode);
		model.addAttribute("accountTitle",accountTitleVo);
		return "/account/accountTitleUpdateForm"; 		
	}
	
	//계정과목 update하기 post 방식으로 accountTitleUpdateForm의 입력값 넘겨주기  
	@RequestMapping(value="/accountTitleUpdateForm", method = RequestMethod.POST)
	public String updateAccountTitle(AccountTitleVO accountTitleVo) throws Exception {
		logger.debug("updateAccountTitle 메소드의 입력값 : {}",accountTitleVo);
		accountTitleService.updateAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";
	}
	
	//계정과목 insertform 보여주기 get방식으로 accountTitleInsertForm 보여주기
	@RequestMapping(value="/accountTitleInsert", method = RequestMethod.GET)
	public String insertAccountTitle() throws Exception {
		logger.debug("insertAccountTitle 메소드 확인");
		return "/account/accountTitleInseartForm";
	}
	
	//계정과목 insert 작업 
	@RequestMapping(value="/accountTitleInsert", method = RequestMethod.POST)
	public String insertAccountTitle(AccountTitleVO accountTitleVo) throws Exception {
		logger.debug("insertAccountTitle메소드의 accountTitleVo 잘받아왔나확인 : {}",accountTitleVo);
		accountTitleService.insertAccountTitle(accountTitleVo);
		return "redirect:/accountTitleList";	// = response.sendRedirect("/accountTitleList");
	}
	
	
}
