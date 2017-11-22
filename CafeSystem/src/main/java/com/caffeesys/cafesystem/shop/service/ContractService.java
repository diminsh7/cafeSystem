package com.caffeesys.cafesystem.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
	
	@Autowired
	private ContractDao contractDao;

	// 계약서등록 과정
	public int insertContract(ContractVo contract) {
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
			result_no = String.format("%04d", result); // 자리수 맞추기
			System.out.println("ContractService.java/ insertContract result3 :"+result_no);
		}
		contractcode = contract_code_temp+ result_no;
		System.out.println("contractcode : "+ contractcode);
		contract.setContractCode(contractcode);
		System.out.println("ContractService.java/ contract:"+contract);
		return contractDao.insertContract(contract);
	}
	// 계약서검색조회목록
	public List<ContractVo> searchContract(String searchOption, String keyword) {
		System.out.println("ContractService.java/ searchContract method 확인");
		System.out.println("ContractService.java / searchContract Param searchOption :" + searchOption);
		System.out.println("ContractService.java / searchContract Param keyword :" + keyword);
		return contractDao.searchContract(searchOption, keyword);
	}
	// 계약서검색조회갯수
	public int searchContractCount(String searchOption, String keyword) {
		System.out.println("ContractService.java/ searchContractCount method 확인");
		System.out.println("ContractService.java / searchContractCount Param searchOption :" + searchOption);
		System.out.println("ContractService.java / searchContractCount Param keyword :" + keyword);
		return contractDao.searchContractCount(searchOption, keyword);
	}
/*	// 계약서검색조회 임시테스트
		public void searchContract(Model model, String con, String consearch, int currentPage){
			Map<String, String> map = new HashMap<String, String>();
			map.put("con", con);
			map.put("consearch", consearch);		
			map = commonService.searchPaging(model, currentPage, 2, cateDao.cateSearchCount(map), map);
	        model.addAttribute("cateList", cateDao.cateSearch(map));
	        model.addAttribute("page", "cateSearch");
		}*/
}
