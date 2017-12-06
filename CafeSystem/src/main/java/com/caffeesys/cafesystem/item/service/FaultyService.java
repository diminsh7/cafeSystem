package com.caffeesys.cafesystem.item.service;

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
import com.caffeesys.cafesystem.shop.service.AllJustService;

@Service
public class FaultyService {
	
	@Autowired
	private HttpServletResponse response;
	@Autowired
	AllJustService allJustService; // 페이징 및 검색(shop.controller폴더에)
	@Autowired
	private FaultyDao faultyDao;
	
	// 불량품목리스트 및 조회 상세전(본사)
	public void selectFaultyList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("FaultyService.java / selectFaultyList method 확인");
		System.out.println("FaultyService.java / selectFaultyList Param model :" + model);
		System.out.println("FaultyService.java / selectFaultyList Param searchOption :" + searchOption);
		System.out.println("FaultyService.java / selectFaultyList Param keyword :" + keyword);
		System.out.println("FaultyService.java / selectFaultyList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("FaultyService.java"+map);
		map = allJustService.paging(model, currentPage, 10, faultyDao.selectFaultyCount(map), map);
		model.addAttribute("faultyList", faultyDao.selectFaultyList(map));
		model.addAttribute("faultyCount", faultyDao.selectFaultyCount(map));
	}
	
	// 불량품목등록 과정(지점)
	public int insertFaulty(FaultyVO faulty) {
		System.out.println("FaultyService.java / insertFaulty method 확인");
		System.out.println("FaultyService.java / insertFaulty Param faulty :" + faulty);
		return faultyDao.insertFaulty(faulty);
	}
	
	// 불량품목상세조회(지점)
	public void branchFaultyList(Model model,HttpSession session) throws IOException{
		System.out.println("FaultyService.java / branchFaultyList method 확인");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			if(login.getEmpCode().equals("") || login.getPosition().equals("201") || login.getPosition().equals("202")) {
				System.out.println("점주,매니저 권한으로 불량품목정보 확인가능");
				String branchEmployeeCode = login.getEmpCode();
				List<FaultyVO> faultyList = faultyDao.branchFaultyList(branchEmployeeCode);
				System.out.println("faultyList : " + faultyList);
				model.addAttribute("faultyList",faultyList);
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
