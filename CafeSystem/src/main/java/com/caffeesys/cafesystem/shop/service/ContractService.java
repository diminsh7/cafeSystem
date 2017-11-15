package com.caffeesys.cafesystem.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	public int insertContract(Contract contract) {
		
		contract.setContractOwnerName(contract.getContractOwnerName());
		contract.setContractShopName(contract.getContractShopName());
		contract.setContractOwnerPhone(contract.getContractOwnerPhone());
		contract.setContractStartDate(contract.getContractStartDate());
		contract.setContractEndDate(contract.getContractEndDate());
		contract.setContractPhoto(contract.getContractPhoto());
		return contractDao.insertContract(contract);
	}
}
/*
Contract contract2 = new Contract();
contract.setContractOwnerName(contractRequest.getContractOwnerName());
contract.setContractShopName(contractRequest.getContractShopName());
contract.setContractOwnerPhone(contractRequest.getContractOwnerPhone());
contract.setContractStartDate(contractRequest.getContractStartDate());
contract.setContractEndDate(contractRequest.getContractEndDate());
contract.setContractPhoto(contractRequest.getContractPhoto());
return contractDao.insertContract(contract);
*/
