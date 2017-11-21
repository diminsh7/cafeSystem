package com.caffeesys.cafesystem.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caffeesys.cafesystem.login.service.LoginVO;
import com.caffeesys.cafesystem.login.service.LoginDao;
import com.caffeesys.cafesystem.login.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private LoginService loginService;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.debug("login method(GET)");
		return "/login/loginForm";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginVO login) throws IOException {
		logger.debug("login method(POST) : {}", login);
		String loginDiv = login.getDivision();
		if("head".equals(loginDiv)) {
			LoginVO loginInfo = loginService.headLogin(login);
			loginSuccess(loginInfo, loginDiv);
		} else if("branch".equals(loginDiv)) {
			LoginVO loginInfo = loginService.branchLogin(login);
			loginSuccess(loginInfo, loginDiv);
		} else {
			logger.debug("login method(POST) 본사/지점 선택하지않음");
            return "/login";
		}
		return "home";
	}
	public String loginSuccess(LoginVO loginInfo, String loginDiv) throws IOException {
		logger.debug("login method(POST) loginInfo : {}", loginInfo);
		if(loginInfo != null) {	// 로그인 정보가 맞은 경우 -> 세션 등록
			logger.debug("login method(POST) 로그인 성공");
			loginInfo.setDivision(loginDiv);
			//세션등록해야됌!
			//session.setAttribute("loginInfo", loginInfo);
			return "redirect:/";
		}else {	// 로그인 정보가 틀린 경우
			logger.debug("login method(POST) 로그인 정보 틀림");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
			out.flush();
		}
		return "home";
	}
}
