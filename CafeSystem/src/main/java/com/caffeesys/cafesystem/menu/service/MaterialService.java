package com.caffeesys.cafesystem.menu.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

 
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
	
	//selectBranchPersonnelList 조회검색
	public void selectBranchPersonnelList(Model model) {
		logger.debug("selectBranchPersonnelList 실행 ");
		model.addAttribute("materialList", materialDao.selectBranchPersonnelList());
	}
	
	/*//selectBranchPersonnelList 조회검색
		public void selectBranchPersonnelList(Model model, String searchOption, String keyword) {
			logger.debug("selectBranchPersonnelList 실행 ");
			System.out.println("searchOption : " + searchOption);
			System.out.println("keyword : " + keyword);
			Map<String, String> map;
			if(searchOption != "") {
				map = new HashMap<String, String>();
				map.put("searchOption", searchOption);
				map.put("keyword",keyword);			
			}else {
				map = null;
			}
			System.out.println("[MaterialService.selectBranchPersonnelList] map : "+map);
			model.addAttribute("materialList", materialDao.selectBranchPersonnelList(map));
		}*/
}
