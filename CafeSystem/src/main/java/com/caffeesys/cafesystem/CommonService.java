package com.caffeesys.cafesystem;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.caffeesys.cafesystem.login.service.LoginVO;

@Service
public class CommonService {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CommonDao commonDao;
	
	// 검색 목록 페이징 (목록 페이징 매개변수 + map 검색조건과 검색어가 담겨서 옴)
	public Map<String, String> paging(Model model, int currentPage, int pagePerRow, int count, Map<String, String> map) {
		if (map != null) {
			model.addAttribute("cate", map.get("cate"));
			model.addAttribute("input", map.get("input"));
		} else {
			map = new HashMap<String, String>();
		}
		//System.out.println("count: " + count);
		//System.out.println("pagePerRow: " + pagePerRow);
		int page = 1;
		int maxPage = (int)((double)count/pagePerRow+0.95);
		int startPage = (((int)((double)page / 10 + 0.9)) - 1 ) * 10 + 1;
		int endPage = startPage+10-1;
		if(endPage > maxPage) endPage = maxPage;
		int lastPage = count / pagePerRow;
		//System.out.println("lastPage: " + lastPage);
		if ((count % pagePerRow) != 0) {
			lastPage += 1;
		}
		
		//System.out.println("currentPage: " + currentPage);
		//System.out.println("lastPage: " + lastPage);
		//System.out.println("startPage: " + startPage);
		//System.out.println("endPage: " + endPage);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		map.put("start", Integer.toString((currentPage - 1) * pagePerRow));
		map.put("pagePerRow", Integer.toString(pagePerRow));
		return map;
	}
	
	//전표번호 생성을 위한 현재 날짜 불러오기 (YY-MM-DD)
	public String dateSelect() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yy.MM.dd", Locale.KOREA );
		Date date = new Date();
		String nowDate = mSimpleDateFormat.format( date );
		String currentDate = nowDate.replace(".", "");
		//System.out.println (currentDate);

		return currentDate;
	}
	
	//지역, 매장 코드 불러오기
	public List<HashMap<String, Object>> localShopCodeSelect() {
		LoginVO login = (LoginVO) session.getAttribute("loginInfo");
		String employeeCode = login.getEmpCode();
		//System.out.println("employeeCode: " + employeeCode);

		return commonDao.localShopCodeSelect(employeeCode);
	}
	
	//돈 3자리 마다 , 찍기
	public String comma(int val) {
		NumberFormat format = NumberFormat.getNumberInstance();
		return format.format(val);
	}

}
