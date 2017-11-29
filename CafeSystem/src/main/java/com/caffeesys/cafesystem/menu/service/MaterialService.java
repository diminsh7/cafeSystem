package com.caffeesys.cafesystem.menu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service 
public class MaterialService {
	private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);

	@Autowired
	private MaterialDao materialDao;

	//원가등록  selectMaterialCodeMax
	public void insertMaterial(MaterialVO aterialVo){
		logger.debug("insertMaterial 실행 aterialVo : ", aterialVo);
		int codeMax = materialDao.selectMaterialCodeMax();
		int materialCode = codeMax + 1;
		aterialVo.setMaterialCode(materialCode);
		logger.debug("aterialVo : ", aterialVo);
		materialDao.insertMaterial(aterialVo);
	}
	
	//단가 구하기(1) 가격 용량 구하고 계산
	public double selectItemPriceSize(String itemCode, int Measure){
		logger.debug("calculator 실행 itemCode : ", itemCode);
		MaterialVO item = materialDao.selectItemPriceSize(itemCode);
		double price = (double)item.getItemPrice();
		double size = (double)item.getItemSize();	
		double cal =  price/size*(double)Measure;  //용량/구매가*용량
		System.out.println("price : " + price + "  size : " + size + " Measure : " + Measure + "  cal : " + cal );
		
		return cal;
	}
}
