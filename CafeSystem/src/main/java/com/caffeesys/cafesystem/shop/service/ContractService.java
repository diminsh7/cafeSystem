package com.caffeesys.cafesystem.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	// 계약서등록 과정
	public int insertContract(Contract contract) {
		System.out.println("ContractService.java/ insertContract method 확인");
		System.out.println("ContractService.java / insertContract Param contract :" + contract);
		int contractmaxnum = contractDao.selectContractMax();
		System.out.println("ContractService.java/ insertContract의 리턴값 contractmaxnum :" + contractmaxnum);		
		String contract_code_temp = "ACNT_";
		String contractcode = "ACNT_001";
		String result_no = null;
		int result = 0;
		if(contractmaxnum != 0) {
			result = contractmaxnum;
			System.out.println("ContractService.java/ insertContract result1 :"+result); // 12
			result = result + 1;
			System.out.println("ContractService.java/ insertContract result2 :"+result); // 13
			result_no = String.format("%03d", result); // 자리수 맞추기
			System.out.println("ContractService.java/ insertContract result3 :"+result_no); // 013
		}
		contractcode = contract_code_temp+ result_no; // ACNT_ + 013
		System.out.println("contractcode : "+ contractcode); // ACNT_013
		contract.setContractCode(contractcode);			
		System.out.println("ContractService.java/ contract:"+contract);
		return contractDao.insertContract(contract);
	}
}
