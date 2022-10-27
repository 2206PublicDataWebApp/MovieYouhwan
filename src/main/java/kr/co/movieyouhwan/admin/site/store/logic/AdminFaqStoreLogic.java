package kr.co.movieyouhwan.admin.site.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.movieyouhwan.admin.site.domain.Faq;
import kr.co.movieyouhwan.admin.site.store.AdminFaqStore;

@Repository
public class AdminFaqStoreLogic implements AdminFaqStore{

	@Override
	public int insertFaq(SqlSessionTemplate session, Faq faq) {
		System.out.println(faq.getAdminId());
		System.out.println(faq.getFaqNo());
		int result=session.insert("FaqMapper.insertFaq", faq);
		return result;
	}

	@Override
	public List<Faq> selectFaqList(SqlSessionTemplate session) {
		List<Faq> fList=session.selectList("FaqMapper.selectFaqList");
		return fList;
	}

	@Override
	public Faq selectFaq(SqlSessionTemplate session, Integer faqNo) {
		Faq fOne=session.selectOne("FaqMapper.selectFaq", faqNo);
		return fOne;
	}

	@Override
	public int updateFaq(SqlSessionTemplate session, Faq faq) {
		int result=session.update("FaqMapper.updateFaq", faq);
		return result;
	}

	@Override
	public int deleteFaqList(SqlSessionTemplate session, String deleteNo) {
		int result=session.delete("FaqMapper.deleteFaqList", deleteNo);
		return result;
	}
	
}


