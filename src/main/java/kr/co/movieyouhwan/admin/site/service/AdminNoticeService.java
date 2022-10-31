package kr.co.movieyouhwan.admin.site.service;

import java.util.List;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.common.page.PageInfo;

public interface AdminNoticeService {

	int registerNotice(Notice notice);

	List<Notice> printNoticeList(PageInfo nPageInfo);

	int deleteFaqList(String deleteNo);

	Notice printPrevNotice(int noticeNo);

	Notice printNextNotice(int noticeNo);

	Notice printOneNotice(int noticeNo);

	int deleteFaq(int noticeNo);

	int modifyNotice(Notice notice);

	int printTotalNoticeCount();

	int printTotalNoticeCount(String searchOption, String searchValue);

	List<Notice> printNoticeListBySearch(String searchOption, String searchValue, PageInfo nPageInfo);

}
