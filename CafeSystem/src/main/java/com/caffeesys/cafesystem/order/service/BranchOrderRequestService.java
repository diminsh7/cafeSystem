package com.caffeesys.cafesystem.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class BranchOrderRequestService {

	//System.out.println("");
	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private BranchOrderRequestDao RequestDao;

	
	//발주리스트 & 권한 확인
	public void selectBranchOrderRequestList(Model model,HttpSession session) throws IOException{
		System.out.println("BranchOrderRequestService.seleteBranchOrderRequestList 실행");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			System.out.println("login.getPosition() : " + login.getPosition());
			if(login.getPosition().equals("201") || login.getPosition().equals("202")) {
				System.out.println("점주 또는 매니져 권한으로 발주주문내역 확인 가능");
				String branchEmployeeCode = login.getEmpCode();
				BranchOrderRequestVO localShopCode = RequestDao.selectLocalShopCode(branchEmployeeCode);
				List<BranchOrderRequestVO> orderRequestList = RequestDao.seleteOderRequestList(localShopCode);
				System.out.println("orderRequestList : " + orderRequestList);
				model.addAttribute("orderRequestList",orderRequestList);
			}else{
				System.out.println("점주 또는 매니져 권한미달로 발주주문내역 확인 불가능");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('권한 미달로 인해 확인이 불가능 합니다.'); history.go(-1);</script>");
				out.flush();
			}
		}else {
			System.out.println("로그인이 되어 있지 않음");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 되어 있지 않습니다.'); history.go(-1);</script>");
			out.flush();
		}
	}
}
