package com.caffeesys.cafesystem.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caffeesys.cafesystem.shop.service.ShopDao;
import com.caffeesys.cafesystem.shop.service.ShopService;
import com.caffeesys.cafesystem.shop.service.ShopVO;

@Controller
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
	public String insertShop(Model model) {
		System.out.println("ShopController.java / insertShop method GET방식 ");
		List<ShopVO> ContractCodeList = shopDao.selectShopContractCode();
		List<ShopVO> CategoryLocalList = shopDao.selectShopCategorySmall();
		model.addAttribute("ContractCodeList",ContractCodeList);
		model.addAttribute("CategoryLocalList",CategoryLocalList);
		return "/shop/shopInsertForm";
	}
	// 매장등록(액션)요청
	@RequestMapping(value="/insertShop", method = RequestMethod.POST)
	public String insertShop(ShopVO shop) {
		System.out.println("ShopController.java / insertShop method POST방식 " + shop);
		shopService.insertShop(shop);
		return "redirect:/shopList";
	}
	// 매장상세조회
	@RequestMapping(value = "/shopDetail", method = RequestMethod.GET)
	public String detailShop(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ShopController.java / detailShop method GET방식 " + contractCode);
		ShopVO shop = shopDao.selectShop(contractCode);
		model.addAttribute("shop", shop);
		return "/shop/shopDetail";
	}
	// 계약서수정 페이지요청
	@RequestMapping(value = "/updateShop", method = RequestMethod.GET)
	public String updateShop(Model model, @RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ShopController.java / updateShop method GET방식 " + contractCode);
		ShopVO shop = shopDao.selectShop(contractCode);
		model.addAttribute("shop", shop);
		return "/shop/shopUpdateForm";
	}
	// 계약서수정(액션)요청
	@RequestMapping(value = "/updateShop", method = RequestMethod.POST)
	public String updateShop(ShopVO shop) {
		System.out.println("ShopController.java / updateShop method POST방식 " + shop);
		shopDao.updateShop(shop);
		return "redirect:/shopDetail?contractCode=" + shop.getContractCode();
	}
	// 매장삭제 페이지요청(점포명 입력)
	@RequestMapping(value = "/deleteShop", method = RequestMethod.GET)
	public String deleteShop(@RequestParam(value = "contractCode", required = true) String contractCode) {
		System.out.println("ShopController.java / deleteShop method GET방식 " + contractCode);
		return "/shop/shopDeleteForm";
	}
	// 매장삭제(액션)요청
	@RequestMapping(value = "/deleteShop", method = RequestMethod.POST)
	public String deleteShop(@RequestParam(value = "contractCode", required = true) String contractCode,
			@RequestParam(value = "shopName", required = true) String shopName) {
		System.out.println("ShopController.java / deleteShop method POST방식 " + contractCode);
		System.out.println("ShopController.java / deleteShop method POST방식 " + shopName);
		shopDao.deleteShop(contractCode, shopName);
		return "redirect:/shopList";
	}
	// 매장검색조회 상세전
	@RequestMapping(value = "/shopSearch", method = RequestMethod.POST)
	public ModelAndView searchShop(@RequestParam(defaultValue="") String searchOption, 
										@RequestParam(defaultValue="") String keyword) {
		System.out.println("ShopController.java / searchShop method POST방식 " + searchOption);
		System.out.println("ShopController.java / searchShop method POST방식 " + keyword);
		List<ShopVO> list = shopService.searchShop(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("shop/shopList");
		return mav;
	}
	// 매장연락망조회
	@RequestMapping(value = { "/branchCallList" }, method = RequestMethod.GET)
	public String listBranchCall(Model model,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
		System.out.println("ShopController.java / listBranchCall method GET방식 ");
		int branchCallCount = shopDao.selectBranchCallCount();
		int pagePerRow = 10;
		int lastPage = (int) (Math.ceil(branchCallCount / pagePerRow));
		List<ShopVO> list = shopDao.selectBranchCallList(currentPage, pagePerRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("branchCallCount", branchCallCount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list", list);
		return "/shop/branchCallList";
	}
	// 매장연락망검색조회
	@RequestMapping(value = "/branchCallSearch", method = RequestMethod.POST)
	public ModelAndView searchBranchCall(@RequestParam(defaultValue="") String searchOption, 
										@RequestParam(defaultValue="") String keyword) {
		System.out.println("ShopController.java / searchBranchCall method POST방식 " + searchOption);
		System.out.println("ShopController.java / searchBranchCall method POST방식 " + keyword);
		List<ShopVO> list = shopService.searchBranchCall(searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		mav.addObject("map", map);
		mav.setViewName("shop/branchCallList");
		return mav;
	}
}
