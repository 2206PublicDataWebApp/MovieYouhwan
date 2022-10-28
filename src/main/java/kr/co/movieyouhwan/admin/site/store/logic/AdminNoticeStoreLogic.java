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

	@Override
	public int deleteNoticeList(SqlSessionTemplate session, String deleteNo) {
		int result=session.delete("NoticeMapper.deleteNoticeList", deleteNo);
		return result;
	}

	@Override
	public Notice selectPrevNotice(SqlSessionTemplate session, int noticeNo) {
		Notice nOne=session.selectOne("NoticeMapper.selectPrevNotice", noticeNo);
		return nOne;
	}

	@Override
	public Notice selectNextNotice(SqlSessionTemplate session, int noticeNo) {
		Notice nOne=session.selectOne("NoticeMapper.selectNextNotice", noticeNo);
		return nOne;
	}

	@Override
	public Notice selectNotice(SqlSessionTemplate session, int noticeNo) {
		Notice nOne=session.selectOne("NoticeMapper.selectNotice", noticeNo);
		return nOne;
	}

	@Override
	public int deleteNotice(SqlSessionTemplate session, int noticeNo) {
		int result=session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}
}
