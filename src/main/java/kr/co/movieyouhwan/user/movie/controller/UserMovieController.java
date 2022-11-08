package kr.co.movieyouhwan.user.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
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
	 * 현재 상영 영화 목록 화면
	 * @param mv
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
	 * 상영 예정 영화 목록 화면
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/movieListAfter.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListAfterView(
			ModelAndView mv) {
		List<MovieList> mlList = uMovieService.printAllMovieAfter();
		mv.addObject("mlList", mlList);
		mv.setViewName("user/movie/movieListAfter");
		return mv;
	}
	
	/**
	 * 상영 종료 영화 목록 화면
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/movieListBefore.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListBeforeView(
			ModelAndView mv) {
		List<MovieList> mlList = uMovieService.printAllMovieBefore();
		mv.addObject("mlList", mlList);
		mv.setViewName("user/movie/movieListBefore");
		return mv;
	}
	
	/**
	 * 영화 검색 완료 리스트
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/movieSearchList.yh", method=RequestMethod.GET)
	public ModelAndView userMovieSearchListView(
			ModelAndView mv) {
		List<MovieList> mlList = uMovieService.printAllMovie();
		mv.addObject("mlList", mlList);
		mv.setViewName("user/movie/movieSearchList");
		return mv;
	}
	
	/**
	 * 영화 검색 기능
	 * @param mv
	 * @param searchName
	 * @return
	 */
	@RequestMapping(value="/movieListSearch.yh", method=RequestMethod.POST)
	public ModelAndView userMovieSearchList(
			ModelAndView mv,
			@RequestParam("searchName") String searchName) {
//		List<Movie> mList = uMovieService.printSearchMovie(searchName);
//		if(!mList.isEmpty()) {
//			mv.addObject("mList", mList);
//		}else {
//			mv.addObject("mList", null);
//		}
		mv.addObject("searchName", searchName);
		mv.setViewName("redirect:/movieSearchList.yh");
		return mv;
	}
	
	/**
	 * 영화 상세 페이지
	 * @param mv
	 * @param movieNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/movieDetail.yh", method=RequestMethod.GET)
	public ModelAndView userMovieDetailView(
			ModelAndView mv,
			@RequestParam("movieNo") Integer movieNo,
			HttpSession session) {
		Movie movie = aMovieService.printOneMovie(movieNo);
		List<MovieImg> miList = aMovieService.printAllMovieImg(movieNo);
		List<MovieVideo> mvList = aMovieService.printAllMovieVideo(movieNo);
		mv.addObject("movie", movie);
		mv.addObject("miList", miList);
		mv.addObject("mvList", mvList);
		mv.setViewName("user/movie/movieDetail");
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
