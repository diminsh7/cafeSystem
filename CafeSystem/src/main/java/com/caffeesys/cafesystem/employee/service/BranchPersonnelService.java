package com.caffeesys.cafesystem.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchPersonnelService {

	@Autowired
	private BranchPersonnelDao branchPersonnelDao;
	
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
	
}
