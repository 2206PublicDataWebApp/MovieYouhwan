package kr.co.movieyouhwan.admin.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.service.AdminNoticeService;
import kr.co.movieyouhwan.common.page.PageInfo;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService aNoticeService;
	
	@RequestMapping(value="/admin/noticeWriteForm.yh")
	public String adminNoticeWriteForm() {
		return "admin/site/adminNoticeWrite";
	}
	
	@RequestMapping(value="/admin/noticeRegister.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeWrite(ModelAndView mv, @ModelAttribute Notice notice) {
		int result=aNoticeService.registerNotice(notice);
		if (result>0) {
			mv.addObject("tabIndex", 2);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeDetail.yh", method=RequestMethod.GET)
	public ModelAndView adminNoticeDetailView(ModelAndView mv, @RequestParam("noticeNo") int noticeNo,
			@RequestParam("nCurrentPage") int nPage) {
		try {
			Notice notice=aNoticeService.printOneNotice(noticeNo);
			notice.setPrevNotice(aNoticeService.printPrevNotice(notice.getNoticeNo()));
			notice.setNextNotice(aNoticeService.printNextNotice(notice.getNoticeNo()));
			
//		System.out.println(notice.getPrevNotice().getNoticeTitle());
			mv.addObject("notice", notice);
			mv.addObject("nCurrentPage", nPage);
			mv.setViewName("admin/site/adminNoticeDetail");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeDeleteCheck.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeDelete(ModelAndView mv, @RequestParam("checkDeleteNo") String deleteNo) {
		deleteNo=deleteNo.substring(0, deleteNo.length()-1);
//		System.out.println(deleteNo);
		int result=aNoticeService.deleteFaqList(deleteNo);
		if (result>0) {
			mv.addObject("tabIndex", 2);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeDeleteOne.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeOneDelete(ModelAndView mv, @RequestParam("noticeNo") int noticeNo) {
		int result=aNoticeService.deleteFaq(noticeNo);
		if (result>0) {
			mv.addObject("tabIndex", 2);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeModifyForm.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeModifyForm(@RequestParam("noticeNo") int noticeNo,
			@RequestParam("nCurrentPage") Integer nCurrentPage,
			ModelAndView mv) {
		Notice nOne=aNoticeService.printOneNotice(noticeNo);
		if(nOne!=null) {
			mv.addObject("notice", nOne);
			mv.addObject("nCurrentPage", nCurrentPage);
			mv.setViewName("admin/site/adminNoticeModify");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeModify.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeModify(@ModelAttribute Notice notice,
			@RequestParam("nCurrentPage") Integer nCurrentPage,
			ModelAndView mv) {
		int result=aNoticeService.modifyNotice(notice);
		if (result>0) {
			mv.addObject("noticeNo", notice.getNoticeNo());
			mv.addObject("nCurrentPage", nCurrentPage);
			mv.setViewName("redirect:/admin/noticeDetail.yh");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeSearch.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeSearch(ModelAndView mv,
			@RequestParam("searchValue") String searchValue,
			@RequestParam("searchOption") String searchOption,
			@RequestParam(value="nCurrentPage", required=false) Integer nPage) {
		try {
			System.out.println(searchValue);
			int nCurrentPage=(nPage!=null?nPage:1);
			int totalCountBySearch=aNoticeService.printTotalNoticeCount(searchOption, searchValue);
			System.out.println(1);
			PageInfo nPageInfo=new PageInfo(nCurrentPage, totalCountBySearch, 10, 5);
			System.out.println(2);
			List<Notice> nList=aNoticeService.printNoticeListBySearch(searchOption, searchValue, nPageInfo);
			System.out.println(3);
			if(nList!=null) {
				mv.addObject("nList", nList);
				mv.addObject("nPageInfo", nPageInfo);
				mv.addObject("searchOption", searchOption);
				mv.addObject("searchValue", searchValue);
				mv.addObject("tabIndex", 2);
				mv.setViewName("admin/site/adminSiteManage");
			}
			else {
				System.out.println("nList is null");
			}
			
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		return mv;
	}
	
}
