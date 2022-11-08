package kr.co.movieyouhwan.user.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieDay;
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;

@Controller
public class UserMovieController {
	@Autowired
	private AdminMovieService aMovieService;
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private UserMovieService uMovieService;
	
	/**
	 * 영화 현재 상영 목록 화면
	 * @param mv
	 * @param movie
	 * @return
	 */
	@RequestMapping(value="/movieList.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListNowView(
			ModelAndView mv) {
		List<MovieList> mlList = uMovieService.printAllMovieNow();
		mv.addObject("mlList", mlList);
		mv.setViewName("user/movie/movieListNow");
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
			ModelAndView mv) {
		List<Cinema> cList = aCinemaService.printAllCinema();
		List<Movie> mList = aMovieService.printNowMovie();
		mv.addObject("cList", cList);
		mv.addObject("mList", mList);
		mv.addObject("movieDay", new MovieDay());
		mv.setViewName("user/movie/movieTicketTime");
		return mv;
	}
}
