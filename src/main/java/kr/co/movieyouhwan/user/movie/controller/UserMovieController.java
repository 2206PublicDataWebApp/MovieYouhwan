package kr.co.movieyouhwan.user.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

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
	@RequestMapping(value="/movieList.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListView(
			ModelAndView mv,
			@ModelAttribute Movie movie) {
		List<Movie> mList = aMovieService.printAllMovie();
		mv.addObject("mList", mList);
		mv.setViewName("user/movie/movieList");
		return mv;
	}
	
	/**
	 * 영화 예매 (영화관, 영화, 시간 선택)
	 * @param mv
	 * @param cinema
	 * @param theater
	 * @param movie
	 * @param movieTime
	 * @return
	 */
	@RequestMapping(value="/movieTicketTime.yh", method=RequestMethod.GET)
	public ModelAndView movieTicketTimeView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema,
			@ModelAttribute Theater theater,
			@ModelAttribute Movie movie,
			@ModelAttribute MovieTime movieTime) {
		mv.setViewName("user/movie/movieTicketTime");
		return mv;
	}
}
