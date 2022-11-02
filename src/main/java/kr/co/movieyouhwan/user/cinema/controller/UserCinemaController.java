package kr.co.movieyouhwan.user.cinema.controller;

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
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class UserCinemaController {
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private AdminMovieService aMovieService;
	
	/**
	 * 영화관 리스트
	 * @param mv
	 * @param cinema
	 * @return
	 */
	@RequestMapping(value="/user/cinemaList.yh", method=RequestMethod.GET)
	public ModelAndView userCinemaListView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema) {
		List<Cinema> cList = aCinemaService.printAllCinema();
		mv.addObject("cList", cList);
		mv.setViewName("user/cinema/userCinemaList");
		return mv;
	}
	
	/**
	 * 영화관 정보 화면
	 * @param mv
	 * @param cinemaNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/cinemaInformation.yh", method=RequestMethod.GET)
	public ModelAndView userCinemaInformationView(
			ModelAndView mv,
			@RequestParam("cinemaNo") Integer cinemaNo,
			HttpSession session) {
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		session.setAttribute("cinemaNo", cinema.getCinemaNo());
		mv.addObject("cinema", cinema);
		mv.setViewName("/user/cinema/userCinemaInformation");
		return mv;
	}
	
	/**
	 * 영화관 영화 화면
	 * @param mv
	 * @param cinemaNo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/cinemaMovie.yh", method=RequestMethod.GET)
	public ModelAndView userCinemaMovieView(
			ModelAndView mv,
			@RequestParam("cinemaNo") Integer cinemaNo,
			HttpSession session) {
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		List<Movie> mList = aMovieService.printAllMovie();
		session.setAttribute("cinemaNo", cinema.getCinemaNo());
		// 영화관 1개
		mv.addObject("cinema", cinema);
		// 영화 전체
		mv.addObject("mList", mList);
		// 날짜 vo
		mv.addObject("movieDay", new MovieDay());
		mv.setViewName("/user/cinema/userCinemaMovie");
		return mv;
	}
}
