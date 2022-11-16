package kr.co.movieyouhwan;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.site.domain.Faq;
import kr.co.movieyouhwan.admin.site.domain.Notice;
import kr.co.movieyouhwan.admin.site.service.AdminFaqService;
import kr.co.movieyouhwan.admin.site.service.AdminNoticeService;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;
import kr.co.movieyouhwan.user.store.domain.BestProduct;
import kr.co.movieyouhwan.user.store.service.UserStoreService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserStoreService uStoreService;
	
	@Autowired
	AdminFaqService aFaqService;
	
	@Autowired
	AdminNoticeService aNoticeService;
	
	@Autowired
	UserMovieService uMovieService; 

	@RequestMapping(value = "/home.yh", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv) {

		// TODO: MOVIE CHART 불러오기 => 이대로 Service -> Store -> Mapper만 작성하기!!!!
		int movieChartCount = 4;
//		List<MovieList> movieList = uMovieService.printMovieChartList(movieChartCount);
//		if (!movieChartList.isEmpty()) {
//			mv.addObject("movieList", movieList);
//		}
		
		// NOTE: STORE BEST 불러오기
		int bestProductCount = 4;
		List<BestProduct> productList = uStoreService.printBestProductList(bestProductCount);
		if (!productList.isEmpty()) {
			mv.addObject("productList", productList);
		}
		
		// NOTE: FAQ & NOTICE 불러오기
		int supportCount = 5;
		List<Faq> faqList = aFaqService.printNewFaqList(supportCount);
		if (!faqList.isEmpty()) {
			mv.addObject("faqList", faqList);
		}
		List<Notice> noticeList = aNoticeService.printNewNoticeList(supportCount);
		if (!noticeList.isEmpty()) {
			mv.addObject("noticeList", noticeList);
		}

		mv.setViewName("home");
		return mv;
	}

}
