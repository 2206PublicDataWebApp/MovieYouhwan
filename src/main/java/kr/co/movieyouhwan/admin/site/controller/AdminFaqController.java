package kr.co.movieyouhwan.admin.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/admin/faqWriteForm.yh")
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
		if (result>0) {
			mv.addObject("tabIndex", 0);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
	
	/**
	 * FAQ 수정 화면에 들어갈 데이터 준비 & 수정화면으로 이동 
	 * @return
	 */
	@RequestMapping(value="/admin/faqModifyForm.yh", method=RequestMethod.POST)
	public ModelAndView adminFaqModifyForm(
			ModelAndView mv,
			@RequestParam("faqNo") int faqNo) {
		Faq fOne=aFaqService.printOneFaq(faqNo);
		if(fOne!=null) {
			mv.addObject("faq", fOne);
			mv.setViewName("admin/site/adminFaqModify");
		}
		return mv;
	}

	@RequestMapping(value="/admin/faqModify.yh", method=RequestMethod.POST)
	public ModelAndView adminFaqModify(ModelAndView mv, @ModelAttribute Faq faq) {
		int result=aFaqService.modifyFaq(faq);
		if(result>0) {
			mv.addObject("tabIndex", 0);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/faqDelete.yh", method=RequestMethod.POST)
	public ModelAndView adminFaqDelete(ModelAndView mv, @RequestParam("checkDeleteNo") String deleteNo) {
		deleteNo=deleteNo.substring(0, deleteNo.length()-1);
		int result=aFaqService.deleteFaqList(deleteNo);
		if(result>0) {
			mv.addObject("tabIndex", 0);
			mv.setViewName("redirect:/admin/site/manage.yh");
		}
		return mv;
	}
}
