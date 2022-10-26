package kr.co.movieyouhwan.admin.site.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.movieyouhwan.admin.site.domain.Faq;

public interface AdminFaqService {

	public int registerFaq(Faq faq);

	public List<Faq> printFaqList();

	public Faq printOneFaq(Integer faqNo);

	public int modifyFaq(Faq faq);
}
