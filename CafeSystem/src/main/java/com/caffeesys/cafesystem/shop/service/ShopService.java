package com.caffeesys.cafesystem.shop.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class ShopService {
	
	@Autowired
	private HttpServletResponse response;
	@Autowired
	AllJustService allJustService; // 페이징 및 검색(shop.controller폴더에)
	@Autowired
	private ShopDao shopDao;
	
	// 매장리스트 및 조회 상세전
	public void selectShopList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("ShopService.java / selectShopList method 확인");
		System.out.println("ShopService.java / selectShopList Param model :" + model);
		System.out.println("ShopService.java / selectShopList Param searchOption :" + searchOption);
		System.out.println("ShopService.java / selectShopList Param keyword :" + keyword);
		System.out.println("ShopService.java / selectShopList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("ShopService.java"+map);
		map = allJustService.paging(model, currentPage, 10, shopDao.selectShopCount(map), map);
		model.addAttribute("shopList", shopDao.selectShopList(map));
		model.addAttribute("shopCount", shopDao.selectShopCount(map));
	}
	// 매장등록 과정 기존코드자동증가 말고 다른값비교후 코드자동증가
	public int insertShop(ShopVO shop) {
		System.out.println("ShopService.java / insertShop method 확인");
		System.out.println("ShopService.java / insertShop Param shop :" + shop);
		int shopmaxnum = shopDao.selectShopMax(shop);
		System.out.println("ShopService.java / insertShop의 리턴값 shopmaxnum :" + shopmaxnum);
		
		String result_shopCode = null;
		int result = 0;
		if(shopmaxnum != 0) {
			result = shopmaxnum;
			System.out.println("ShopService.java / insertShop result1 :"+result);
			result = result + 1;
			System.out.println("ShopService.java / insertShop result2 :"+result);
			result_shopCode = String.format("%03d", result); // 자리수 맞추기
			System.out.println("ShopService.java / insertShop result3 :"+result_shopCode);
		} else {
			result_shopCode = "001";
		}
		shop.setShopCode(result_shopCode);
		System.out.println("ShopService.java/ shop:"+shop);
		return shopDao.insertShop(shop);
	}

	// 매장연락망리스트 및 조회
	public void selectBranchCallList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("ShopService.java / selectBranchCallList method 확인");
		System.out.println("ShopService.java / selectBranchCallList Param model :" + model);
		System.out.println("ShopService.java / selectBranchCallList Param searchOption :" + searchOption);
		System.out.println("ShopService.java / selectBranchCallList Param keyword :" + keyword);
		System.out.println("ShopService.java / selectBranchCallList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("ShopService.java"+map);
		map = allJustService.paging(model, currentPage, 10, shopDao.selectBranchCallCount(map), map);
		model.addAttribute("branchCallList", shopDao.selectBranchCallList(map));
		model.addAttribute("branchCallCount", shopDao.selectBranchCallCount(map));
	}
	
	// 매장상세조회(지점)
	public void branchShopList(Model model,HttpSession session) throws IOException{
		System.out.println("ShopService.java / branchShopList method 확인");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			if(login.getEmpCode().equals("") || login.getPosition().equals("201")) {
				System.out.println("점주권한으로 매장정보 확인가능");
				String branchEmployeeCode = login.getEmpCode();
				List<ShopVO> shopList = shopDao.branchShopList(branchEmployeeCode);
				System.out.println("shopList : " + shopList);
				model.addAttribute("shopList",shopList);
			}else{
				System.out.println("권한 기준 확인 불가능");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('권한 기준 확인 불가능'); history.go(-1);</script>");
				out.flush();
			}
		}else {
			System.out.println("로그인 후 확인 가능");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 확인 가능'); history.go(-1);</script>");
			out.flush();
		}
	}
}
