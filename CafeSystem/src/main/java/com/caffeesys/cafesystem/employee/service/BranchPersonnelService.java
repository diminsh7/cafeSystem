package com.caffeesys.cafesystem.employee.service;

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

import com.caffeesys.cafesystem.employee.controller.BranchPasingService;
import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class BranchPersonnelService {

	@Autowired
	private HttpServletResponse response;
	
	@Autowired
	private BranchPersonnelDao branchPersonnelDao;
	
	@Autowired
	private BranchPasingService pasingServiec;
	
	//테이블 두개에 들어가서 입력되야하기 때문에 서비스를 나눔, 1->employee테이블에 등록 2->manager테이블에 등록
	//점주 등록과정 1->employee테이블
	public int insertBranchEmployee(BranchPersonnelVO branchPersonnelVo) {
		System.out.println("[BranchPersonnelService.insertBranchEmployee] 실행");
		//==========================branchEmployeeCode 설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 코드 구하기 시작]==========");
		int branchEmployeeCodeMax = branchPersonnelDao.selectBranchEmployeeCodeMax();
		String branchEmployeeCodeTemp = "bran_"; 
		String branchEmployeeCode = null; //완성된 코드가 들어갈 변수
		String result_no = null;  //문자를 제외한 숫자부분가 들어가 변수
		int result = 0; //db에서 가져온 마지막 숫자가 들어갈 변수
		
		if(branchEmployeeCodeMax != 0) {
			result = branchEmployeeCodeMax;  //ex)41
			result ++;//ex)42
			result_no = String.format("%05d", result); //ex)00042
		}
		
		branchEmployeeCode = branchEmployeeCodeTemp + result_no; //ex) bran_ + 00042
		branchPersonnelVo.setBranchEmployeeCode(branchEmployeeCode);
		
		return branchPersonnelDao.insertBranchEmployee(branchPersonnelVo);
	}
	public int insertBranchPersonnel(BranchPersonnelVO branchPersonnelVo) {
		// ==========================branchEmployeeCode설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 코드 구하기 시작]==========");
		int branchEmployeeCodeMax = branchPersonnelDao.selectBranchEmployeeCodeMax();
		String branchEmployeeCodeTemp = "bran_";
		String branchEmployeeCode = null; //완성된 코드가 들어갈 변수
		String result_no = null; //문자를 제외한 숫자부분
		int result = 0; //db에서 가져온 마지막 숫자가 들어갈 변수

		if (branchEmployeeCodeMax != 0) {
			result = branchEmployeeCodeMax;// ex)41
			result_no = String.format("%05d", result); // ex)00041
		}

		branchEmployeeCode = branchEmployeeCodeTemp + result_no; // ex) bran_ + 00041
		branchPersonnelVo.setBranchEmployeeCode(branchEmployeeCode);

		return branchPersonnelDao.insertBranchPersonnel(branchPersonnelVo); 
	}
	
	//검색한 내용 목록
	public void selectBranchPersonSearch(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("========[BranchManagerService.selectBranchPersonSearch 코드 구하기 시작]==========");
		System.out.println(" BranchManagerService searchOption : " + searchOption ); //셀렉트박스
		System.out.println(" BranchManagerService keyword : " + keyword ); //입력 내용
		
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("BranchManagerService map : " + map);
		map = pasingServiec.paging(model, currentPage, 10, branchPersonnelDao.selectBranchPessonnelrow(map), map);
		model.addAttribute("accountTitleList",branchPersonnelDao.selectBranchPersonnelSearch(map));
		
	}
	
	//각 지점에서 보는 직원 리스트 
	public List<BranchPersonnelVO> selectBranchPersonneelInfoList(Model model, HttpSession session) throws IOException {
		// ==========================selectBranchManager==============================
				System.out.println("BranchManagerService.selectBranchManager 실행");
				System.out.println("session : " + session.getAttribute("loginInfo"));
				Object se = session.getAttribute("loginInfo");
				if(se != null) {
					LoginVO login = (LoginVO) session.getAttribute("loginInfo");
					System.out.println("login.getPosition() : " + login.getPosition());
					if(login.getPosition().equals("201") || login.getPosition().equals("202")) {
						System.out.println("권한확인 완료");
						String branchEmployeeCode = login.getEmpCode();
						BranchPersonnelVO localShopCode =branchPersonnelDao.selectLocalShopCode(branchEmployeeCode);
						List<BranchPersonnelVO> BranchPersonnelInfoList = branchPersonnelDao.selectBranchPersonnelInfoList(localShopCode);
						model.addAttribute("BranchPersonnelInfoList",BranchPersonnelInfoList);
					}else{
						System.out.println("점주와 매니져만 확인가능");
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>alert('권한 미달로 인해 확인이 불가능 합니다..'); history.go(-1);</script>");
						out.flush();
					}
				}else {
					System.out.println("로그인이 되어 있지 않음");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('로그인이 되어 있지 않습니다.'); history.go(-1);</script>");
					out.flush();
				}
		return null;
	}
}