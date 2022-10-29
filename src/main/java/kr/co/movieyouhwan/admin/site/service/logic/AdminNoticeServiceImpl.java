package kr.co.movieyouhwan.admin.site.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.service.AdminNoticeService;
import kr.co.movieyouhwan.admin.site.store.AdminNoticeStore;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService{

	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private AdminNoticeStore aNoticeStore;
	
	@Override
	public int registerNotice(Notice notice) {
		int result=aNoticeStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public List<Notice> printNoticeList() {
		List<Notice> nList=aNoticeStore.selectNoticeList(session);
		return nList;
	}

	@Override
	public int deleteFaqList(String deleteNo) {
		int result=aNoticeStore.deleteNoticeList(session, deleteNo);
		return result;
	}

	@Override
	public Notice printPrevNotice(int noticeNo) {
		Notice nOne=aNoticeStore.selectPrevNotice(session, noticeNo);
		return nOne;
	}

	@Override
	public Notice printNextNotice(int noticeNo) {
		Notice nOne=aNoticeStore.selectNextNotice(session, noticeNo);
		return nOne;
	}

	@Override
	public Notice printOneNotice(int noticeNo) {
		Notice nOne=aNoticeStore.selectNotice(session, noticeNo);
		return nOne;
	}

	@Override
	public int deleteFaq(int noticeNo) {
		int result=aNoticeStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public int modifyNotice(Notice notice) {
		int result=aNoticeStore.updateNotice(session, notice);
		return result;
	}
	
	

}
