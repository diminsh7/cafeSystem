package com.caffeesys.cafesystem.shop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ContractService {
	
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
}
