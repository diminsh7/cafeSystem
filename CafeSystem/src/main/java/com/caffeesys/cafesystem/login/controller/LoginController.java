package com.caffeesys.cafesystem.login.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.login.service.Login;
import com.caffeesys.cafesystem.login.service.LoginDao;
import com.caffeesys.cafesystem.login.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("LoginController.java / login 폼 요청");
		return "/login/loginForm";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Login login, HttpSession session, HttpServletResponse response) throws Exception {
		System.out.println("LoginController.java / login 액션 요청");
		System.out.println(login);
		String loginDiv = login.getDivision();
		if("head".equals(loginDiv)) {
			Login loginInfo = loginService.headLogin(login);
			System.out.println(loginInfo);
			// 로그인 정보가 틀린 경우
			// 로그인 정보가 맞은 경우 -> 세션 등록
		} else if("branch".equals(loginDiv)) {
			Login loginInfo = loginService.branchLogin(login);
			System.out.println(loginInfo);
		} else {
			System.out.println("선택안함");
			// 본사/지점을 선택하지 않을 경우 선택하라는 경고창을 띄움
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
            out.println("<script>alert('본사 혹은 지점을 선택하세요.'); history.go(-1);</script>");
            out.flush();
            //return "/login";
		}
		return "redirect:/";
	}
}
