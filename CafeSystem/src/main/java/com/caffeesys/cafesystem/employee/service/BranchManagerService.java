package com.caffeesys.cafesystem.employee.service;
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BranchManagerService {

	@Autowired
	private BranchManagerDao branchManagerDao;
	
	//점주 입력 폼에서 매장 번호 선택
	public List<BranchManager> selectBranchManagerShopCode(Model model) {
		System.out.println("========[BranchManagerService.insertBranchManager 지역에 따른 매장번호 구하기 시작]==========");
		List<BranchManager> list = BranchManagerDao.selectBranchManagerShopcode();
		model.addAttribute("BranchManagerShopCode",list);
		System.out.println("[BranchManagerService.selectBranchManagerShopCode] list :" + list);
		return list;
	}
	
	//점주 등록과정
	public int insertBranchManager(BranchManager branchManager) {
		System.out.println("[BranchManagerService.insertBranchManager] 실행");
		System.out.println("[BranchManagerService.insertBranchManager] :" + branchManager);
		
		//==========================branchEmployee포지션 코드 설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 포지션 코드 추가]==========");
		branchManager.setPositionCategoryCode("201");
		System.out.println("[BranchManagerService.insertBranchManager] branchManager : " + branchManager);
		
		//==========================branchEmployeeCode 설정하기==============================
		System.out.println("========[BranchManagerService.insertBranchManager 코드 구하기 시작]==========");
		int branchEmployeeCodeMax = branchManagerDao.selectBranchEmployeeCodeMax();
		System.out.println("[BranchManagerService.insertBranchManager] 마지막코드branchImployeeCodeMax : " + branchEmployeeCodeMax);
		String branchEmployeeCodeTemp = "bran_"; 
		String branchEmployeeCode = "bran_00001";
		String result_no = null;
		int result = 0;
		
		if(branchEmployeeCodeMax != 0) {
			result = branchEmployeeCodeMax;
			System.out.println("[BranchManagerService.insertBranchManager] result(1) : " + result); //ex)41
			result ++;
			System.out.println("[BranchManagerService.insertBranchManager] result(2) : " + result); //ex)42
			result_no = String.format("%05d", result);
			System.out.println("[BranchManagerService.insertBranchManager] result_no : " + result_no); //ex)00042
		}
		
		branchEmployeeCode = branchEmployeeCodeTemp + result_no; //ex) bran_ + 00042
		System.out.println("[BranchManagerService.insertBranchManager] branchEmployeeCode : " + branchEmployeeCode);
		branchManager.setBranchEmployeeCode(branchEmployeeCode);
		
		return branchManagerDao.insertBranchEmployeeAndManager(branchManager);
	};
	

}