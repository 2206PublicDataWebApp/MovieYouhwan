package kr.co.movieyouhwan.admin.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/admin/NoticeDetail.yh")
	public String adminNoticeDetailView() {
		return "admin/site/adminNoticeDetail";
	}

}
