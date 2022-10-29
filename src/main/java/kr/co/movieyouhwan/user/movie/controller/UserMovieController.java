package kr.co.movieyouhwan.user.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;

@Controller
public class UserMovieController {
	@Autowired
	private AdminMovieService aMovieService;
	
	/**
	 * 영화 목록 화면
	 * @param mv
	 * @param movie
	 * @return
	 */
	@RequestMapping(value="/user/movieList.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListView(
			ModelAndView mv,
			@ModelAttribute Movie movie) {
		List<Movie> mList = aMovieService.printAllMovie();
		mv.addObject("mList", mList);
		mv.setViewName("user/movie/movieList");
		return mv;
	}
}
