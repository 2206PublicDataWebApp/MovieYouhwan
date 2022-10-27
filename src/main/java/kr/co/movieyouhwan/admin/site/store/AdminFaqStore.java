package kr.co.movieyouhwan.admin.site.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.site.domain.Faq;

public interface AdminFaqStore {

	public int insertFaq(SqlSessionTemplate session, Faq faq);

	public List<Faq> selectFaqList(SqlSessionTemplate session);

	public Faq selectFaq(SqlSessionTemplate session, Integer faqNo);

	public int updateFaq(SqlSessionTemplate session, Faq faq);

	public int deleteFaqList(SqlSessionTemplate session, String deleteNo);
	
}
