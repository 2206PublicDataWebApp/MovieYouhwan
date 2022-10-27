package kr.co.movieyouhwan.admin.site.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.store.AdminNoticeStore;

@Repository
public class AdminNoticeStoreLogic implements AdminNoticeStore{

	@Override
	public int insertNotice(SqlSessionTemplate session, Notice notice) {
		int result=session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSessionTemplate session) {
		List<Notice> nList=session.selectList("NoticeMapper.selectNoticeList");
		return nList;
	}
	

}
