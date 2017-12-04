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
public class ContractService {
	
	@Autowired
	private HttpServletResponse response;
	@Autowired
	AllJustService allJustService; // 페이징 및 검색(shop.controller폴더에)
	@Autowired
	private ContractDao contractDao;
	
	// 계약서리스트 및 조회 상세전
	public void selectContractList(Model model, String searchOption, String keyword, int currentPage) {
		System.out.println("ContractService.java / selectContractList method 확인");
		System.out.println("ContractService.java / selectContractList Param model :" + model);
		System.out.println("ContractService.java / selectContractList Param searchOption :" + searchOption);
		System.out.println("ContractService.java / selectContractList Param keyword :" + keyword);
		System.out.println("ContractService.java / selectContractList Param currentPage :" + currentPage);
		Map<String, String> map;
		if(searchOption != "") {
			map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword",keyword);			
		}else {
			map = null;
		}
		System.out.println("ContractService.java"+map);
		map = allJustService.paging(model, currentPage, 10, contractDao.selectContractCount(map), map);
		model.addAttribute("contractList", contractDao.selectContractList(map));
		model.addAttribute("contractCount", contractDao.selectContractCount(map));
	}
	// 계약서등록 과정
	public int insertContract(ContractVo contract) {
		System.out.println("ContractService.java / insertContract method 확인");
		System.out.println("ContractService.java / insertContract Param contract :" + contract);
		int contractmaxnum = contractDao.selectContractMax();
		System.out.println("ContractService.java / insertContract의 리턴값 contractmaxnum :" + contractmaxnum);		
		String contract_code_temp = "CONT_";
		String contractcode = "CONT_0001";
		String result_no = null;
		int result = 0;
		if(contractmaxnum != 0) {
			result = contractmaxnum;
			System.out.println("ContractService.java / insertContract result1 :"+result);
			result = result + 1;
			System.out.println("ContractService.java / insertContract result2 :"+result);
			result_no = String.format("%04d", result); // 자리수 맞추기
			System.out.println("ContractService.java / insertContract result3 :"+result_no);
		}
		contractcode = contract_code_temp+ result_no;
		System.out.println("contractcode : "+ contractcode);
		contract.setContractCode(contractcode);
		System.out.println("ContractService.java / contract:"+contract);
		return contractDao.insertContract(contract);
	}
	
	// 계약서상세조회(지점)
	public void branchContractList(Model model,HttpSession session) throws IOException{
		System.out.println("ContractService.java / branchContractList method 확인");
		System.out.println("session : " + session.getAttribute("loginInfo"));
		Object se = session.getAttribute("loginInfo");
		if(se != null) {
			LoginVO login = (LoginVO) session.getAttribute("loginInfo");
			if(login.getEmpCode().equals("") || login.getPosition().equals("201")) {
				System.out.println("점주권한으로 계약서정보 확인가능");
				String branchEmployeeCode = login.getEmpCode();
				List<ContractVo> contractList = contractDao.branchContractList(branchEmployeeCode);
				System.out.println("contractList : " + contractList);
				model.addAttribute("contractList",contractList);
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
