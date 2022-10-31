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
import kr.co.movieyouhwan.common.page.PageInfo;


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
	@RequestMapping(value="/admin/site/manage.yh", method=RequestMethod.GET)
	public ModelAndView adminSiteManageView(ModelAndView mv, 
			@RequestParam(value="tabIndex", required=false) Integer tabIndex,
			@RequestParam(value="nCurrentPage", required=false) Integer nPage,
			@RequestParam(value="qCurrentPage", required=false) Integer qPage,
			@RequestParam(value="nSearchOption", required=false) String nSearchOption,
			@RequestParam(value="nSearchValue", required=false) String nSearchValue,
			@RequestParam(value="qSearchOption", required=false) String qSearchOption,
			@RequestParam(value="qSearchValue", required=false) String qSearchValue){
		// 선택될 Tab 메뉴 index 정보 
		Integer idx=tabIndex==null?0:tabIndex;
		mv.addObject("tabIndex", idx);
		
		// searchOption과 searchValue가 없으면 ""로 처리
		String noticeSearchOption=(nSearchOption!=null?nSearchOption:"");
		String noticeSearchValue=(nSearchValue!=null?nSearchValue:"");
		
		// 공지사항 페이징 처리
		// PageInfo(int currentPage, int dataCount, int dataLimit, int pageLimit);
		int nCurrentPage=(nPage!=null?nPage:1);
		PageInfo nPageInfo=new PageInfo(nCurrentPage, aNoticeService.printTotalNoticeCount(noticeSearchOption, noticeSearchValue), 10, 5);
		
		
		// 공지사항 리스트 불러오기
		List<Notice> nList=aNoticeService.printNoticeList(nPageInfo);
		mv.addObject("nPageInfo", nPageInfo);
		mv.addObject("nList", nList);
		
		// faq 리스트 불러오기
		List<Faq> fList=aFaqService.printFaqList();
		mv.addObject("fList", fList);
		
		mv.setViewName("admin/site/adminSiteManage");
		return mv;
	}
}
