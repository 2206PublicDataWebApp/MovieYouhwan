package kr.co.movieyouhwan.admin.theater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.movieyouhwan.admin.cinema.service.CinemaService;
import kr.co.movieyouhwan.admin.theater.domain.Theater;
import kr.co.movieyouhwan.admin.theater.service.TheaterService;
import kr.co.movieyouhwan.user.cinema.domain.Cinema;

@Controller
public class TheaterController {
	@Autowired
	private CinemaService cService;
	@Autowired
	private TheaterService tService;
	
	/**
	 * 상영관 등록 화면(관리자)
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterRegister.yh", method=RequestMethod.GET)
	public ModelAndView TheaterRegisterView(
			ModelAndView mv,
			@ModelAttribute Cinema cinema) {
		List<Cinema> cList = cService.printAllCinema();
		mv.addObject("cList", cList);
		mv.setViewName("/admin/theater/adminTheaterRegister");
		return mv;
	}
	
	/**
	 * 상영관 등록(관리자)
	 * @param mv
	 * @param theater
	 * @param cinemaNo
	 * @return
	 */
	@RequestMapping(value="/admin/adminTheaterInsert.yh", method=RequestMethod.POST)
	public ModelAndView TheaterRegister(
			ModelAndView mv,
			@ModelAttribute Theater theater) {
		int result = tService.registerTheater(theater);
		mv.setViewName("redirect:/admin/adminCinemaList.yh");
		return mv;
	}
}
