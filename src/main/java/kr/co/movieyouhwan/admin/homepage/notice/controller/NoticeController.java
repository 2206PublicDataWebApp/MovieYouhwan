package kr.co.movieyouhwan.admin.homepage.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	@RequestMapping(value="/admin/adminNoticeList.yh")
	public String adminNoticeListView() {
		return "admin/homepage/adminSiteManage";
	}
	
	@RequestMapping(value="/admin/adminNoticeDetail.yh")
	public String adminNoticeDetailView() {
		return "admin/homepage/adminNoticeDetail";
	}

}
