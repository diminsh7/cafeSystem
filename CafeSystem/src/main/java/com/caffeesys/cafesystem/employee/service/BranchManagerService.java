package com.caffeesys.cafesystem.employee.service;
  
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.login.service.LoginVO;
import com.caffeesys.cafesystem.order.service.BranchOrderRequestVO;
 
@Service
public class BranchManagerService {

	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private BranchManagerDao branchManagerDao;
	
	//테이블 두개에 들어가서 입력되야하기 때문에 서비스를 나눔, 1->employee테이블에 등록 2->manager테이블에 등록
	//점주 등록과정 1->employee테이블
	public int insertBranchEmployee(BranchManagerVO branchManagerVo) { 
		System.out.println("[BranchManagerService.insertBranchManager] 실행");
		
		//==========================branchEmployee포지션 코드 설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 포지션 코드 추가]==========");
		branchManagerVo.setPositionCategoryCode("201");
		
		//==========================branchEmployeeCode 설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 코드 구하기 시작]==========");
		int branchEmployeeCodeMax = branchManagerDao.selectBranchEmployeeCodeMax();
		String branchEmployeeCodeTemp = "bran_"; 
		String branchEmployeeCode = "bran_00001";
		String result_no = null;
		int result = 0;
		
		if(branchEmployeeCodeMax != 0) {
			result = branchEmployeeCodeMax;//ex)41
			result ++; //ex)42
			result_no = String.format("%05d", result); //ex)00042
		}
		
		branchEmployeeCode = branchEmployeeCodeTemp + result_no; //ex) bran_ + 00042
		branchManagerVo.setBranchEmployeeCode(branchEmployeeCode);
	
		return branchManagerDao.insertBranchEmployee(branchManagerVo);
	};
	
	// 점주등록과정 2->manager테이블
	public int insertBranchManager(BranchManagerVO branchManager) {
		// ==========================branchEmployeeCode설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 코드 구하기 시작]==========");
		int branchEmployeeCodeMax = branchManagerDao.selectBranchEmployeeCodeMax();
		String branchEmployeeCodeTemp = "bran_";
		String branchEmployeeCode = "bran_00001";
		String result_no = null;
		int result = 0;

		if (branchEmployeeCodeMax != 0) {
			result = branchEmployeeCodeMax;// ex)41
			result_no = String.format("%05d", result); // ex)00041
		}

		branchEmployeeCode = branchEmployeeCodeTemp + result_no; // ex) bran_ + 00041
		branchManager.setBranchEmployeeCode(branchEmployeeCode);

		return branchManagerDao.insertBranchManager(branchManager); 
	}

	//점주본인 신상정보 확인
	public void selectBranchManager(Model model, HttpSession session) throws IOException {
		// ==========================selectBranchManager==============================
		System.out.println("BranchManagerService.selectBranchManager 실행");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			System.out.println("login.getPosition() : " + login.getPosition());
			if(login.getPosition().equals("201")) {
				System.out.println("점주 권한확인 완료");
				String branchEmployeeCode = login.getEmpCode();
				List<BranchManagerVO> branchManager =branchManagerDao.selectBranchManagerDetail(branchEmployeeCode);
				System.out.println("branchManager : " + branchManager);
				model.addAttribute("branchManager",branchManager);
				
		
			}else{
				System.out.println("점주 권한이 아님");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('점주 본인만 확인이 가능합니다.'); history.go(-1);</script>");
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