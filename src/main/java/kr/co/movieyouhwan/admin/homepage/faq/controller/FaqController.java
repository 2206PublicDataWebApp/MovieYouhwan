package kr.co.movieyouhwan.admin.homepage.faq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaqController {
	
	@RequestMapping(value="/admin/adminFaqList.yh")
	public String adminFaqListView() {
		return "admin/homepage/adminFaqList";
	}
	
	@RequestMapping(value="/admin/adminFaqWriteForm.yh")
	public String adminFaqWriteForm() {
		return "admin/homepage/adminFaqWrite";
	}
	
	

}
