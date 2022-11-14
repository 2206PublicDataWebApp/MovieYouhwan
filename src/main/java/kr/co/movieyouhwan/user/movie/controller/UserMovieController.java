package kr.co.movieyouhwan.user.movie.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import kr.co.movieyouhwan.admin.movie.domain.MovieImg;
import kr.co.movieyouhwan.admin.movie.domain.MovieVideo;
import kr.co.movieyouhwan.admin.movie.service.AdminMovieService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.AdminTheaterService;
import kr.co.movieyouhwan.common.page.PageInfo;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;
import kr.co.movieyouhwan.user.cinema.domain.CinemaMovie;
import kr.co.movieyouhwan.user.cinema.service.UserCinemaService;
import kr.co.movieyouhwan.user.member.domain.Member;
import kr.co.movieyouhwan.user.movie.domain.MovieList;
import kr.co.movieyouhwan.user.movie.domain.MovieTicket;
import kr.co.movieyouhwan.user.movie.service.UserMovieService;

@Controller
public class UserMovieController {
	@Autowired
	private AdminMovieService aMovieService;
	@Autowired
	private AdminCinemaService aCinemaService;
	@Autowired
	private AdminTheaterService aTheaterService;
	@Autowired
	private UserMovieService uMovieService;
	
	/**
	 * 현재 상영 영화 목록 화면
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/movieList.yh", method=RequestMethod.GET)
	public ModelAndView userMovieListNowView(
			ModelAndView mv,
			@RequestParam(value="currentPage", required=false) Integer currentPage) {
		// 페이징 처리
		int page = (currentPage != null ? currentPage : 1);
		PageInfo pageInfo = new PageInfo(page, uMovieService.printNowMovieCount(), 12, 5);
		// 현재 상영 영화 리스트 가져오기
		List<MovieList> mlList = uMovieService.printAllMovieNow();
		// 화면 출력
		mv.addObject("pageInfo", pageInfo);
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
			ModelAndView mv,
			@RequestParam(value="currentPage", required=false) Integer currentPage) {
		// 페이징 처리
		int page = (currentPage != null ? currentPage : 1);
		PageInfo pageInfo = new PageInfo(page, uMovieService.printAfterMovieCount(), 12, 5);
		// 상영 예정 영화 리스트 가져오기
		List<MovieList> mlList = uMovieService.printAllMovieAfter();
		// 화면 출력
		mv.addObject("pageInfo", pageInfo);
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
			ModelAndView mv,
			@RequestParam(value="currentPage", required=false) Integer currentPage) {
		// 페이징 처리
		int page = (currentPage != null ? currentPage : 1);
		PageInfo pageInfo = new PageInfo(page, uMovieService.printBeforeMovieCount(), 12, 5);
		// 상영 종료 영화 목록 리스트 가져오기
		List<MovieList> mlList = uMovieService.printAllMovieBefore();
		// 화면 출력
		mv.addObject("pageInfo", pageInfo);
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
			ModelAndView mv,
			@RequestParam("searchName") String searchName) {
		// 영화 검색 완료 리스트 불러오기
		List<MovieList> mlList = uMovieService.printSearchMovie(searchName);
		// 화면출력
		if(!mlList.isEmpty()) {
			mv.addObject("mlList", mlList);
		}else {
			mv.addObject("mlList", null);
		}
		mv.addObject("searchName", searchName);
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
			@ModelAttribute Movie movie,
			@RequestParam("searchName") String searchName) {
		// searchValue가 null이면 "" 로 처리
 		// String search = (searchValue != null ? searchValue : "");
		// 영화 검색 완료 리스트 불러오기
		List<MovieList> mlList = uMovieService.printSearchMovie(searchName);
		// 화면출력
		if(!mlList.isEmpty()) {
			mv.addObject("mlList", mlList);
		}else {
			mv.addObject("mlList", null);
		}
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
			ModelAndView mv,
			HttpServletRequest request,
			@RequestParam(value="cinemaNo", required=false) Integer cinemaNo) {
		cinemaNo = cinemaNo == null ? 13 : cinemaNo;
		List<Cinema> cList = aCinemaService.printAllCinema();
		List<Movie> mList = uMovieService.printAllMovieCinema(cinemaNo);
		mv.addObject("cList", cList);
		mv.addObject("mList", mList);
		mv.addObject("movieDay", new MovieDay());
		mv.setViewName("user/movie/movieTicketTime");
		return mv;
	}
	
	/**
	 * 영화 예매 - 영화관, 영화 선택 AJAX
	 * @param cinemaNo
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/movieTicketTimeCinema.yh", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String movieTicketTimeCinemaChoice(
			@RequestParam(value="cinemaNo", required=false) Integer cinemaNo) {
		cinemaNo = cinemaNo == null ? 13 : cinemaNo;
		// 영화관별 상영 영화 출력
		List<Movie> mList = uMovieService.printAllMovieCinema(cinemaNo);
		Gson gson = new Gson();
		JSONObject object = new JSONObject();
		object.put("mList", gson.toJson(mList));
		return object.toJSONString();
	}
	
	/**
	 * 영화 예매 - 영화관, 영화, 상영 영화 선택 AJAX
	 * @param movie
	 * @param cinemaNo
	 * @param movieNo
	 * @param movieTitle
	 * @param movieDay
	 * @param dayIndex
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/movieTicketTimeMovie.yh", produces="application/json;charset=utf-8", method=RequestMethod.POST)
	public String movieTicketTimeChoice(
			@ModelAttribute Movie movie,
			@RequestParam(value="cinemaNo", required=false) Integer cinemaNo,
			@RequestParam(value="movieNo", required=false) Integer movieNo,
			@RequestParam(value="movieTitle", required=false) String movieTitle,
			@RequestParam(value="movieDay", required=false) String movieDay,
			@RequestParam(value="dayIndex", required=false) Integer dayIndex,
			HttpSession session) {
		dayIndex = dayIndex == null ? 0 : dayIndex;
		// 영화관 이름 출력
		Cinema cinema = aCinemaService.printOneCinema(cinemaNo);
		// 영화관, 일별 영화 출력 (중복 제외)
		List<Movie> mList = uMovieService.printTicketMovieOne(cinemaNo, movieNo, new MovieDay().getMovieDay(dayIndex));
		// 영화관, 영화, 일별 상영 영화 출력 (중복 포함)
		List<CinemaMovie> cmList = uMovieService.printTicketMovieByDay(cinemaNo, movieNo, new MovieDay().getMovieDay(dayIndex));
		// 영화별 영화 이미지 출력
		List<MovieImg> miList = aMovieService.printAllMovieImg(movieNo);
		Gson gson = new Gson();
		JSONObject object = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		object.put("cinema", gson.toJson(cinema));
		object.put("mList", gson.toJson(mList));
		object.put("cmList", gson.toJson(cmList));
		object.put("miList", gson.toJson(miList));
		jsonArray.add(object);
		return jsonArray.toJSONString();
	}
	
	/**
	 * 상영 좌석 선택
	 * @param mv
	 * @param cinemaNo
	 * @param movieNo
	 * @param theaterNo
	 * @param movieImgRename
	 * @param cinemaName
	 * @param movieTitle
	 * @param movieDay
	 * @param movieStart
	 * @param movieEnd
	 * @param theaterName
	 * @param movieTicket
	 * @param movieSeat
	 * @return
	 */
	@RequestMapping(value="/movieTicketSeat.yh", method=RequestMethod.POST)
	public ModelAndView movieTicketSeat(
			ModelAndView mv,
			@ModelAttribute Movie movie,
			@RequestParam("cinemaNo") Integer cinemaNo,
			@RequestParam("movieNo") Integer movieNo,
			@RequestParam("theaterNo") Integer theaterNo,
			@RequestParam("movieImgRename") String movieImgRename,
			@RequestParam("cinemaName") String cinemaName,
			@RequestParam("movieTitle") String movieTitle,
			@RequestParam("movieDay") String movieDay,
			@RequestParam("movieStart") String movieStart,
			@RequestParam("movieEnd") String movieEnd,
			@RequestParam("theaterName") String theaterName,
			@RequestParam("movieTicket") Integer movieTicket,
			@RequestParam("movieSeat") Integer movieSeat,
			HttpServletRequest request,
			HttpSession session) {
		// 상영관 정보 가져오기
		Theater theater = aTheaterService.printOneTheater(theaterNo);
		// 알파벳 리스트
		List<String> aToZ = new ArrayList<String>();
		for(int i = 65; i < 91; i++) {
		  aToZ.add(String.valueOf((char)i));
		}
		// 화면 출력
		mv.addObject("cinemaNo", cinemaNo);
		mv.addObject("movieNo", movieNo);
		mv.addObject("theaterNo", theaterNo);
		mv.addObject("movieImgRename", movieImgRename);
		mv.addObject("cinemaName", cinemaName);
		mv.addObject("movieTitle", movieTitle);
		mv.addObject("movieDay", movieDay);
		mv.addObject("movieStart", movieStart);
		mv.addObject("movieEnd", movieEnd);
		mv.addObject("theaterName", theaterName);
		mv.addObject("movieTicket", movieTicket);
		mv.addObject("movieSeat", movieSeat);
		mv.addObject("theater", theater);
		mv.addObject("abcd", aToZ);
		mv.setViewName("user/movie/movieTicketSeat");
		return mv;
	}
	
	/**
	 * 영화 예매 결제 화면
	 * @param mv
	 * @param request
	 * @param cinemaNo
	 * @param movieNo
	 * @param theaterNo
	 * @param movieImgRename
	 * @param cinemaName
	 * @param movieTitle
	 * @param movieDay
	 * @param movieStart
	 * @param movieEnd
	 * @param theaterName
	 * @param movieTicket
	 * @param movieSeat
	 * @param seatChoice
	 * @param adultCount
	 * @param teenagerCount
	 * @param adultPay
	 * @param teenagerPay
	 * @return
	 */
	@RequestMapping(value="/movieTicketPay.yh", method=RequestMethod.POST)
	public ModelAndView movieTicketPay(
			ModelAndView mv,
			HttpServletRequest request,
			@RequestParam("cinemaNo") Integer cinemaNo,
			@RequestParam("movieNo") Integer movieNo,
			@RequestParam("theaterNo") Integer theaterNo,
			@RequestParam("movieImgRename") String movieImgRename,
			@RequestParam("cinemaName") String cinemaName,
			@RequestParam("movieTitle") String movieTitle,
			@RequestParam("movieDay") String movieDay,
			@RequestParam("movieStart") String movieStart,
			@RequestParam("movieEnd") String movieEnd,
			@RequestParam("theaterName") String theaterName,
			@RequestParam("movieTicket") Integer movieTicket,
			@RequestParam("movieSeat") Integer movieSeat,
			@RequestParam("seatChoice") String seatChoice,
			@RequestParam("adultCount") Integer adultCount,
			@RequestParam("teenagerCount") Integer teenagerCount,
			@RequestParam("adultPay") Integer adultPay,
			@RequestParam("teenagerPay") Integer teenagerPay) {
		// 사용자 정보 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String userNick = member.getMemberNick();
		String userPoint = member.getMemberPoint();
		String userBirth = member.getMemberBirth();
		String userGender = member.getMemberGender();
		// 화면 출력
		mv.addObject("cinemaNo", cinemaNo);
		mv.addObject("movieNo", movieNo);
		mv.addObject("theaterNo", theaterNo);
		mv.addObject("movieImgRename", movieImgRename);
		mv.addObject("cinemaName", cinemaName);
		mv.addObject("movieTitle", movieTitle);
		mv.addObject("movieDay", movieDay);
		mv.addObject("movieStart", movieStart);
		mv.addObject("movieEnd", movieEnd);
		mv.addObject("theaterName", theaterName);
		mv.addObject("movieTicket", movieTicket);
		mv.addObject("movieSeat", movieSeat);
		mv.addObject("seatChoice", seatChoice);
		mv.addObject("userNick", userNick);
		mv.addObject("userPoint", userPoint);
		mv.addObject("userBirth", userBirth);
		mv.addObject("userGender", userGender);
		mv.addObject("adultCount", adultCount);
		mv.addObject("teenagerCount", teenagerCount);
		mv.addObject("adultPay", adultPay);
		mv.addObject("teenagerPay", teenagerPay);
		mv.setViewName("user/movie/movieTicketPay");
		return mv;
	}
	
	/**
	 * 영화 예매자 정보 가져오기
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/movie/pay/buyer.yh", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	public String moviePayBuyer(
			HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject();
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		Member buyerInfo = uMovieService.printBuyerInfo(member.getMemberId());
		jsonObj.put("memberName", buyerInfo.getMemberName());
		jsonObj.put("memberPhone", buyerInfo.getMemberPhone());
		jsonObj.put("memberEmail", buyerInfo.getMemberEmail());
		return jsonObj.toString();
	}
	
	/**
	 * 영화 결제
	 * @param request
	 * @param movieTicket
	 * @param paid_at
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/movie/pay.yh", method = RequestMethod.POST)
	public String moviePay(
			HttpServletRequest request,
			@ModelAttribute MovieTicket movieTicket,
			@RequestParam("paid_at") long paid_at,
			@RequestParam("status") String status) {
		movieTicket.setPayDate(new Date(paid_at));
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="/movieTicketComplete.yh", method=RequestMethod.GET)
	public String movieComplete(
			Model model,
			@RequestParam("movieName") String movieName) {
		model.addAttribute("movieName", movieName);
		return "user/movie/movieTicketComplete";
	}
}