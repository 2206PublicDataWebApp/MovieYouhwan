package kr.co.movieyouhwan.admin.site.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.common.page.PageInfo;

public interface AdminNoticeStore {

	int insertNotice(SqlSessionTemplate session, Notice notice);

	List<Notice> selectNoticeList(SqlSessionTemplate session, PageInfo nPageInfo);

	int deleteNoticeList(SqlSessionTemplate session, String deleteNo);
	
	Notice selectPrevNotice(SqlSessionTemplate session, int noticeNo );
	
	Notice selectNextNotice(SqlSessionTemplate session, int noticeNo);

	Notice selectNotice(SqlSessionTemplate session, int noticeNo);

	int deleteNotice(SqlSessionTemplate session, int noticeNo);

	int updateNotice(SqlSessionTemplate session, Notice notice);

	int selectNoticeTotlaCount(SqlSessionTemplate session);

	int selectNoticeTotlaCount(SqlSessionTemplate session, String searchOption, String searchValue);

	List<Notice> selectNoticeListBySearch(SqlSessionTemplate session, String searchOption, String searchValue,
			PageInfo nPageInfo);

	List<Notice> selectNewNoticeList(SqlSessionTemplate session, int top);

	
}
