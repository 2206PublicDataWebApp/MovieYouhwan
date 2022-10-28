package kr.co.movieyouhwan.admin.site.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.site.domain.Faq;
import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.service.AdminBannerService;
import kr.co.movieyouhwan.admin.site.service.AdminFaqService;
import kr.co.movieyouhwan.admin.site.service.AdminNoticeService;
import kr.co.movieyouhwan.admin.site.service.AdminQnaService;


@Controller
public class AdminSiteController {
	
	@Autowired
	private AdminFaqService aFaqService;
	@Autowired
	private AdminNoticeService aNoticeService;
	
	private AdminQnaService aQnaService;
	
	private AdminBannerService aBannerService;
	
	/**
	 * site Manage 들어갔을 때 각 탭의 List와 선택된 탭 메뉴 index 정보 저장
	 * @param mv
	 * @param tabIndex
	 * @return
	 */
	@RequestMapping(value="/admin/site/manage.yh")
	public ModelAndView adminSiteManageView(ModelAndView mv, @RequestParam(value="tabIndex", required=false) Integer tabIndex) {
		// 선택될 Tab 메뉴 index 정보 
		Integer idx=tabIndex==null?0:tabIndex;
		mv.addObject("tabIndex", idx);
		// faq List 불러오기
		List<Faq> fList=aFaqService.printFaqList();
		
		mv.addObject("fList", fList);
		
		List<Notice> nList=aNoticeService.printNoticeList();
		mv.addObject("nList", nList);
		mv.setViewName("admin/site/adminSiteManage");
		return mv;
	}
	
}
