package kr.co.movieyouhwan.admin.site.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.store.AdminNoticeStore;
import kr.co.movieyouhwan.common.page.PageInfo;

@Repository
public class AdminNoticeStoreLogic implements AdminNoticeStore{

	@Override
	public int insertNotice(SqlSessionTemplate session, Notice notice) {
		int result=session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSessionTemplate session,PageInfo nPageInfo) {
		int offset=(nPageInfo.getCurrentPage()-1)*nPageInfo.getDataLimit();
		RowBounds rowBounds=new RowBounds(offset, nPageInfo.getDataLimit());
		List<Notice> nList=session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
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

	@Override
	public int updateNotice(SqlSessionTemplate session, Notice notice) {
		int result=session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int selectNoticeTotlaCount(SqlSessionTemplate session) {
		int count=session.selectOne("NoticeMapper.selectNoticeTotalCount");
		return count;
	}

	@Override
	public int selectNoticeTotlaCount(SqlSessionTemplate session, String searchOption, String searchValue) {
		HashMap<String, String> paraMap=new HashMap<String, String>();
		paraMap.put("searchOption", searchOption);
		paraMap.put("searchValue", searchValue);
		int count=session.selectOne("NoticeMapper.selectNoticeTotalCountBySearch", paraMap);
		return count;
	}

	@Override
	public List<Notice> selectNoticeListBySearch(SqlSessionTemplate session, String searchOption, String searchValue,
			PageInfo nPageInfo) {
		int offset=(nPageInfo.getCurrentPage()-1)*nPageInfo.getDataLimit();
		RowBounds rowBounds=new RowBounds(offset, nPageInfo.getDataLimit());
		HashMap<String, String> paraMap=new HashMap<String,String>();
		paraMap.put("searchOption", searchOption);
		paraMap.put("searchValue", searchValue);
		List<Notice> nList=session.selectList("NoticeMapper.selectNoticeListBySearch", paraMap, rowBounds);
		return nList;
	}
}
