package kr.co.movieyouhwan.admin.site.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import kr.co.movieyouhwan.admin.site.domain.Faq;

public interface AdminFaqStore {

	int insertFaq(SqlSessionTemplate session, Faq faq);

	List<Faq> selectFaqList(SqlSessionTemplate session);

}
