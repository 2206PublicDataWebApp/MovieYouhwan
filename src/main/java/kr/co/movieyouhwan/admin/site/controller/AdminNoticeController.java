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
	@RequestMapping(value="/admin/NoticeDetail.yh", method=RequestMethod.GET)
	public ModelAndView adminNoticeDetailView(ModelAndView mv, @RequestParam("noticeNo") int noticeNo) {
		Notice notice=aNoticeService.printOneNotice(noticeNo);
		notice.setPrevNotice(aNoticeService.printPrevNotice(notice.getNoticeNo()));
		notice.setNextNotice(aNoticeService.printNextNotice(notice.getNoticeNo()));
		
//		System.out.println(notice.getPrevNotice().getNoticeTitle());
		mv.addObject("notice", notice);
		mv.setViewName("admin/site/adminNoticeDetail");
		
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
			ModelAndView mv) {
		Notice nOne=aNoticeService.printOneNotice(noticeNo);
		if(nOne!=null) {
			mv.addObject("notice", nOne);
			mv.setViewName("admin/site/adminNoticeModify");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/noticeModify.yh", method=RequestMethod.POST)
	public ModelAndView adminNoticeModify(@ModelAttribute Notice notice,
			ModelAndView mv) {
		int result=aNoticeService.modifyNotice(notice);
		if (result>0) {
			mv.addObject("noticeNo", notice.getNoticeNo());
			mv.setViewName("redirect:/admin/NoticeDetail.yh");
		}
		return mv;
	}
	
//	@RequestMapping(value="/admin/noticeSearch.yh", method=RequestMethod.GET)
//	public ModelAndView adminNoticeSearch(ModelAndView mv,
//			@RequestParam("searchValue") String searchValue,
//			@RequestParam("searcOption") String searchOption) {
//		try {
//			List<Notice> nList=aNoticeService.printNoticeListBySearch(searchOption, searchValue);
//		}catch(Exception e){
//			
//		}
//		return mv;
//	}
	
}
