package kr.co.movieyouhwan.admin.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.site.domain.Faq;
import kr.co.movieyouhwan.admin.site.service.AdminFaqService;

@Controller
public class AdminFaqController {
	@Autowired
	private AdminFaqService aFaqService;
	
	
/**
 * FAQ 등록폼으로 이동
 * @param mv
 * @return
 */
	@RequestMapping(value="/admin/FaqWriteForm.yh")
	public String adminFaqWriteForm() {
		return "admin/site/adminFaqWrite";
		
	}
	
/**
 * FAQ 등록
 * @param mv
 * @param faq
 * @return
 */
	@RequestMapping(value="/admin/faqRegister.yh", method=RequestMethod.POST)
	public ModelAndView adminFaqWrite(ModelAndView mv, @ModelAttribute Faq faq) {
		int result=aFaqService.registerFaq(faq);
		mv.addObject("tabIndex", 1);
		mv.setViewName("redirect:/admin/site/manage.yh");
		return mv;
	}
	
	
	
}
