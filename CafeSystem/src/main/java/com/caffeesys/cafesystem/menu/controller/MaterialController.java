package com.caffeesys.cafesystem.menu.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.caffeesys.cafesystem.menu.service.MaterialDao;
import com.caffeesys.cafesystem.menu.service.MaterialService;
import com.caffeesys.cafesystem.menu.service.MaterialVO;

@Controller
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private MaterialDao materialDao;
	
	//메뉴원가등록 폼 요청
	@RequestMapping(value = "/insertMaterial", method = RequestMethod.GET)
	public String insertBranchManager(Model model) throws Exception { 
		System.out.println("[menu.controller.MaterialController.java] : 메뉴원가 폼 페이지 실행 컨트롤러");
		List<MaterialVO> selectManuNameList = materialDao.selectManuName();
		List<MaterialVO> selectSize = materialDao.selectSize();
		List<MaterialVO> selectTemp = materialDao.selectTemp();
		List<MaterialVO> selectitem = materialDao.selectitem();
		System.out.println(" selectSize : " + selectSize );
		System.out.println(" selectTemp : " + selectTemp);
		model.addAttribute("ManuNameList",selectManuNameList);
		model.addAttribute("Size",selectSize);
		model.addAttribute("Temp",selectTemp);
		model.addAttribute("item",selectitem);
		return "/menu/materialInsertForm";
	} 
	//메뉴원가 등록 실행 
	@RequestMapping(value = "/insertMaterial", method = RequestMethod.POST)
	public String insertBranchManager(Model model, MaterialVO materialVo) throws Exception { 
		System.out.println("[menu.controller.MaterialController.java] : 메뉴원가 등록 컨트롤러");
		materialService.insertMaterial(materialVo);
		return "redirect:/MaterialList";
	} 
	
	//메뉴원가 리스트 
	@RequestMapping(value = "/MaterialList")
	public String selectBranchPersonnelList(Model model) throws Exception { 
		System.out.println("[menu.controller.MaterialController.java] : 메뉴원가 리스트 출력 컨트롤러");
		List<MaterialVO> materialList = materialDao.selectBranchPersonnelList();
		model.addAttribute("materialList",materialList);
		System.out.println("materialList : " + materialList);
		return "menu/materialList";
	} 
	
	//삭제 컨트롤러
	@RequestMapping(value = "/deleteMaterial", method = RequestMethod.GET)
	public String deleteMaterial(@RequestParam(value = "materialCode", required = true) int materialCode) {
		System.out.println("[menu.controller.deleteMaterial.java] : 메뉴원가 삭제 컨트롤러");
		System.out.println("materialCode : " + materialCode);
		materialDao.deleteMaterial(materialCode);
		return "redirect:/MaterialList";
	}
	
	//수정 폼 이동 컨트롤러
	@RequestMapping(value = "/updateMaterial", method = RequestMethod.GET)
	public String updateMaterial(Model model,@RequestParam(value = "materialCode", required = true) int materialCode) throws Exception {
		System.out.println("[menu.controller.updateMaterial.java] : 메뉴원가 수정 컨트롤러");
		List<MaterialVO> selectManuName = materialDao.selectManuName();
		List<MaterialVO> selectSize = materialDao.selectSize();
		List<MaterialVO> selectTemp = materialDao.selectTemp();
		List<MaterialVO> selectitem = materialDao.selectitem();
		List<MaterialVO> materiaList= materialDao.selectUpdateMaterial(materialCode);
		model.addAttribute("ManuNameList",selectManuName);
		model.addAttribute("Size",selectSize);
		model.addAttribute("Temp",selectTemp);
		model.addAttribute("item",selectitem);
		model.addAttribute("updateMaterial", materiaList);
		return "menu/materialUpdateForm";
	}
	
}
