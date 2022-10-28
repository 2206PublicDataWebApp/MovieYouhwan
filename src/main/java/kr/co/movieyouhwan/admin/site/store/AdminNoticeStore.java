package kr.co.movieyouhwan.admin.site.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.site.domain.Notice;

public interface AdminNoticeStore {

	int insertNotice(SqlSessionTemplate session, Notice notice);

	List<Notice> selectNoticeList(SqlSessionTemplate session);

	int deleteNoticeList(SqlSessionTemplate session, String deleteNo);
	
	Notice selectPrevNotice(SqlSessionTemplate session, int noticeNo );
	
	Notice selectNextNotice(SqlSessionTemplate session, int noticeNo);

	Notice selectNotice(SqlSessionTemplate session, int noticeNo);

	int deleteNotice(SqlSessionTemplate session, int noticeNo);

	
}
