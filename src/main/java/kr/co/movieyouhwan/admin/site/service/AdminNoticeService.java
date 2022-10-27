package kr.co.movieyouhwan.admin.site.service;

import java.util.List;

import kr.co.movieyouhwan.admin.site.domain.Notice;

public interface AdminNoticeService {

	int registerNotice(Notice notice);

	List<Notice> printNoticeList();

}
