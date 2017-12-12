package com.caffeesys.cafesystem.menu.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.employee.controller.AllService;

 
@Service 
public class MaterialService {
	private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);

	@Autowired
	private MaterialDao materialDao;
	@Autowired
	private AllService allService;

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
	
	//selectBranchPersonnelList 조회검색
	public void selectMateriallList(Model model, String cate, String input) {
		logger.debug("selectBranchPersonnelList 실행 ");
		System.out.println("cate :" + cate);
		System.out.println("input :" + input);
		Map<String, String> map;
		if(cate != "") {
			map = new HashMap<String, String>();
			map.put("cate", cate);
			map.put("input", input);
		} else {
			map = null;
		}
		map = allService.paging(model,map);
		List<MaterialVO> materialList = materialDao.selectMateriallList(map);
		model.addAttribute("materialList",materialList);
	}
}