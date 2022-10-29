package kr.co.movieyouhwan.admin.site.service;

import java.util.List;

import kr.co.movieyouhwan.admin.site.domain.Notice;

public interface AdminNoticeService {

	int registerNotice(Notice notice);

	List<Notice> printNoticeList();

	int deleteFaqList(String deleteNo);

	Notice printPrevNotice(int noticeNo);

	Notice printNextNotice(int noticeNo);

	Notice printOneNotice(int noticeNo);

	int deleteFaq(int noticeNo);

	int modifyNotice(Notice notice);

}
