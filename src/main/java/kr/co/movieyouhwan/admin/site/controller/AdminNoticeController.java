package kr.co.movieyouhwan.admin.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminNoticeController {
	
	@RequestMapping(value="/admin/NoticeDetail.yh")
	public String adminNoticeDetailView() {
		return "admin/site/adminNoticeDetail";
	}

}
