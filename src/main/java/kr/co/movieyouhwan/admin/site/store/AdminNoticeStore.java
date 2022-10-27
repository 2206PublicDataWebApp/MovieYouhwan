package kr.co.movieyouhwan.admin.site.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.site.domain.Notice;

public interface AdminNoticeStore {

	int insertNotice(SqlSessionTemplate session, Notice notice);

	List<Notice> selectNoticeList(SqlSessionTemplate session);

}
