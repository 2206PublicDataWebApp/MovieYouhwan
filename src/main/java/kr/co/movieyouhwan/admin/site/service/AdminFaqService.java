package kr.co.movieyouhwan.admin.site.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.movieyouhwan.admin.site.domain.Faq;

public interface AdminFaqService {

	int registerFaq(Faq faq);

	List<Faq> printFaqList();
}
