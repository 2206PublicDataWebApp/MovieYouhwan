package kr.co.movieyouhwan.admin.homepage.faq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.homepage.faq.domain.Faq;

@Controller
public class FaqController {
	
	@RequestMapping(value="/admin/adminFaqList.yh")
	public String adminFaqListView() {
		return "admin/homepage/adminFaqList";
	}
	
	@RequestMapping(value="/admin/FaqWriteForm.yh")
	public String adminFaqWriteForm() {
		return "admin/homepage/adminFaqWrite";
	}
	
	@RequestMapping(value="/admin/faqRegister.yh", method=RequestMethod.POST)
	public String adminFaqWrite(ModelAndView mv, @ModelAttribute Faq faq) {
		System.out.println(faq.getNoticeTitle());
		System.out.println(faq.getNoticeContent());
		return "admin/homepage/adminFaqList";
	}
	
	

}
