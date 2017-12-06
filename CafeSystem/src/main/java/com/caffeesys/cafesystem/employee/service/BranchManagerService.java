package com.caffeesys.cafesystem.employee.service;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class BranchManagerService {

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
}