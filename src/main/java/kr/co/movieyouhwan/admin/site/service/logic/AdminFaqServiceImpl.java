package kr.co.movieyouhwan.admin.site.service.logic;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.movieyouhwan.admin.site.domain.Faq;
import kr.co.movieyouhwan.admin.site.service.AdminFaqService;
import kr.co.movieyouhwan.admin.site.store.AdminFaqStore;

@Service
public class AdminFaqServiceImpl implements AdminFaqService{
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private AdminFaqStore aFaqStore;
	
	@Override
	public int registerFaq(Faq faq) {
		int result=aFaqStore.insertFaq(session, faq);
		return result;
	}

	@Override
	public List<Faq> printFaqList() {
		List<Faq> fList=aFaqStore.selectFaqList(session);
		return fList;
	}

}
