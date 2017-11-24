package com.caffeesys.cafesystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("loginInfo");
		//로그인이 안되어 있는 상태이면 로그인 폼으로 다시 redirect
		if(obj == null) {
			response.sendRedirect("/login");
			return false; //컨트롤러 요청으로 가지 않도록 false를 반환
		}
		//다른 메뉴로 넘어가면 저장되어 있던 세션을 없애는 과정이 필요!
		//세션에 담긴 로그인정보를 제외한 모든 세션을 없애야함
		return true;	//return이 true이면 컨트롤러 요청 uri로 감
	}
}