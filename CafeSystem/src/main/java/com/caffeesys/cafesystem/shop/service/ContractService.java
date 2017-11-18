package com.caffeesys.cafesystem.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.shop.controller.ContractController;

@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	private ContractController contractController;
	// 계약서등록 과정
	public int insertContract(Contract contract) {
		System.out.println("ContractService.java/ insertContract method 확인");
		System.out.println("ContractService.java / insertContract Param contract :" + contract);
		int contractmaxnum = contractDao.selectContractMax();
		System.out.println("ContractService.java/ insertContract의 리턴값 contractmaxnum :" + contractmaxnum);		
		String contract_code_temp = "CONT_";
		String contractcode = "CONT_0001";
		String result_no = null;
		int result = 0;
		if(contractmaxnum != 0) {
			result = contractmaxnum;
			System.out.println("ContractService.java/ insertContract result1 :"+result);
			result = result + 1;
			System.out.println("ContractService.java/ insertContract result2 :"+result);
			result_no = String.format("%05d", result); // 자리수 맞추기
			System.out.println("ContractService.java/ insertContract result3 :"+result_no);
		}
		contractcode = contract_code_temp+ result_no;
		System.out.println("contractcode : "+ contractcode);
		contract.setContractCode(contractcode);
		System.out.println("ContractService.java/ contract:"+contract);
		return contractDao.insertContract(contract);
	}
	// 전체게약서조회 상세전
	public List<Contract> listContract(Model model) {
		System.out.println("ContractService.java/ listContract method 확인");
		List<Contract> list = contractDao.selectContractList();
		model.addAttribute("contractlist", list);
		System.out.println("ContractService.java/ listContract method의 리턴값list:"+list);
		return list;
	}
}
