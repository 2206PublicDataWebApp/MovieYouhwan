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

}
