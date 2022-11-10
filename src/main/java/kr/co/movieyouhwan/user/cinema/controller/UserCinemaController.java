package kr.co.movieyouhwan.user.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.movieyouhwan.admin.cinema.service.AdminCinemaService;
import kr.co.movieyouhwan.admin.movie.domain.Movie;
import kr.co.movieyouhwan.admin.movie.domain.MovieDay;
import kr.co.movieyouhwan.admin.movie.domain.MovieTime;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.cinema.service.UserCinemaService;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;

@Controller
public class UserCinemaController {
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private UserCinemaService uCinemaService;
	
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
		// 한개의 영화관 띄우기
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		// 영화관, 일별 영화 출력 (중복 제외)
		List<Movie> mList = uCinemaService.printMovieNowOne(cinemaNo, new MovieDay().getMovieDay(0));
		// 일별 영화 정보 출력
		List<CinemaMovie> cmList = uCinemaService.printCinemaMovieByDay(cinemaNo, new MovieDay().getMovieDay(0));
		session.setAttribute("cinemaNo", cinema.getCinemaNo());
		// 영화관 1개
		mv.addObject("cinema", cinema);
		// 일별 영화 정보 출력
		mv.addObject("mList", mList);
		mv.addObject("cmList", cmList);
		// 날짜 vo
		mv.addObject("movieDay", new MovieDay());
		mv.setViewName("/user/cinema/userCinemaMovie");
		return mv;
	}
	
	/**
	 * 영화관 별 영화 출력 AJAX
	 * @param cinemaNo
	 * @param movieDay
	 * @param dayIndex
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/user/cinemaMovieDay.yh", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String cinemaMovieDayChoice(
			@RequestParam("cinemaNo") Integer cinemaNo,
			@RequestParam(value="movieDay", required=false) String movieDay,
			@RequestParam(value="dayIndex", required=false) Integer dayIndex,
			HttpSession session) {
		dayIndex = dayIndex == null ? 0 : dayIndex;
		// 영화관, 일별 영화 출력 (중복 제외)
		List<Movie> mList = uCinemaService.printMovieNowOne(cinemaNo, new MovieDay().getMovieDay(dayIndex));
		// 일별 영화 정보 출력
		List<CinemaMovie> cmList = uCinemaService.printCinemaMovieByDay(cinemaNo, new MovieDay().getMovieDay(dayIndex)); // -> printCinemaMovieByDate
		System.out.print(dayIndex);
		Gson gson = new Gson();
		JSONObject object = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		object.put("mList", gson.toJson(mList));
		object.put("cmList", gson.toJson(cmList));
		jsonArray.add(object);
		return jsonArray.toJSONString();
	}
}